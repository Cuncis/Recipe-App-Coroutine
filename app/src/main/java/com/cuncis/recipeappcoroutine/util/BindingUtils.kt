package com.cuncis.recipeappcoroutine.util

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.cuncis.recipeappcoroutine.R

@BindingAdapter("setImageDrawable")
fun ImageView.setImageDrawable(posterUrl: String?) {
    val path = Uri.parse(String.format(context.getString(R.string.pathDrawable), posterUrl))
    setImageFromUrl(path.toString())
}