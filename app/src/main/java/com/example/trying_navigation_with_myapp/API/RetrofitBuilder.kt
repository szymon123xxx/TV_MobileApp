package com.example.project_vi_term_mobile_app.API

import com.example.trying_navigation_with_myapp.API.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    // companion object allow us to simply not create instance of a object. It's substitute of a static class in c++
    companion object{
        val BASE_URL = "https://www.episodate.com/api/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //So in simple way it convert JSON that we got from server into java object that can be use in Android Project
                .build()
        }

        val getDataBuilder: Service by lazy {
            getRetrofitInstance().create(Service::class.java)
        }

        val apiClient = ApiClient(getDataBuilder)
    }
}