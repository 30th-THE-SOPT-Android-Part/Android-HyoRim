package org.sopt.android_hyorim_30th.ui.main.profile.gitRepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.android_hyorim_30th.data.GitRepositoryData

class GitRepositoryViewModel : ViewModel() {

    private var _repository = MutableLiveData<List<GitRepositoryData?>>()
    val repository: LiveData<List<GitRepositoryData?>> = _repository

    init {
        _repository.value = listOf(
            GitRepositoryData(
                "MVVMdiaryExample",
                "MVVM 무작정 따라하기 스터디"
            ),
            GitRepositoryData(
                "JsoupSample",
                "Practice Crawling Meta Data (Web Scrapping)"
            ),
            GitRepositoryData(
                "Architecture-Components",
                "GuessTheWord-Starter"
            ),
            GitRepositoryData(
                "RaspberryControl",
                "2021 SSWU Smart System Capstone Design / Smart Multitap Project with Deep Learning."
            )
        )
    }
}
