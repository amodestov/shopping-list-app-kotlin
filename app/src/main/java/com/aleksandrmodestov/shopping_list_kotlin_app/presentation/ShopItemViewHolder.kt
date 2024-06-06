package com.aleksandrmodestov.shopping_list_kotlin_app.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrmodestov.shopping_list_kotlin_app.R

class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val tvName = view.findViewById<TextView>(R.id.tv_name)
    val tvCount = view.findViewById<TextView>(R.id.tv_count)
}
