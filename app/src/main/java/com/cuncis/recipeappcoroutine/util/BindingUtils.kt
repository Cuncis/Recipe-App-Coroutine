package com.cuncis.recipeappcoroutine.util

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.cuncis.recipeappcoroutine.R
import kotlin.math.roundToInt

@BindingAdapter("setImageDrawable")
fun ImageView.setImageDrawable(posterUrl: String?) {
    val path = Uri.parse(String.format(context.getString(R.string.pathDrawable), posterUrl))
    setImageFromUrl(path.toString())
}

@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl(posterUrl: String?) {
    setImageFromUrl(posterUrl.toString())
}

@BindingAdapter("textHTML")
fun TextView.setHTMLText(value: String?) {
    context?.let {
        HTMLUtils.setTextViewHTML(it, this, value ?: "")
    } ?: run {
        text = value
    }
}

@BindingAdapter("setSocialScore")
fun TextView.setSocialScore(score: Double?) {
    score?.let {
        text = it.roundToInt().toString()
    }
}

@BindingAdapter("setIngredientsProperty")
fun TextView.setIngredientsProperty(detail: List<String>?) {
    detail?.let {
        for (i in it.indices) {
            append("${it[i]} \n")
        }
    }
}