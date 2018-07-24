package com.his.features.productlist.view.adapter

import com.airbnb.epoxy.EpoxyController
import com.his.features.productlist.data.entity.ProductItem

open class ProductListController : EpoxyController() {
	private var mProductList: List<ProductItem> = listOf()

	fun setProductItemList(productItemList: List<ProductItem>) {
		this.mProductList = productItemList
	}

	override fun buildModels() {
		if (mProductList.isNotEmpty()) {
			mProductList.forEach {
				ProductItemCard_()
					.productItem(it)
			}
		}
	}
}