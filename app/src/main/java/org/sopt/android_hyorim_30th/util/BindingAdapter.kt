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
    val source = if (isSelected) R.drawable.ic_checkbox_on else R.drawable.ic_checkbox_off
    Glide.with(this).load(source).into(this)
}

@BindingAdapter("selected")
fun View.setSelectedBinding(isSelected: Boolean) {
    this.isSelected = isSelected
}
