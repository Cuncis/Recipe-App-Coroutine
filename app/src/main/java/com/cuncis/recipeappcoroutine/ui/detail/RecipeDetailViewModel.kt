package com.cuncis.recipeappcoroutine.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuncis.recipeappcoroutine.data.model.RecipeDetail
import com.cuncis.recipeappcoroutine.ui.recipe.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class RecipeDetailViewModel : ViewModel() {

    private val repository = RecipeDetailRepository()
    var loading = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()
    var recipeDetail = MutableLiveData<RecipeDetail>()

    fun getRecipeDetail(recipeId: String): MutableLiveData<RecipeDetail> {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                try {
                    recipeDetail.postValue(repository.getRecipeDetail(recipeId).recipe)
                    loading.value = false
                } catch (e: Exception) {
                    errorMessage.value = e.localizedMessage
                    loading.value = false
                }
            }
        }

        return recipeDetail
    }

}