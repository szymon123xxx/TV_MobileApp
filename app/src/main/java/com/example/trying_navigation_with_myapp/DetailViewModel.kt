package com.example.trying_navigation_with_myapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_vi_term_mobile_app.API.DetailData
import kotlinx.coroutines.*

class DetailViewModel: ViewModel() {

    private val repository = SharedRepository()

    private val _getMovieIdLiveData = MutableLiveData<DetailData?>()
    val movieByIdLiveData: LiveData<DetailData?> = _getMovieIdLiveData


    @OptIn(ObsoleteCoroutinesApi::class)
    fun refreshMovie(movieId: Int){
        viewModelScope.launch(newSingleThreadContext("MyOwnThread")) {
            val response = repository.getMovieById(movieId)

            _getMovieIdLiveData.postValue(response)
        }
    }
}