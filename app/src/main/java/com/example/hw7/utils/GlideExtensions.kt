package com.example.hw7.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hw7.R

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .centerCrop()
        )
        .into(this)
}
