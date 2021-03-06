package com.his.features.productlist.view.ui

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.his.R
import com.his.R.id.recyclerViewProductList
import com.his.core.extension.failure
import com.his.core.extension.observe
import com.his.core.extension.viewModel
import com.his.core.platform.BaseFragment
import com.his.features.productlist.data.model.ProductItem
import com.his.features.productlist.view.adapter.ProductListController
import com.his.features.productlist.view.widget.ProductListMarginDecoration
import com.his.features.productlist.viewmodel.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_product_list.*
import timber.log.Timber

class ProductListFragment : BaseFragment() {
	private lateinit var productListViewModel: ProductListViewModel
	private lateinit var productListController: ProductListController
	private val productItemDecorator by lazy { ProductListMarginDecoration(context!!, R.dimen.spacing_tiny, false) }

	override fun layoutId() = R.layout.fragment_product_list

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		appComponent.inject(this)

		productListViewModel = viewModel(viewModelFactory) {
			observe(productList, ::renderProductList)
			failure(error, ::handleFailure)
		}
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
		if (firstTimeCreated(savedInstanceState)) {
			productListViewModel.loadProductList()
		}
	}

	private fun initView() {
		val layoutManager =  GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
		productListController = ProductListController()
		productListController.spanCount = 2
		layoutManager.spanSizeLookup = productListController.spanSizeLookup
		recyclerViewProductList.layoutManager = layoutManager
		recyclerViewProductList.setController(productListController)
		recyclerViewProductList.addItemDecoration(productItemDecorator)
	}

	private fun renderProductList(productList: List<ProductItem>?) {
		productList?.let {
			productListController.setProductItemList(it)
		}
	}


	private  fun handleFailure(e: Throwable?) {
		Timber.e("${e}")
	}

	companion object {
		fun getInstance(): ProductListFragment {
			return ProductListFragment()
		}
	}
}
