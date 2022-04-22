package org.sopt.android_hyorim_30th.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.android_hyorim_30th.data.GitFollowerData

class DetailViewModel : ViewModel() {
    private val _gitData = MutableLiveData<GitFollowerData>()
    val gitData: LiveData<GitFollowerData> = _gitData

    fun setGitData(data: GitFollowerData) {
        _gitData.postValue(data)
    }
}
