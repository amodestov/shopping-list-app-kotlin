package com.aleksandrmodestov.shopping_list_kotlin_app.domain

data class ShopItem(
    val name: String,
    val count: Int,
    var isEnabled:Boolean,
    var id: Int = UNDEFINED
) {
    companion object{

        const val UNDEFINED = -1
    }
}