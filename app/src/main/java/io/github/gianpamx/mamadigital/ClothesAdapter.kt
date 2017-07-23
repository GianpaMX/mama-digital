package io.github.gianpamx.mamadigital

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.clothes_listing_item.view.*

class ClothesAdapter(var clothes: List<Clothes>, var listener: OnClothesSelected?) : RecyclerView.Adapter<ClothesAdapter.CategoryHolder>() {
    override fun onBindViewHolder(holder: CategoryHolder?, position: Int) {
        holder?.bind(clothes[position])
    }

    override fun getItemCount(): Int = clothes.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryHolder {
        return CategoryHolder(LayoutInflater.from(parent?.context).inflate(R.layout.clothes_listing_item, parent, false), listener)
    }

    class CategoryHolder(itemView: View, val listener: OnClothesSelected?) : RecyclerView.ViewHolder(itemView) {
        fun bind(clothes: Clothes) {
            Glide.with(itemView.context).load(clothes.image).centerCrop().into(itemView.imageView)

            itemView.imageView.isClickable = false
            itemView.titleTextView.isClickable = false
            itemView.titleTextView.text = clothes.title
            itemView.isClickable = true
            itemView.setOnClickListener { listener?.onCategorySelected(clothes) }
        }
    }

    interface OnClothesSelected {
        fun onCategorySelected(clothes: Clothes)
    }
}
