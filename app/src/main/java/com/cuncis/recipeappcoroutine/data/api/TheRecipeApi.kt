package com.cuncis.recipeappcoroutine.data.api

import com.cuncis.recipeappcoroutine.data.model.RecipeDetailResponse
import com.cuncis.recipeappcoroutine.data.model.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheRecipeApi {
    @GET("api/search")
    suspend fun searchRecipe(@Query("q") query: String, @Query("page") page: String)
            : RecipeResponse

    @GET("api/get")
    suspend fun getRecipeDetail(@Query("rId") recipeId: String)
            : RecipeDetailResponse
}