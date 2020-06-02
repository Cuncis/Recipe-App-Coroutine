package com.cuncis.recipeappcoroutine.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.data.model.RecipeDetail
import com.cuncis.recipeappcoroutine.util.Constants
import com.cuncis.recipeappcoroutine.util.Utils.Companion.setImageFromUrl
import kotlinx.android.synthetic.main.activity_recipe_detail.*
import kotlin.math.roundToInt

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var recipeDetailViewModel: RecipeDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val recipe = intent.getParcelableExtra(Constants.EXTRA_QUERY) as Recipe
        supportActionBar?.title = recipe.title

        recipeDetailViewModel = ViewModelProvider(this).get(RecipeDetailViewModel::class.java)

        observeViewModel(recipe.recipeId!!)
    }

    private fun observeViewModel(recipeId: String) {
        recipeDetailViewModel.getRecipeDetail(recipeId).observe(this, Observer { detail ->
            Constants.showLog("Detail Data: $detail")
            setIngredientsProperty(detail)
        })
        recipeDetailViewModel.loading.observe(this, Observer {  loading ->
            if (loading) {
                shimmer_container.startShimmerAnimation()
            } else {
                shimmer_container.stopShimmerAnimation()
            }
        })
    }

    private fun setIngredientsProperty(detail: RecipeDetail) {
        recipe_image.setImageFromUrl(detail.imageUrl!!)
        recipe_title.text = Html.fromHtml(detail.title)
        recipe_social_score.text = detail.socialRank!!.roundToInt().toString()
        for (i in detail.ingredients?.indices!!) {
            ingredients_title.append("${detail.ingredients[i].toString()} \n")
        }
    }

    override fun onResume() {
        super.onResume()
        shimmer_container.startShimmerAnimation()
    }

    override fun onPause() {
        shimmer_container.stopShimmerAnimation()
        super.onPause()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}