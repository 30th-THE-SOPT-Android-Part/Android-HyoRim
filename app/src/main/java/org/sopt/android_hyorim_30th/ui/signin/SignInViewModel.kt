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
    private val _isSaveId = MutableLiveData(false)
    val isSaveId: LiveData<Boolean> = _isSaveId
    val isInputComplete
        get() = !userId.value.isNullOrBlank() && !userPw.value.isNullOrBlank()

    init {
        userId.value = if (preference.isAutoLogin) preference.userId else ""
        _isSaveId.value = preference.isAutoLogin
    }

    fun toggleSaveId() {
        _isSaveId.value = !(_isSaveId.value ?: throw IllegalStateException())
    }

    fun setPreference() {
        _isSaveId.value?.let {
            preference.isAutoLogin = it
            if (it) preference.userId = userId.value.toString()
        }
    }
}
