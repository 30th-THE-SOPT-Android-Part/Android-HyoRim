package org.sopt.android_hyorim_30th.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:ImageUri")
fun ImageView.setProfileImage(uri: Int) {
    Glide.with(this).load(uri).into(this)
}