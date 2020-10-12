package com.cuncis.recipeappcoroutine.ui.recipe

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.databinding.ItemRecipeListBinding
import com.cuncis.recipeappcoroutine.util.setImageFromUrl
import kotlinx.android.synthetic.main.item_recipe_list.view.*
import kotlin.math.roundToInt

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    private var recipeList = arrayListOf<Recipe.Response.Data>()
    private var listener: ((String?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecipeHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recipe_list,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.binding.data = recipeList[position]
        holder.itemView.setOnClickListener {
            listener?.invoke(recipeList[position].recipeId)
        }
    }

    fun submitList(recipeList: ArrayList<Recipe.Response.Data>) {
        this.recipeList.clear()
        this.recipeList.addAll(recipeList)
        notifyDataSetChanged()
    }

    fun updateList(recipeList: ArrayList<Recipe.Response.Data>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }

    fun setListener(listener: (String?) -> Unit) {
        this.listener = listener
    }

    inner class RecipeHolder(val binding: ItemRecipeListBinding)
        : RecyclerView.ViewHolder(binding.root) {
    }
}