package org.sopt.android_hyorim_30th.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUri")
fun ImageView.setProfileImage(@DrawableRes uri: Int) {
    Glide.with(this).load(uri).into(this)
}