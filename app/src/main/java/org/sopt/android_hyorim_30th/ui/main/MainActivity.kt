package org.sopt.android_hyorim_30th.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.type.GitViewType
import org.sopt.android_hyorim_30th.databinding.ActivityMainBinding
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.android_hyorim_30th.ui.main.profile.gitFollower.GitFollowerFragment
import org.sopt.android_hyorim_30th.ui.main.profile.gitRepository.GitRepositoryFragment

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        setDefaultFragment()
        setSelectedFragment()
    }

    private fun setDefaultFragment() {
        setFragmentWith<GitFollowerFragment>()
    }

    private fun setSelectedFragment() {
        mainViewModel.selectedFragment.observe(this) {
            when (it) {
                GitViewType.GIT_FOLLOWER -> setFragmentWith<GitFollowerFragment>()
                GitViewType.GIT_REPOSITORY -> setFragmentWith<GitRepositoryFragment>()
                else -> throw IllegalArgumentException()
            }
        }
    }

    private inline fun <reified T : Fragment> setFragmentWith() {
        supportFragmentManager.commit {
            replace<T>(R.id.container)
        }
    }
}
