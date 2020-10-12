package com.cuncis.recipeappcoroutine.ui.recipe

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.databinding.FragmentRecipeBinding
import com.cuncis.recipeappcoroutine.ui.base.BaseFragment
import com.cuncis.recipeappcoroutine.util.Status
import com.cuncis.recipeappcoroutine.util.gone
import com.cuncis.recipeappcoroutine.util.showToast
import com.cuncis.recipeappcoroutine.util.visible
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecipeFragment : BaseFragment<FragmentRecipeBinding, RecipeViewModel>(), RecipeNavigator {

    private val recipeViewModel by viewModels<RecipeViewModel>()
    private lateinit var binding: FragmentRecipeBinding

    override fun onInitialization() {
        super.onInitialization()
        binding = getViewDataBinding()
        binding.vm = recipeViewModel
        recipeViewModel.navigator = this
    }

    override fun onReadyAction() {
        recipeViewModel.getRecipes("","")
    }

    override fun onObserveAction() {
        recipeViewModel.recipe.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.gone()
                    it.data?.recipes?.let { list ->
                        recipeViewModel.adapter.submitList(list)
                    }
                }
                Status.ERROR -> {
                    binding.progressBar.gone()
                    requireContext().showToast(it.message)
                }
                Status.LOADING -> {
                    binding.progressBar.visible()
                }
            }
        })
    }

    override fun setLayout() = R.layout.fragment_recipe

    override fun getViewModel() = recipeViewModel

    override fun goToDetail(recipe: Recipe.Response.Data?) {
        findNavController().navigate(R.id.action_recipeFragment_to_detailRecipeFragment)
    }
}