package com.cuncis.recipeappcoroutine.data.api

import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.data.model.RecipeDetail
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceRecipe {

    @GET("api/search")
    fun searchRecipeAsync(
        @Query("q") query: String,
        @Query("page") page: String
    ): Deferred<Recipe.Response>

    @GET("api/get")
    fun getRecipeDetailAsync(
        @Query("rId") recipeId: String
    ): Deferred<RecipeDetail.Response>
}