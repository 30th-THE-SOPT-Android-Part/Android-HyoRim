package org.sopt.android_hyorim_30th.util

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import org.sopt.android_hyorim_30th.R

@BindingAdapter("app:imageUri")
fun ImageView.setProfileImage(@DrawableRes uri: Int) {
    Glide.with(this).load(uri).circleCrop().into(this)
}

@BindingAdapter("app:imageUrl")
fun ImageView.setProfileImageUrl(uri: String) {
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

@BindingAdapter("galleryUri")
fun ImageView.galleryUri(url: Uri?) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.rectangle_fill_purple_sub_radius_5)
        .into(this)
}
