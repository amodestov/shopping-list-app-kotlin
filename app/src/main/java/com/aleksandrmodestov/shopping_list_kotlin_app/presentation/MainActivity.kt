package com.aleksandrmodestov.shopping_list_kotlin_app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrmodestov.shopping_list_kotlin_app.R
import com.aleksandrmodestov.shopping_list_kotlin_app.domain.ShopItem
import com.aleksandrmodestov.shopping_list_kotlin_app.presentation.ShopListAdapter.Companion.MAX_POOL_SIZE
import com.aleksandrmodestov.shopping_list_kotlin_app.presentation.ShopListAdapter.Companion.VIEW_TYPE_DISABLED
import com.aleksandrmodestov.shopping_list_kotlin_app.presentation.ShopListAdapter.Companion.VIEW_TYPE_ENABLED

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            shopListAdapter.shopItemList = it
        }
    }

    private fun setUpRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        shopListAdapter = ShopListAdapter()
        with(rvShopList) {
            adapter = shopListAdapter
            recycledViewPool.setMaxRecycledViews(
                VIEW_TYPE_ENABLED,
                MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                VIEW_TYPE_DISABLED,
                MAX_POOL_SIZE
            )
        }
        shopListAdapter.onShopItemLongClickListener = object : ShopListAdapter.OnShopItemLongClickListener{
            override fun onShopItemLongClick(shopItem: ShopItem) {
                viewModel.changeShopItemState(shopItem)
            }
        }
    }
}