package com.cuncis.recipeappcoroutine.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast

object Constants {
    const val BASE_URL = "https://recipesapi.herokuapp.com/"
    const val EXTRA_QUERY = "com.cuncis.recipeapp.EXTRA_QUERY"

    val DEFAULT_SEARCH_CATEGORY = arrayOf("Barbeque", "Breakfast", "Chicken", "Beef", "Brunch", "Dinner", "Wine", "Italian")
    val DEFAULT_SEARCH_CATEGORY_IMAGES = arrayOf("barbeque", "breakfast", "chicken", "beef", "brunch", "dinner", "wine", "italian")

    fun showLog(message: String) {
        Log.d("_logRecipe", "\n" + message)
    }

    fun Context.showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun View.showLoading() {
        visibility = View.VISIBLE
    }

    fun View.hideLoading() {
        visibility = View.GONE
    }
}