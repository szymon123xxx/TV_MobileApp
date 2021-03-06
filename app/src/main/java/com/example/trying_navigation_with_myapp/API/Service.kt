package com.example.project_vi_term_mobile_app.API

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("most-popular")
    suspend fun getApiData(@Query("page") query: Int): TvShowList

    @GET("show-details")
    suspend fun getDetailData(@Query("q") query: Int): Response<DetailData>

}