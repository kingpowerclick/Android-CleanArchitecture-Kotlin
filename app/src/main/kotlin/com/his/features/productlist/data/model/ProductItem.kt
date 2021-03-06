package com.his.features.productlist.data.model

import com.his.features.core.data.model.Image

data class ProductItem(val sku: String,
                       val name: String,
                       val dutyFree: Boolean,
                       val pickup: Boolean,
                       val hotItem: Boolean,
                       val exclusiveKP: Boolean,
                       val bestSeller: Boolean,
                       val lag: Boolean,
                       val soldOut: Boolean,
                       val image: Image?,
                       val prettyUrl: String)