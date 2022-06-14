package com.example.trying_navigation_with_myapp

import com.example.project_vi_term_mobile_app.API.DetailData
import com.example.project_vi_term_mobile_app.API.RetrofitBuilder
import com.example.project_vi_term_mobile_app.API.TvShowList
import retrofit2.Response

class SharedRepository {

    suspend fun getMovieById( movieId: Int ): DetailData? {

        val request = RetrofitBuilder.apiClient.getMovieById(movieId)

        if (request.isSuccessful){
            return request.body()!!
        }

        return null
    }
}