package com.cuncis.recipeappcoroutine.ui.category

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.databinding.FragmentCategoryBinding
import com.cuncis.recipeappcoroutine.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryViewModel>(), CategoryNavigator {

    private val categoryViewModel by viewModels<CategoryViewModel>()
    private lateinit var binding: FragmentCategoryBinding

    override fun onInitialization() {
        super.onInitialization()
        binding = getViewDataBinding()
        binding.vm = categoryViewModel
        categoryViewModel.navigator = this
    }

    override fun onReadyAction() {
        categoryViewModel.getCategories()
    }

    override fun onObserveAction() {
        categoryViewModel.categories.observe(viewLifecycleOwner, {
            categoryViewModel.adapter.submitList(it)
        })
    }

    override fun setLayout() = R.layout.fragment_category

    override fun getViewModel() = categoryViewModel

    override fun goToRecipe(title: String) {
        findNavController().navigate(R.id.action_categoryFragment_to_recipeFragment)
    }
}