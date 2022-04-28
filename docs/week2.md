## 0️⃣ 구현 화면



#### 1. HomeActivity (GitFollowerFragment + GitRepository Fragment) 

#### 2. DetailActivity : 세부 이동 화면



![ezgif com-gif-maker](https://user-images.githubusercontent.com/59546818/164740515-f58f3873-864b-40c3-b7c6-8884c43cbfd2.gif)




## 1️⃣필수과제

### FragmentTransaction, RecyclerView

#### 📌 Default Fragment 세팅 및 Fragment 전환

`HomeActivity.kt`

```kotlin
private fun setDefaultFragment() {
    setFragmentWith(GitFollowerFragment())
}

private fun setSelectedFragment() {
    homeViewModel.selectedFragment.observe(this) {
        when (it) {
            GIT_FOLLOWER -> setFragmentWith(GitFollowerFragment())
            GIT_REPOSITORY -> setFragmentWith(GitRepositoryFragment())
        }
    }
}

private fun setFragmentWith(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.container, fragment)
        .commit()
}
```

`HomeViewModel.kt`

```kotlin
var selectedFragment = MutableLiveData(GIT_FOLLOWER)

fun onClickFollowerBtn() {
	selectedFragment.value = GIT_FOLLOWER
}

fun onClickRepositoryBtn() {
	selectedFragment.value = GIT_REPOSITORY
}

companion object {
	const val GIT_FOLLOWER = "GIT_FOLLOWER"
	const val GIT_REPOSITORY = "GIT_REPOSITORY"
}
```



#### 📌 RecyclerView

1. data class 생성
2. item layout 생성
3. 위치시키고자 하는 뷰에 RecyclerView 할당
4. RecyclerViewAdapter 생성
5. RecyclerView 데이터 세팅

**GitFollowerAdapter 구현 코드**

```kotlin
package org.sopt.android_hyorim_30th.ui.home.gitFollower

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.android_hyorim_30th.data.GitFollowerData
import org.sopt.android_hyorim_30th.databinding.ItemGitFollowerBinding

class GitFollowerAdapter(
    private val onItemClick: ((GitFollowerData) -> Unit)
) : ListAdapter<GitFollowerData, GitFollowerAdapter.ViewHolder>(GitFollowerComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGitFollowerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val follower = getItem(position)
        holder.bind(follower, onItemClick)
    }

    class ViewHolder(
        private val binding: ItemGitFollowerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(follower: GitFollowerData, onItemClick: ((GitFollowerData) -> Unit)) {
            binding.gitFollowerData = follower
            binding.root.setOnClickListener { onItemClick(follower) }
        }
    }

    private class GitFollowerComparator : DiffUtil.ItemCallback<GitFollowerData>() {
        override fun areItemsTheSame(oldItem: GitFollowerData, newItem: GitFollowerData) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GitFollowerData, newItem: GitFollowerData) =
            oldItem == newItem
    }
}
```



## 2️⃣성장과제

#### 1. DetailActivity 이동 

아래와 같이 Adapter의 생성자로 람다 함수를 넘겨주어 처리함

```kotlin
class GitFollowerAdapter(
    private val onItemClick: ((GitFollowerData) -> Unit)) : ...
```

```kotlin
// Fragment

binding.rvFollower.adapter =
	GitFollowerAdapter(::onItemClick).also { gitFollowerAdapter = it }

private fun onItemClick(follower: GitFollowerData) {
    val intent = Intent(requireContext(), DetailActivity::class.java)
    intent.putExtra(GIT_DATA, follower)
    startActivity(intent)
}
```



```kotlin
// Fragment

binding.rvFollower.adapter =
	GitFollowerAdapter(::onItemClick).also { gitFollowerAdapter = it }

private fun onItemClick(follower: GitFollowerData) {
    val intent = Intent(requireContext(), DetailActivity::class.java)
    intent.putExtra(GIT_DATA, follower)
    startActivity(intent)
}
```





## 3️⃣도전과제

#### 1. BaseActivity, BaseFragment 사용

```kotlin
abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
    AppCompatActivity() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }
}
```

```kotlin
abstract class BaseFragment<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    Fragment() {
    private var _binding: B? = null
    val binding: B get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
```





### 2. notifyDataSetChange의 문제점은 DiffUtil 사용
