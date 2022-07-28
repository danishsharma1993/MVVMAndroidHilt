package com.example.practicemvvm.mvvm_with_hilt.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Feed(
    @Json(name = "author")
    val author: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val url: String
)