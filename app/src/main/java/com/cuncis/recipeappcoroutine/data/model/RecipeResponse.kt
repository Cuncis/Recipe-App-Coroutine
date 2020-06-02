package com.cuncis.recipeappcoroutine.data.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(

    @SerializedName("recipes")
	val recipes: ArrayList<Recipe>? = null,

    @SerializedName("count")
	val count: Int? = null
)