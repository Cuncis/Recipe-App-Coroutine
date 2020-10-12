package com.cuncis.recipeappcoroutine.ui.recipe

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cuncis.recipeappcoroutine.adapter.RecipeAdapter
import com.cuncis.recipeappcoroutine.data.api.ApiRepoRecipe
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.ui.base.BaseViewModel
import com.cuncis.recipeappcoroutine.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeViewModel @ViewModelInject constructor(private val apiRepoRecipe: ApiRepoRecipe)
    : BaseViewModel<RecipeNavigator>() {

    private val _recipes = MutableLiveData<Resource<Recipe.Response>>()
    val recipe: LiveData<Resource<Recipe.Response>>
        get() = _recipes

    val adapter = RecipeAdapter()

    fun getRecipes(query: String, page: String) {
        _recipes.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                val response = apiRepoRecipe.getRecipe(query, page)
                _recipes.postValue(Resource.success(response))
            } catch (t: Throwable) {
                _recipes.postValue(Resource.error(t.message, null))
            }
        }
    }
}