package org.sopt.android_hyorim_30th.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.GitFollowerData
import org.sopt.android_hyorim_30th.databinding.ActivityDetailBinding
import org.sopt.android_hyorim_30th.ui.base.BaseActivity

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingViewModel()
        setGitData()
    }

    private fun setGitData() {
        val intentData = intent.getParcelableExtra<GitFollowerData>(GIT_DATA)
        detailViewModel.setGitData(intentData ?: return)
    }

    private fun bindingViewModel() {
        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this
    }

    companion object {
        const val GIT_DATA = "GIT_DATA"
    }
}
