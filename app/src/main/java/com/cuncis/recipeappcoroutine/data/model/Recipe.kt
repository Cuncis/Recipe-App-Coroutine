package com.cuncis.recipeappcoroutine.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

object Recipe {
    data class Response(
        val recipes: ArrayList<Data>? = null,
        val count: Int? = null
    ) {
        @Parcelize
        data class Data(
            @SerializedName("social_rank")
            val socialRank: Double? = null,
            @SerializedName("recipe_id")
            val recipeId: String? = null,
            @SerializedName("publisher_url")
            val publisherUrl: String? = null,
            @SerializedName("image_url")
            val imageUrl: String? = null,
            val publisher: String? = null,
            @SerializedName("_id")
            val id: String? = null,
            val title: String? = null,
            @SerializedName("source_url")
            val sourceUrl: String? = null
        ): Parcelable
    }
}