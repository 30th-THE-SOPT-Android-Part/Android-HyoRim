package org.sopt.android_hyorim_30th.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.android_hyorim_30th.R
import org.sopt.android_hyorim_30th.data.type.GitViewType

class MainViewModel : ViewModel() {
    val profileImage = R.drawable.loopy
    val userName = "김루피"
    val userAge = 4
    val userMBTI = "BABY"
    val userIntroduction = "나는야 잔망루피! 군침이 싹도누 🙃"
    var selectedFragment = MutableLiveData(GitViewType.GIT_FOLLOWER)

    fun onClickFollowerBtn() {
        selectedFragment.value = GitViewType.GIT_FOLLOWER
    }

    fun onClickRepositoryBtn() {
        selectedFragment.value = GitViewType.GIT_REPOSITORY
    }
}
