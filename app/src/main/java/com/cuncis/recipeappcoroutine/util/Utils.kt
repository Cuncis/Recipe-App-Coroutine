package com.cuncis.recipeappcoroutine.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncis.recipeappcoroutine.R

class Utils {
    companion object {
        fun ImageView.setImageFromUrl(imageUrl: String) {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.img_placeholder)
            Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(imageUrl)
                .into(this)
        }
    }
}