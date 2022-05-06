package org.sopt.android_hyorim_30th.ui.main.profile.gitRepository

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.GitRepositoryData
import org.sopt.android_hyorim_30th.databinding.FragmentGitRepositoryBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment
import org.sopt.android_hyorim_30th.ui.main.profile.gitRepository.adapter.GitRepositoryAdapter
import org.sopt.android_hyorim_30th.util.shortToast

class GitRepositoryFragment :
    BaseFragment<FragmentGitRepositoryBinding>(R.layout.fragment_git_repository) {
    private lateinit var gitRepositoryAdapter: GitRepositoryAdapter
    private val gitRepositoryViewModel: GitRepositoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = this
        initAdapter()
        initRepositoryList()
    }

    private fun initAdapter() {
        binding.rvRepository.adapter =
            GitRepositoryAdapter(::onItemClick).also { gitRepositoryAdapter = it }
    }

    private fun initRepositoryList() {
        gitRepositoryViewModel.repository.observe(viewLifecycleOwner) { list ->
            if (list != null) gitRepositoryAdapter.submitList(list)
        }
    }

    private fun onItemClick(repository: GitRepositoryData) {
        requireContext().shortToast(repository.title)
    }
}
