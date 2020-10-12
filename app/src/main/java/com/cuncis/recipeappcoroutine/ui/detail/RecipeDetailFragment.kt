package com.cuncis.recipeappcoroutine.ui.detail

import androidx.fragment.app.viewModels
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.databinding.FragmentRecipeBinding
import com.cuncis.recipeappcoroutine.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : BaseFragment<FragmentRecipeBinding, RecipeDetailViewModel>(), RecipeDetailNavigator {

    private val recipeDetailViewModel by viewModels<RecipeDetailViewModel>()

    override fun onInitialization() {
        super.onInitialization()
    }

    override fun setLayout() = R.layout.fragment_recipe_detail

    override fun getViewModel() = recipeDetailViewModel
}