package com.aleksandrmodestov.shopping_list_kotlin_app.presentation

import androidx.recyclerview.widget.DiffUtil
import com.aleksandrmodestov.shopping_list_kotlin_app.domain.ShopItem

class ShopItemDiffCallback : DiffUtil.ItemCallback<ShopItem>() {

    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}