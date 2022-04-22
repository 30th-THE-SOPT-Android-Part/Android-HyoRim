package org.sopt.android_hyorim_30th.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class GitRepositoryData(
    val title: String,
    val description: String,
    val id: String = UUID.randomUUID().toString()
) : Parcelable
