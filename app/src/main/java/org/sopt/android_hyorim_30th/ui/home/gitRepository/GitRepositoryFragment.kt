package org.sopt.android_hyorim_30th.ui.home.gitRepository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.GitRepositoryData
import org.sopt.android_hyorim_30th.databinding.FragmentGitRepositoryBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment
import org.sopt.android_hyorim_30th.ui.home.gitRepository.adapter.GitRepositoryAdapter

class GitRepositoryFragment :
    BaseFragment<FragmentGitRepositoryBinding>(R.layout.fragment_git_repository) {
    private lateinit var gitRepositoryAdapter: GitRepositoryAdapter
    private val gitRepositoryViewModel: GitRepositoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initAdapter()
        bindingViewModel()
        return binding.root
    }

    private fun bindingViewModel() {
        binding.lifecycleOwner = this
    }

    private fun initAdapter() {
        binding.rvRepository.adapter =
            GitRepositoryAdapter(::onItemClick).also { gitRepositoryAdapter = it }
        gitRepositoryAdapter.submitList(gitRepositoryViewModel.repository.value)
    }

    private fun onItemClick(repository: GitRepositoryData) {
        Toast.makeText(requireContext(), repository.title, Toast.LENGTH_SHORT).show()
    }
}
