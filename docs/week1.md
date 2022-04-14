## 0️⃣ 구현 화면

| SignInActivity                                               | SignUpActivity                                               | HomeActivity                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![signin](https://user-images.githubusercontent.com/59546818/162624695-b8248387-283d-4f92-b6be-8be5279cd56d.gif) | ![signup](https://user-images.githubusercontent.com/59546818/162624692-f82ec3f5-7539-4955-be32-b31a4534bd12.gif) | ![home](https://user-images.githubusercontent.com/59546818/162624696-97f2ec1c-0ecf-432b-bcf8-a353d417e85d.gif) |





## 1️⃣필수과제

### 1-1. 로그인 페이지 만들기

- EditText, TextView, Button 사용

- EditText의 hint 속성 사용

  ```
  android:hint="@string/hint_enter_pw"
  ```

- `isNotBlank()` 메소드를 활용 하여 EditText의 빈 값 확인

### 1-2. 회원가입 페이지 만들기

- 1-1과 동일

### 1-3. 자기소개 페이지 만들기

- ImageView, TextView 활용



## 2️⃣성장과제

### 2-1 화면이동 + @

```kotlin
// onCreate에서 호출
private fun initActivityLauncher() {
    signInActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when (it.resultCode) {
                Activity.RESULT_OK -> setDataFromSignUp(it.data)
                else -> shortToast("문제가 발생했습니다 : $it")
            }
        }
}

// 버튼 눌렸을 때
fun initSignUpBtnClick(view: View) {
    val intent = Intent(this, SignUpActivity::class.java)
    signInActivityLauncher.launch(intent)
}
```

### 2-2 ScrollView & ConstraintDimensionRatio

#### 📌 ScrollView

```xml
<androidx.constraintlayout.widget.ConstraintLayout ..>
    <androidx.core.widget.NestedScrollView ...>
		<!- ConstraintLayout을 ViewGroup으로 지정하여 View 배치 ->
        <androidx.constraintlayout.widget.ConstraintLayout ...>
```

#### 📌ConstraintDimensionRatio

```xml
<ImageView
    android:id="@+id/profile_photo"
    android:layout_width="0dp"
    android:layout_height="0dp"
    android:scaleType="fitXY"
    app:layout_constraintDimensionRatio="1:1"
    ... />
```







## 3️⃣도전과제

### 3-1 DataBinding

📝 **ViewBinding**

View binding is a feature that allows you to more easily write code that interacts with views. Once view binding is enabled in a module, it generates a binding class for each XML layout file present in that module. An instance of a binding class contains direct references to all views that have an ID in the corresponding layout.
In most cases, view binding replaces findViewById.


📝 **DataBinding**

The Data Binding Library is a support library that allows you to **bind UI components in your layouts to data sources** in your app using a **declarative format rather than programmatically.** -Android Developer


여기서 Declarative는 직역하면 '선언적'이라는 말이 된다.
eclarative format : `@{}` notation을 사용하여 Data Sources 부분과 연결
Prgrammatically : `(UIcomponent).setText("...")` 와 같이 코드로 일일이 구현

장점 : 코드 간결 & nullpointerexception 방지



### 3-2 MVVM 

(Databinding / Viewmodel까지 사용하였습니다)

#### 1-1. 아키텍쳐 사용 이유

우리는 다른 사람과 함께일을 해야되고, 내가 남의 코드를, 남의 코드를 내가 보게 된다.

협업을 위해서 어느 위치에 어떤 로직이 들어있나를 미리 정의해 놓기에 사용함.

#### 1-2. 아키텍쳐 장점

- 유지보수 용이) 아키텍처를 적용한 프로젝트는 많은 사람들이 코드를 알아보기 쉬워진다
- 코드의 역할이 잘 분리된다
- 의존 관계가 잘 분리가 된다. 즉, 변화에 유연함

#### 1-3. 아키텍쳐 단점

- 특정 아키텍처로 개발을 시작하면, 바꾸기가 많이 어려움

  따라서, 프로젝트에 맞지 않는 아키텍처 구조임을 인지하게돼도, 구조 자체를 변경하기 힘들어서 비효율 적인 코드로 개발해야함

- 생산속도가 떨어진다 👉 기능 하나 만들 때마다 파일이 많이 만들어 짐 👉 보일러플레이팅 코드 증가


## 알게 된 점
- xml 작업을 할 때 guildLine 적용을 처음 해봄
