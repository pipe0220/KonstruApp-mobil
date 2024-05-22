package com.sena.konstruapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sena.konstruapp.R
import com.sena.konstruapp.model.GridItem

class GridAdapter(private val items: List<GridItem>) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.itemImage)
        private val titleView: TextView = itemView.findViewById(R.id.itemTitle)
        private val descriptionView: TextView = itemView.findViewById(R.id.itemDescription)

        fun bind(item: GridItem) {
            imageView.setImageResource(item.imageResource)
            titleView.text = item.title
            descriptionView.text = item.description
        }
    }
}