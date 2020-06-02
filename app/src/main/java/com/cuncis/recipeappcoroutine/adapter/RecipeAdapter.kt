package com.cuncis.recipeappcoroutine.adapter

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.data.model.Recipe
import com.cuncis.recipeappcoroutine.util.Utils.Companion.setImageFromUrl
import kotlinx.android.synthetic.main.activity_recipe.view.*
import kotlinx.android.synthetic.main.item_recipe_list.view.*
import kotlin.math.roundToInt

class RecipeAdapter(private val context: Context): RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {

    private var recipeList: List<Recipe> = ArrayList()
    private lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recipe_list, parent, false)
        return RecipeHolder(view)
    }

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.tvTitle.text = Html.fromHtml(recipeList[position].title)
        holder.tvPublisher.text = recipeList[position].publisher
        holder.tvScore.text = recipeList[position].socialRank!!.roundToInt().toString()
        holder.imgPoster.setImageFromUrl(recipeList[position].imageUrl!!)
    }

    fun setRecipeList(recipeList: List<Recipe>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }

    fun setItemClickListeer(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    fun updateList(recipeList: List<Recipe>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }

    inner class RecipeHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var tvTitle: TextView = itemView.recipe_title
        var tvPublisher: TextView = itemView.recipe_publisher
        var tvScore: TextView = itemView.recipe_social_score
        var imgPoster: ImageView = itemView.recipe_image

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            itemClickListener.onItemClick(adapterPosition)
        }
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}