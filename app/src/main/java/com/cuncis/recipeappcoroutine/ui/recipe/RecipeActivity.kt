package com.cuncis.recipeappcoroutine.ui.recipe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.adapter.RecipeAdapter
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.ui.detail.RecipeDetailActivity
import com.cuncis.recipeappcoroutine.util.Constants
import com.cuncis.recipeappcoroutine.util.Constants.EXTRA_QUERY
import com.cuncis.recipeappcoroutine.util.Constants.hideLoading
import com.cuncis.recipeappcoroutine.util.Constants.showLoading
import kotlinx.android.synthetic.main.activity_recipe.*

class RecipeActivity : AppCompatActivity() {

//    private lateinit var recipeViewModel: RecipeViewModel
//    private lateinit var recipeAdapter: RecipeAdapter
//    private var recipeList = ArrayList<Recipe>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_recipe)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        recipeAdapter = RecipeAdapter(this)
//        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)
//
//        initRecyclerView()
//
//        if (intent.hasExtra(EXTRA_QUERY)) {
//            supportActionBar?.title = intent.getStringExtra(Constants.EXTRA_QUERY)
//            recipeViewModel.loading.observe(this, Observer { loading ->
//                if (loading) {
//                    progressBar.showLoading()
//                } else {
//                    progressBar.hideLoading()
//                }
//            })
//            recipeViewModel.getRecipes(intent.getStringExtra(Constants.EXTRA_QUERY)!!, "1").observe(this, Observer {
//                recipeList = it
//                recipeAdapter.setRecipeList(recipeList)
//            })
//            recipeViewModel.errorMessage.observe(this, Observer { errorMessage ->
//                if (errorMessage.contains("No address associated")) {
//                    Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
//                }
//            })
//        }
//
//    }
//
//    private fun initRecyclerView() {
//        rv_recipeList.apply {
//            layoutManager = LinearLayoutManager(this@RecipeActivity)
//            setHasFixedSize(true)
//            adapter = recipeAdapter
//        }
//        recipeAdapter.setItemClickListeer(this)
//    }
//
//    private fun filterRecipe(query: String) {
//        val tempList = ArrayList<Recipe>()
//        for (recipe in recipeList) {
//            //or use .equal(text) with you want equal match
//            //use .toLowerCase() for better matches
//            if (recipe.title?.toLowerCase()?.contains(query)!!) {
//                tempList.add(recipe)
//            }
//        }
//        recipeAdapter.updateList(tempList)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.recipe_menu, menu)
//
//        val actionSearch = menu?.findItem(R.id.action_search)
//        val searchView = actionSearch?.actionView as SearchView
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                Constants.showLog("Text Listener: $newText")
//                filterRecipe(newText)
//                return false
//            }
//        })
//        return true
//    }
//
//    override fun onItemClick(position: Int) {
//        val goToDetail = Intent(this, RecipeDetailActivity::class.java)
//        goToDetail.putExtra(EXTRA_QUERY, recipeList[position])
//        startActivity(goToDetail)
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        finish()
//        return super.onSupportNavigateUp()
//    }
}