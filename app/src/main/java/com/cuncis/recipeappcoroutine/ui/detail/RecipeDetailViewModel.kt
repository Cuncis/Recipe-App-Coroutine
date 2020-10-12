package com.cuncis.recipeappcoroutine.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cuncis.recipeappcoroutine.data.api.ApiRepoRecipe
import com.cuncis.recipeappcoroutine.data.model.RecipeDetail
import com.cuncis.recipeappcoroutine.ui.base.BaseViewModel
import com.cuncis.recipeappcoroutine.util.Resource
import kotlinx.coroutines.launch

class RecipeDetailViewModel @ViewModelInject constructor(private val apiRepoRecipe: ApiRepoRecipe)
    : BaseViewModel<RecipeDetailNavigator>() {

    private val _detail = MutableLiveData<Resource<RecipeDetail.Response>>()
    val detail: LiveData<Resource<RecipeDetail.Response>>
        get() = _detail

    fun getRecipeDetail(recipeId: String) {
        _detail.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                val response = apiRepoRecipe.getRecipeDetail(recipeId)
                _detail.postValue(Resource.success(response))
            } catch (t: Throwable) {
                _detail.postValue(Resource.error(t.message, null))
            }
        }
    }
}