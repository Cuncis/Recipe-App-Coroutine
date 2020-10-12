package com.cuncis.recipeappcoroutine.ui.category

import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.databinding.FragmentCategoryBinding
import com.cuncis.recipeappcoroutine.ui.base.BaseFragment
import com.cuncis.recipeappcoroutine.ui.base.MainActivity
import com.cuncis.recipeappcoroutine.util.showToast
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
        categoryViewModel.adapter.setListener { title ->
            goToRecipe(title.toString())
        }
    }

    override fun onObserveAction() {
        categoryViewModel.categories.observe(viewLifecycleOwner, {
            categoryViewModel.adapter.submitList(it)
        })
    }

    override fun setLayout() = R.layout.fragment_category

    override fun getViewModel() = categoryViewModel

    override fun onResume() {
        super.onResume()
        requireActivity().title = "Category"
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onPause() {
        super.onPause()
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun goToRecipe(title: String) {
        val directions = CategoryFragmentDirections.actionCategoryFragmentToRecipeFragment(title)
        findNavController().navigate(directions)
    }
}