package com.cuncis.recipeappcoroutine.data.model

import com.google.gson.annotations.SerializedName


object RecipeDetail {
	data class Response(
		val recipe: Data? = null
	) {
		data class Data(
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
			val ingredients: List<String?>? = null,
			val publisher: String? = null,
			@SerializedName("_id")
			val id: String? = null,
			val title: String? = null,
			@SerializedName("source_url")
			val sourceUrl: String? = null
		)
	}
}