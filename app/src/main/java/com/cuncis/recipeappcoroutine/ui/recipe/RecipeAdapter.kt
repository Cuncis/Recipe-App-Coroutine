package com.cuncis.recipeappcoroutine.ui.recipe

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.util.setImageFromUrl
import kotlinx.android.synthetic.main.item_recipe_list.view.*
import kotlin.math.roundToInt

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    private var recipeList = arrayListOf<Recipe.Response.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_list, parent, false)
        return RecipeHolder(view)
    }

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.tvTitle.text = Html.fromHtml(recipeList[position].title)
        holder.tvPublisher.text = recipeList[position].publisher
        holder.tvScore.text = recipeList[position].socialRank!!.roundToInt().toString()
        holder.imgPoster.setImageFromUrl(recipeList[position].imageUrl!!)
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

    inner class RecipeHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.recipe_title
        var tvPublisher: TextView = itemView.recipe_publisher
        var tvScore: TextView = itemView.recipe_social_score
        var imgPoster: ImageView = itemView.recipe_image
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}