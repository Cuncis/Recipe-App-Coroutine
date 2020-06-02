package com.cuncis.recipeappcoroutine.ui.detail

import com.cuncis.recipeappcoroutine.data.api.ApiClient

class RecipeDetailRepository {

    suspend fun getRecipeDetail(recipeId: String)
            = ApiClient.theRecipeApi.getRecipeDetail(recipeId)

}