package org.sopt.android_hyorim_30th.ui.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {
    val userId = MutableLiveData("")
    val userPw = MutableLiveData("")
    val isInputComplete: Boolean
        get() = (userId.value?.isNotBlank() ?: false) && (userPw.value?.isNotBlank() ?: false)
}
