package com.cuncis.recipeappcoroutine.ui.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.databinding.FragmentRecipeDetailBinding
import com.cuncis.recipeappcoroutine.ui.base.BaseFragment
import com.cuncis.recipeappcoroutine.util.Status
import com.cuncis.recipeappcoroutine.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : BaseFragment<FragmentRecipeDetailBinding, RecipeDetailViewModel>() {

    private val recipeDetailViewModel by viewModels<RecipeDetailViewModel>()
    private lateinit var binding: FragmentRecipeDetailBinding

    private val args by navArgs<RecipeDetailFragmentArgs>()

    override fun setLayout() = R.layout.fragment_recipe_detail

    override fun getViewModel() = recipeDetailViewModel

    override fun onInitialization() {
        super.onInitialization()
        binding = getViewDataBinding()
    }

    override fun onReadyAction() {
        recipeDetailViewModel.getRecipeDetail(args.recipeId)
    }

    override fun onObserveAction() {
        recipeDetailViewModel.detail.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.shimmerContainer.stopShimmerAnimation()
                    it.data?.recipe?.let { data ->
                        requireActivity().title = data.title
                        binding.data = data
                    }
                }
                Status.ERROR -> {
                    binding.shimmerContainer.stopShimmerAnimation()
                    requireContext().showToast(it.message)
                }
                Status.LOADING -> {
                    binding.shimmerContainer.startShimmerAnimation()
                }
            }
        })
    }
}