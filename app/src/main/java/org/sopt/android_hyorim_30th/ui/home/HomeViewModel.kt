package org.sopt.android_hyorim_30th.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.android_hyorim_30th.R

class HomeViewModel : ViewModel() {
    val profileImage = R.drawable.loopy
    val userName = "루피"
    val userAge = 4
    val userMBTI = "BABY"
    val userIntroduction = "군침이 싹도누 🙃"
    var selectedFragment = MutableLiveData(GIT_FOLLOWER)

    fun onClickFollowerBtn() {
        selectedFragment.value = GIT_FOLLOWER
    }

    fun onClickRepositoryBtn() {
        selectedFragment.value = GIT_REPOSITORY
    }

    companion object {
        const val GIT_FOLLOWER = "GIT_FOLLOWER"
        const val GIT_REPOSITORY = "GIT_REPOSITORY"
    }
}
