package org.sopt.android_hyorim_30th.ui.home.gitRepository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.GitRepositoryData
import org.sopt.android_hyorim_30th.databinding.FragmentGitRepositoryBinding
import org.sopt.android_hyorim_30th.ui.base.BaseFragment

class GitRepositoryFragment :
    BaseFragment<FragmentGitRepositoryBinding>(R.layout.fragment_git_repository) {
    private lateinit var gitRepositoryAdapter: GitRepositoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        binding.rvRepository.adapter =
            GitRepositoryAdapter(::onItemClick).also { gitRepositoryAdapter = it }
        gitRepositoryAdapter.submitList(dummyData)
    }

    private fun onItemClick(repository: GitRepositoryData) {
        Toast.makeText(requireContext(), repository.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val dummyData = listOf(
            GitRepositoryData(
                "MVVMdiaryExample",
                "MVVM 무작정 따라하기 스터디"
            ),
            GitRepositoryData(
                "JsoupSample",
                "Practice Crawling Meta Data (Web Scrapping)"
            ),
            GitRepositoryData(
                "Architecture-Components",
                "GuessTheWord-Starter"
            ),
            GitRepositoryData(
                "RaspberryControl",
                "2021 SSWU Smart System Capstone Design / Smart Multitap Project with Deep Learning."
            )
        )
    }
}
