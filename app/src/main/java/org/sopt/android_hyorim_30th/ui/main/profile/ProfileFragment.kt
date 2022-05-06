package org.sopt.android_hyorim_30th.ui.main.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.type.GitViewType
import org.sopt.android_hyorim_30th.databinding.FragmentProfileBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment
import org.sopt.android_hyorim_30th.ui.main.MainViewModel
import org.sopt.android_hyorim_30th.ui.main.profile.gitFollower.GitFollowerFragment
import org.sopt.android_hyorim_30th.ui.main.profile.gitRepository.GitRepositoryFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        setDefaultFragment()
        setSelectedFragment()
    }

    private fun setDefaultFragment() {
        setFragmentWith<GitFollowerFragment>()
    }

    private fun setSelectedFragment() {
        mainViewModel.selectedFragment.observe(requireActivity()) {
            when (it) {
                GitViewType.GIT_FOLLOWER -> setFragmentWith<GitFollowerFragment>()
                GitViewType.GIT_REPOSITORY -> setFragmentWith<GitRepositoryFragment>()
                else -> throw IllegalArgumentException()
            }
        }
    }

    private inline fun <reified T : Fragment> setFragmentWith() {
        childFragmentManager.commit {
            replace<T>(R.id.container)
        }
    }
}
