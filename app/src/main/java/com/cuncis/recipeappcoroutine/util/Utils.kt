package com.cuncis.recipeappcoroutine.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncis.recipeappcoroutine.R


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Context.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ImageView.setImageFromUrl(imageUrl: String) {
    val requestOptions = RequestOptions()
        .placeholder(R.drawable.img_placeholder)
    Glide.with(context)
        .setDefaultRequestOptions(requestOptions)
        .load(imageUrl)
        .into(this)
}