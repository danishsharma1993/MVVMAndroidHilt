package com.example.practicemvvm.mvvm_without_dagger.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "author")
    val author: String,
    @Json(name = "categories")
    val categories: List<Any>,
    @Json(name = "content")
    val content: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "enclosure")
    val enclosure: Enclosure,
    @Json(name = "guid")
    val guid: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "pubDate")
    val pubDate: String,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String
)