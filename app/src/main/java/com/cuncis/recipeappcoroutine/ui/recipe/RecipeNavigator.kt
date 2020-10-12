package com.cuncis.recipeappcoroutine.ui.recipe

import com.cuncis.recipeappcoroutine.data.model.Recipe

interface RecipeNavigator {
    fun goToDetail(recipe: Recipe.Response.Data?)
}