package org.sopt.android_hyorim_30th.data

import java.util.*

data class GitRepositoryData(
    val title: String,
    val description: String,
    val id: String = UUID.randomUUID().toString()
)
