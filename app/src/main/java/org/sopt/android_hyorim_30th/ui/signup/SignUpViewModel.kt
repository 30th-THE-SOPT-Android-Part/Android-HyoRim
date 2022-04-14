package org.sopt.android_hyorim_30th.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val userName = MutableLiveData("")
    val userId = MutableLiveData("")
    val userPw = MutableLiveData("")

    val isInputComplete
        get() = !userName.value.isNullOrBlank() && !userId.value.isNullOrBlank() && !userPw.value.isNullOrBlank()
}
