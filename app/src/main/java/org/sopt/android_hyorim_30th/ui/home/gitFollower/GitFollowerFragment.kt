package org.sopt.android_hyorim_30th.ui.home.gitFollower

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.GitFollowerData
import org.sopt.android_hyorim_30th.databinding.FragmentGitFollowerBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment
import org.sopt.android_hyorim_30th.ui.detail.DetailActivity.Companion.navigate
import org.sopt.android_hyorim_30th.ui.home.gitFollower.adapter.GitFollowerAdapter

class GitFollowerFragment :
    BaseFragment<FragmentGitFollowerBinding>(R.layout.fragment_git_follower) {
    private lateinit var gitFollowerAdapter: GitFollowerAdapter
    private val gitFollowerViewModel: GitFollowerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingViewModel()
        initAdapter()
    }

    private fun bindingViewModel() {
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        binding.rvFollower.adapter =
            GitFollowerAdapter(::onItemClick).also { gitFollowerAdapter = it }
        gitFollowerAdapter.submitList(gitFollowerViewModel.follower.value)
    }

    private fun onItemClick(follower: GitFollowerData) {
        navigate(requireActivity(), follower)
    }
}
