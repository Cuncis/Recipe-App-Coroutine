package com.cuncis.recipeappcoroutine.data.model

import com.google.gson.annotations.SerializedName

data class RecipeDetailResponse(

	@SerializedName("recipe")
	val recipe: RecipeDetail? = null
)