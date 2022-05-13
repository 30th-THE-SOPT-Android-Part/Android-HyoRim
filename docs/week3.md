## 시연영상


https://user-images.githubusercontent.com/59546818/167158935-af8875bd-b85c-449d-a8a9-b52fde2c2686.mp4



## Level1

과제에 디자인 적용하기

### 1. Themes

1. **Font Padding**

   `themes`에 `<item name="android:includeFontPadding">false</item>` 속성을 추가

2. **Text Style**

    Zeplin의 **Style Guide**에 **Text style catalog** 를 `themes`에 추가

   ```xml
   <style name="header_h1">
       <item name="android:fontFamily">@font/noto_sans_kr</item>
       <item name="android:textStyle">bold</item>
       <item name="android:textSize">14sp</item>
   </style>
   ```

    xml에서 `android:textAppearance="@style/header_h1"` 로 호출

3. **Bottom Navigation Style**

   BottomNavigation의 Label에 폰트를 적용하기 위해서는 theme에 style을 추가해야한다.

   ```xml
   <style name="Widget.BottomNavigationView"
       parent="Widget.Design.BottomNavigationView">
       <item name="fontFamily">@font/noto_sans_kr_medium</item>
       <item name="android:textSize">10sp</item>
   </style>
   ```

4. **Status Bar Color**

   Status bar text color의 경우 status bar의 색상에 따라 false, true로 조정할 수 있다

   ```
   <!-- Status bar color. -->
   <item name="android:statusBarColor" tools:targetApi="l">@color/gray_status_bar</item>
   <item name="android:windowLightStatusBar" tools:targetApi="m">true</item>
   ```



### 2. Selector

```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item ... />
    <item ... />
</selector>
```

1. **Bottom Navigation**

   Bottom Navigation은 SVG 아이콘과 Text 변경 (color, state_checked)

   activity_home.xml

   ```
   app:itemIconTint="@color/selector_bottom_navi"
   app:itemRippleColor="#FFFFFF"
   app:itemTextColor="@color/selector_bottom_navi"
   ```

   selecor_bottom_navi.xml

   ```
   <item android:color="@color/bubblegum" android:state_checked="true" />
   <item android:color="#8f9090" android:state_checked="false" />
   ```

2. **Button / EditText**

   둘다 drawable에 shape값을 가진 xml 지정

   Button - state_selected

   EditText - state_focused

   ```
   <item android:drawable="@drawable/rectangle_fill_gray_btn" android:state_selected="false"/>
   <item android:drawable="@drawable/rectangle_fill_orange" android:state_selected="true"/>
   ```

3. **Text**

   Button의 클릭 여부에 따라 색을 다르게 지정하려면 코드와 함께 아래 코드를 사용해야 한다.

   ex) `binding.followerBtn.isSelected = true`

   ```
   <item android:color="@color/black_text" android:state_selected="false" />
   <item android:color="@color/white" android:state_selected="true" />
   ```



### 3. Glide 활용

dependencies 추가

```
implementation 'com.github.bumptech.glide:glide:4.12.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
```

Glide를 적용할 ProfileFragment에 데이터 바인딩을 적용해둠.

따라서 이미지를 처리하는 BindingAdapter 안의 Glide코드에 circleCrop() 메소드 추가

```
@BindingAdapter("imageSrc")
@JvmStatic
fun loadImage(imageView : ImageView, url : Int){
    Glide.with(imageView.context)
        .load(url)
        .circleCrop()
        .into(imageView)
}
```



### 4. Bottom Navigation

 **ViewPager2**

1. Fragment 생성

2. Layout에 ViewPager2 배치

3. ViewPagerAdapter 구현

4. ViewPager2와 Adapter 연동

   - fragmentList 초기화
   - Adapter 초기화
   - Adapter.fragments.addAll(fragmentList)
   - UI단에 Adapter 연결

   **Bottom Navigation**

5. 아이콘 만들기(vector asset)

6. menu.xml 만들기

7. Color Selector 만들기

8. Layout에 BottomNavigationView추가

9. BottomNavigation과 ViewPager2 연동



### 5. Tab Layout

1. Fragment 생성
2. Layout에 TabLayout, ViewPager2 배치
3. Adapter 연동(생성자 : fragment)
4. ViewPager2와 TabLayout 연동





## Level2

### 중첩 스크롤 문제

`ViewPager2` does not natively support nested scroll views in cases where the scroll view has the same orientation as the `ViewPager2` object that contains it.

To support a scroll view inside a `ViewPager2` object with the same orientation, you must call [`requestDisallowInterceptTouchEvent()`](https://developer.android.com/reference/android/view/ViewGroup#requestDisallowInterceptTouchEvent(boolean)) on the `ViewPager2` object when you expect to scroll the nested element instead. The [ViewPager2 nested scrolling sample](https://github.com/android/views-widgets-samples/blob/master/ViewPager2/app/src/main/res/layout/item_nested_recyclerviews.xml#L43) demonstrates one way of solving this problem with a versatile [custom wrapper layout](https://github.com/android/views-widgets-samples/blob/master/ViewPager2/app/src/main/java/androidx/viewpager2/integration/testapp/NestedScrollableHost.kt). (출처 : android developer)

[custom wrapper layout](https://github.com/android/views-widgets-samples/blob/master/ViewPager2/app/src/main/java/androidx/viewpager2/integration/testapp/NestedScrollableHost.kt) 의 코드를`NestedScrollableHost.kt` 으로 추가 후

Layout 에서 ViewPager2를 NestedScrollableHost로 감싸기



### 추가로 알게된 내용 : FragmentManager

**Activity와 Fragment 간의 화면 전환**

지난주 과제에서는 `HomeActivity`에서 Viewpager2를 활용하여 Fragment1과 Fragment2를 전환하였다.

그러나 이번주 과제의 경우 `FragmentProfile` 안에서 Fragment1과 Fragment2를 전환하고자 했다.

Activity의 내용을 Fragment로 옮기는 단순한 작업이라 생각했는데, 예상치 못한 에러가 발생했다.

**FragmentManager**에는 세 종류가 있다.

- supportFragmentManager (기존)
- parentFragmentManager (변경)
- childFragmentManager

supportFragmentManager 를 parentFragmentManager로 변경하여 에러를 해결하였다.

[![img](https://camo.githubusercontent.com/645c98be236fb099c246f4b559ba57bcaf32ca92d4d28b5e96fd29d85ff38eac/68747470733a2f2f646576656c6f7065722e616e64726f69642e636f6d2f696d616765732f67756964652f667261676d656e74732f6d616e616765722d6d617070696e67732e706e673f686c3d6b6f)](https://camo.githubusercontent.com/645c98be236fb099c246f4b559ba57bcaf32ca92d4d28b5e96fd29d85ff38eac/68747470733a2f2f646576656c6f7065722e616e64726f69642e636f6d2f696d616765732f67756964652f667261676d656e74732f6d616e616765722d6d617070696e67732e706e673f686c3d6b6f)

(출처 : [https://velog.io/@renovatio_hyuns/Activity%EC%99%80-Fragment%EA%B0%84%EC%9D%98-%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98](https://velog.io/@renovatio_hyuns/Activity와-Fragment간의-화면전환))
