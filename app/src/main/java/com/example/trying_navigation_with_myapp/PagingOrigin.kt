package com.example.project_vi_term_mobile_app

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.project_vi_term_mobile_app.API.ListData
import com.example.project_vi_term_mobile_app.API.Service
import java.lang.Exception

class PagingOrigin(val apiService: Service): PagingSource<Int, ListData>() {

    override fun getRefreshKey(state: PagingState<Int, ListData>): Int? {
//        return state.anchorPosition
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListData> {
        return try {
            val nextPage: Int = params.key ?: 1
            val response = apiService.getApiData(nextPage)
//            var nextPageNumber: Int? = null
//
//            if (response.page != null){
//                val uri = Uri.parse(response.page.toString())
//                System.out.println("TO JA!!! : $response")
//                val nextPageQuery = uri.getQueryParameter("page")
//                nextPageNumber = nextPageQuery?.toInt()
//            }

             LoadResult.Page(data = response.tv_shows,
                            prevKey = if (nextPage == 1) null else -1,
                            nextKey = if (nextPage >= response.pages!!) null else nextPage.plus(1) )

        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}