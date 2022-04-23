package org.sopt.android_hyorim_30th.ui.home.gitFollower

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.GitFollowerData
import org.sopt.android_hyorim_30th.databinding.FragmentGitFollowerBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment
import org.sopt.android_hyorim_30th.ui.detail.DetailActivity
import org.sopt.android_hyorim_30th.ui.detail.DetailActivity.Companion.GIT_DATA
import org.sopt.android_hyorim_30th.ui.home.gitFollower.adapter.GitFollowerAdapter

class GitFollowerFragment :
    BaseFragment<FragmentGitFollowerBinding>(R.layout.fragment_git_follower) {
    private lateinit var gitFollowerAdapter: GitFollowerAdapter
    private val gitFollowerViewModel: GitFollowerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initAdapter()
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        binding.rvFollower.adapter =
            GitFollowerAdapter(::onItemClick).also { gitFollowerAdapter = it }
        gitFollowerAdapter.submitList(gitFollowerViewModel.follower.value)
    }

    private fun onItemClick(follower: GitFollowerData) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(GIT_DATA, follower)
        startActivity(intent)
    }
}
