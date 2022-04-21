package com.example.project_vi_term_mobile_app
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.project_vi_term_mobile_app.API.ListData
import com.example.project_vi_term_mobile_app.API.RetrofitBuilder
import com.example.project_vi_term_mobile_app.API.Service
import kotlinx.coroutines.flow.Flow


class ViewModel: ViewModel() {

    var retrofitService: Service = RetrofitBuilder.getRetrofitInstance().create(Service::class.java)

    fun getData(): Flow<PagingData<ListData>> {
        return Pager(config = PagingConfig(pageSize = 5, maxSize = 200),
            pagingSourceFactory = {PagingOrigin(retrofitService)}).flow.cachedIn(viewModelScope)
    }
}