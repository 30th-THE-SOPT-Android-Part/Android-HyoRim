package org.sopt.android_hyorim_30th.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class GitFollowerData(
    val photo: String,
    val name: String,
    val introduction: String,
) : Parcelable
