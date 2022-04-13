package org.sopt.android_hyorim_30th.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.android_hyorim_30th.R

class HomeViewModel : ViewModel() {
    private val _profileImage = MutableLiveData(R.drawable.loopy)
    val profileImage: LiveData<Int> = _profileImage
    private val _userName = MutableLiveData("루피")
    val userName: LiveData<String> = _userName
    private val _userAge = MutableLiveData(4)
    val userAge: LiveData<Int> = _userAge
    private val _userMBTI = MutableLiveData("BABY")
    val userMBTI: LiveData<String> = _userMBTI
    private val _userIntroduction = MutableLiveData("군침이 싹도누!\n".repeat(150))
    val userIntroduction: LiveData<String> = _userIntroduction
}