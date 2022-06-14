package com.example.project_vi_term_mobile_app.API

data class TvShowList(
    val total: String?,
    var page: Int?,
    val pages: Int?,
    val tv_shows: List<ListData>)

data class ListData(
    val name: String?,
    val start_date: String?,
    val country: String?,
    val image_thumbnail_path: String?,
    val id: String)

data class DetailData(
    val tvShow: DetailData2?,
)

data class DetailData2(
    val name: String?,
    val start_date: String?,
    val country: String?,
    val status: String?,
    val runtime: String?,
    val rating: String,
    val description: String?,
    val image_thumbnail_path: String?,
    )

