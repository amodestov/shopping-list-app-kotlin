package com.aleksandrmodestov.shopping_list_kotlin_app.domain

data class ShopItem(
    val name: String,
    val count: Int,
    var isEnabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {

        const val UNDEFINED_ID = -1
    }
}