package org.sopt.android_hyorim_30th.ui.detail

import android.app.Activity
import android.content.Intent
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

    private fun bindingViewModel() {
        binding.viewModel = detailViewModel
        binding.lifecycleOwner = this
    }

    private fun setGitData() {
        detailViewModel.setGitData(parseIntent(intent))
    }

    companion object {
        fun navigate(activity: Activity, followerData: GitFollowerData) {
            activity.startActivity(
                Intent(activity, DetailActivity::class.java).apply {
                    putExtra("followerData", followerData)
                }
            )
        }

        private fun parseIntent(intent: Intent): GitFollowerData =
            intent.getParcelableExtra("followerData") ?: throw IllegalArgumentException()
    }
}
