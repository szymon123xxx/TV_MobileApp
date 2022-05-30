package com.example.trying_navigation_with_myapp.API

import com.example.project_vi_term_mobile_app.API.DetailData
import com.example.project_vi_term_mobile_app.API.Service
import com.example.project_vi_term_mobile_app.API.TvShowList
import retrofit2.Response

class ApiClient(
    private val getDataService: Service
) {
    suspend fun getMovieById( movieId: Int ): Response<DetailData> {
        return getDataService.getDetailData(movieId)
    }
}