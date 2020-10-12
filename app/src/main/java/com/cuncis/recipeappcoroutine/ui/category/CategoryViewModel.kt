package com.cuncis.recipeappcoroutine.ui.category

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cuncis.recipeappcoroutine.data.model.Category
import com.cuncis.recipeappcoroutine.ui.base.BaseViewModel
import com.cuncis.recipeappcoroutine.util.Constants

class CategoryViewModel @ViewModelInject constructor()
    : BaseViewModel<CategoryNavigator>() {

    private val _categories = MutableLiveData<MutableList<Category>>()
    val categories: LiveData<MutableList<Category>> = _categories

    val adapter = CategoryAdapter()

    fun getCategories() {
        val categoryList = ArrayList<Category>()
        for (i in Constants.DEFAULT_SEARCH_CATEGORY.indices) {
            val category = Category(
                Constants.DEFAULT_SEARCH_CATEGORY[i],
                Constants.DEFAULT_SEARCH_CATEGORY_IMAGES[i]
            )
            categoryList.add(category)
        }
        _categories.postValue(categoryList)
    }
}