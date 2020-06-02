package com.cuncis.recipeappcoroutine.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cuncis.recipeappcoroutine.data.model.Category
import com.cuncis.recipeappcoroutine.ui.category.CategoryRepository

class CategoryViewModel : ViewModel() {

    private val repository =
        CategoryRepository()

    fun getCategories(): LiveData<ArrayList<Category>> {
        return repository.getCategories()
    }

}