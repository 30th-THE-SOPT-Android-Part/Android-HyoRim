package org.sopt.android_hyorim_30th.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.databinding.ActivityHomeBinding
import org.sopt.android_hyorim_30th.ui.base.BaseActivity
import org.sopt.android_hyorim_30th.ui.home.HomeViewModel.Companion.GIT_FOLLOWER
import org.sopt.android_hyorim_30th.ui.home.HomeViewModel.Companion.GIT_REPOSITORY
import org.sopt.android_hyorim_30th.ui.home.gitFollower.GitFollowerFragment
import org.sopt.android_hyorim_30th.ui.home.gitRepository.GitRepositoryFragment

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        setDefaultFragment()
        setSelectedFragment()
    }

    private fun initViewModel() {
        binding.viewModel = homeViewModel
        binding.lifecycleOwner = this
    }

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
}
