package org.sopt.android_hyorim_30th.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val userName = MutableLiveData("")
    val userId = MutableLiveData("")
    val userPw = MutableLiveData("")

    val isInputComplete: Boolean
        get() = (userName.value?.isNotBlank() ?: false) && (userId.value?.isNotBlank()
            ?: false) && (userPw.value?.isNotBlank() ?: false)
}