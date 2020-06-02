package com.cuncis.recipeappcoroutine.data.model

import com.google.gson.annotations.SerializedName

data class RecipeDetail(

	@SerializedName("social_rank")
	val socialRank: Double? = null,

	@SerializedName("recipe_id")
	val recipeId: String? = null,

	@SerializedName("publisher_url")
	val publisherUrl: String? = null,

	@SerializedName("image_url")
	val imageUrl: String? = null,

	@SerializedName("__v")
	val V: Int? = null,

	@SerializedName("ingredients")
	val ingredients: List<String?>? = null,

	@SerializedName("publisher")
	val publisher: String? = null,

	@SerializedName("_id")
	val id: String? = null,

	@SerializedName("title")
	val title: String? = null,

	@SerializedName("source_url")
	val sourceUrl: String? = null
)