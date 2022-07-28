package com.example.practicemvvm.mvvm_with_hilt.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    @Json(name = "feed")
    val feed: Feed?,
    @Json(name = "items")
    val items: List<Item>?,
    @Json(name = "status")
    val status: String?
)