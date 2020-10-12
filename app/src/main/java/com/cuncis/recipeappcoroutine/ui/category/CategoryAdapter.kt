package com.cuncis.recipeappcoroutine.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.data.model.Category
import com.cuncis.recipeappcoroutine.databinding.ItemCategoryBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private var categoryList = arrayListOf<Category>()
    private var listener: ((String?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_category,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.binding.data = categoryList[position]
        holder.itemView.setOnClickListener {
            listener?.invoke(categoryList[position].categoryTitle)
        }
    }

    fun setListener(listener: (String?) -> Unit) {
        this.listener = listener
    }

    fun submitList(categoryList: List<Category>) {
        this.categoryList.addAll(categoryList)
        notifyDataSetChanged()
    }

    inner class CategoryHolder(val binding: ItemCategoryBinding)
        : RecyclerView.ViewHolder(binding.root)
}