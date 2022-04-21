package org.sopt.android_hyorim_30th.ui.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.android_hyorim_30th.data.local.SOPTSharedPreference
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val preference: SOPTSharedPreference
) : ViewModel() {
    val userId = MutableLiveData("")
    val userPw = MutableLiveData("")
    private val _isIdLoadedAuto = MutableLiveData(false)
    val isIdLoadedAuto: LiveData<Boolean> = _isIdLoadedAuto
    val isInputComplete
        get() = !userId.value.isNullOrBlank() && !userPw.value.isNullOrBlank()

    init {
        userId.value = if (preference.isAutoLogin) preference.userId else ""
        _isIdLoadedAuto.value = preference.isAutoLogin
    }

    fun toggleSaveId() {
        _isIdLoadedAuto.value = !(_isIdLoadedAuto.value ?: throw IllegalStateException())
    }

    fun setPreference() {
        _isIdLoadedAuto.value?.let {
            preference.isAutoLogin = it
            if (it) preference.userId = userId.value.toString()
        }
    }
}
