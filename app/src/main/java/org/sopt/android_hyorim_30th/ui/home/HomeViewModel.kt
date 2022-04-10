package org.sopt.android_hyorim_30th.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.android_hyorim_30th.R

class HomeViewModel : ViewModel() {
    val profileImage = MutableLiveData(R.drawable.loopy)
    val userName = MutableLiveData("루피")
    val userAge = MutableLiveData(4)
    val userMBTI = MutableLiveData("BABY")
    val userIntroduction = MutableLiveData(setIntroductionString())

    private fun setIntroductionString(): String {
        var temp = ""
        for (i in 0..150) temp += "군침이 싹도누!\n"
        return temp
    }

}