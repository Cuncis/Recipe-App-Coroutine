package com.cuncis.recipeappcoroutine.data.api

import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.data.model.RecipeDetail
import javax.inject.Inject

class ApiRepoRecipe @Inject constructor(private val apiService: ApiServiceRecipe) {

    suspend fun getRecipe(query: String, page: String): Recipe.Response {
        return apiService.searchRecipeAsync(query, page).await()
    }

    suspend fun getRecipeDetail(recipeId: String): RecipeDetail.Response {
        return apiService.getRecipeDetailAsync(recipeId).await()
    }
}