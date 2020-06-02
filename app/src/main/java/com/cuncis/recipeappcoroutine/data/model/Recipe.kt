package com.cuncis.recipeappcoroutine.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Recipe(

	@SerializedName("social_rank")
	val socialRank: Double? = null,

	@SerializedName("recipe_id")
	val recipeId: String? = null,

	@SerializedName("publisher_url")
	val publisherUrl: String? = null,

	@SerializedName("image_url")
	val imageUrl: String? = null,

	@SerializedName("publisher")
	val publisher: String? = null,

	@SerializedName("_id")
	val id: String? = null,

	@SerializedName("title")
	val title: String? = null,

	@SerializedName("source_url")
	val sourceUrl: String? = null
): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Double::class.java.classLoader) as? Double,
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	)
	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(socialRank)
		parcel.writeString(recipeId)
		parcel.writeString(publisherUrl)
		parcel.writeString(imageUrl)
		parcel.writeString(publisher)
		parcel.writeString(id)
		parcel.writeString(title)
		parcel.writeString(sourceUrl)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Recipe> {
		override fun createFromParcel(parcel: Parcel): Recipe {
			return Recipe(parcel)
		}

		override fun newArray(size: Int): Array<Recipe?> {
			return arrayOfNulls(size)
		}
	}
}