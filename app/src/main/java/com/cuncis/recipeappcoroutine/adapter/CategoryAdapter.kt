package com.cuncis.recipeappcoroutine.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuncis.recipeappcoroutine.R
import com.cuncis.recipeappcoroutine.data.model.Category
import com.cuncis.recipeappcoroutine.util.setImageFromUrl
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(): RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private var categoryList: List<Category> = ArrayList()
    private lateinit var itemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.categoryTitle.text = categoryList[position].categoryTitle
//        val requestOptions = RequestOptions().placeholder(R.drawable.img_placeholder)

        val path = Uri.parse("android.resource://com.cuncis.recipeappcoroutine/drawable/" + categoryList[position].categoryPoster)
//        Glide.with(holder.itemView.context)
//            .setDefaultRequestOptions(requestOptions)
//            .load(path)
//            .into(holder.posterFood)
        holder.posterFood.setImageFromUrl(path.toString())
    }

    fun submitList(categoryList: List<Category>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class CategoryHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var posterFood: CircleImageView = itemView.img_posterFood
        var categoryTitle: TextView = itemView.category_title

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