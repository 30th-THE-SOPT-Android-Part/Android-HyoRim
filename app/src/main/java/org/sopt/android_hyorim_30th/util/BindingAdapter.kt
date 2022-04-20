package org.sopt.android_hyorim_30th.util

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import org.sopt.android_hyorim_30th.R

@BindingAdapter("app:imageUri")
fun ImageView.setProfileImage(@DrawableRes uri: Int) {
    Glide.with(this).load(uri).into(this)
}

@BindingAdapter("app:selector")
fun ImageView.setProfileImage(isSelected: Boolean) {
    if (isSelected) Glide.with(this).load(R.drawable.ic_checkbox_on).into(this)
    else Glide.with(this).load(R.drawable.ic_checkbox_off).into(this)
}

@BindingAdapter("selected")
fun View.setSelectedBinding(isSelected: Boolean) {
    this.isSelected = isSelected
}
