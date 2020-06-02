package com.cuncis.recipeappcoroutine.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cuncis.recipeappcoroutine.data.model.Category
import com.cuncis.recipeappcoroutine.util.Constants

class CategoryRepository {

    private val list = MutableLiveData<ArrayList<Category>>()

    fun getCategories(): LiveData<ArrayList<Category>> {
        val categoryList = ArrayList<Category>()
        for (i in Constants.DEFAULT_SEARCH_CATEGORY.indices) {
            val category = Category(
                Constants.DEFAULT_SEARCH_CATEGORY[i],
                Constants.DEFAULT_SEARCH_CATEGORY_IMAGES[i]
            )
            categoryList.add(category)
        }
        list.value = categoryList

        return list
    }

}