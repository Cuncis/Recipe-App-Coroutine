package com.cuncis.recipeappcoroutine.ui.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.adapter.CategoryAdapter
import com.cuncis.recipeappcoroutine.data.model.Category
import com.cuncis.recipeappcoroutine.ui.recipe.RecipeActivity
import com.cuncis.recipeappcoroutine.util.Constants
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity(), CategoryAdapter.ItemClickListener {

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter
    private var categoryList = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        categoryAdapter = CategoryAdapter(this)
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        initRecyclerView()

        observewViewModel()
    }

    private fun observewViewModel() {
        categoryViewModel.getCategories().observe(this, Observer {
            categoryList = it
            categoryAdapter.setCategoryList(categoryList)
        })
    }

    private fun initRecyclerView() {
        rv_category.apply {
            layoutManager = LinearLayoutManager(this@CategoryActivity)
            setHasFixedSize(true)
            adapter = categoryAdapter
        }
        categoryAdapter.setItemClickListener(this)
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, RecipeActivity::class.java)
        intent.putExtra(Constants.EXTRA_QUERY, categoryList[position].categoryTitle)
        startActivity(intent)
    }
}