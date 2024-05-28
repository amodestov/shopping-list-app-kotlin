package com.aleksandrmodestov.shopping_list_kotlin_app.presentation

import androidx.lifecycle.ViewModel
import com.aleksandrmodestov.shopping_list_kotlin_app.data.ShopListRepositoryImpl
import com.aleksandrmodestov.shopping_list_kotlin_app.domain.DeleteShopItemUseCase
import com.aleksandrmodestov.shopping_list_kotlin_app.domain.EditShopItemUseCase
import com.aleksandrmodestov.shopping_list_kotlin_app.domain.GetShopListUseCase
import com.aleksandrmodestov.shopping_list_kotlin_app.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeShopItemState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isEnabled = !shopItem.isEnabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}