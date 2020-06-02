package com.cuncis.recipeappcoroutine.ui.recipe

import androidx.lifecycle.MutableLiveData
import com.cuncis.recipeappcoroutine.data.api.ApiClient
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.data.model.RecipeResponse

class RecipeRepository {

    suspend fun getRecipes(query: String, page: String): RecipeResponse
            = ApiClient.theRecipeApi.searchRecipe(query, page)


}