package com.cuncis.recipeappcoroutine.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.lang.Exception

class RecipeViewModel : ViewModel() {

    var loading = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()
    var repository = RecipeRepository()
    var recipeList = MutableLiveData<ArrayList<Recipe>>()

    fun getRecipes(query: String, page: String): MutableLiveData<ArrayList<Recipe>> {

        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                try {
                    recipeList.postValue(repository.getRecipes(query, page).recipes)
                    loading.value = false
                } catch (e: Exception) {
                    errorMessage.value = e.localizedMessage
                    loading.value = false
                }
            }
        }
        return recipeList
    }
}