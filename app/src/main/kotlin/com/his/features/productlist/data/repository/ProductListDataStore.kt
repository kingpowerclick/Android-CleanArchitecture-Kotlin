package com.his.features.productlist.data.repository

import com.his.features.productlist.data.entity.ProductItem
import com.his.features.productlist.data.entity.ProductSortableFieldEnum
import com.his.features.productlist.data.entity.SortType
import io.reactivex.Observable


interface ProductListDataStore {
	fun getProductList(sku: String?,
	                   category: String?,
	                   brand: String?,
	                   prettyUrl: String?,
	                   sortBy: ProductSortableFieldEnum?,
	                   sortType: SortType?,
	                   page: Int?,
	                   recordPerPage: Int?,
	                   lang: com.his.features.productlist.data.entity.LocaleType,
	                   keyword: String?,
	                   brands :List<String>?,
	                   categories: List<String>?,
	                   genders: List<String>?,
	                   priceMax: Double?,
	                   priceMin: Double?,
	                   isDutyFree: Boolean?): Observable<List<ProductItem>>
}