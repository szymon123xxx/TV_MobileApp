package com.example.trying_navigation_with_myapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.project_vi_term_mobile_app.API.DetailData
import com.example.project_vi_term_mobile_app.API.DetailData2
import com.example.project_vi_term_mobile_app.API.RetrofitBuilder
import com.example.project_vi_term_mobile_app.API.Service
import com.example.trying_navigation_with_myapp.DetailViewModel
import com.example.trying_navigation_with_myapp.R
import com.example.trying_navigation_with_myapp.databinding.FragmentDetailBinding
import com.example.trying_navigation_with_myapp.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailFragment : Fragment() {

    private lateinit var _binding: FragmentDetailBinding

    val detailViewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false)
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
//        val data =arguments
//        _binding.textFragment.text = data!!.get("id").toString()
        val incomingData = requireArguments().getInt("movieId")
        detailViewModel.refreshMovie(incomingData)
        detailViewModel.movieByIdLiveData.observe(viewLifecycleOwner){ response->
            if (response == null){
                println("SMTH IS WRONG")
                return@observe
            }

            _binding.textFragment.text = response.tvShow?.name.toString()
//            println(response.name.toString() + "TUTAJ")
        }

//        val BASE_URL = "https://www.episodate.com/api/"
//        val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()) //So in simple way it convert JSON that we got from server into java object that can be use in Android Project
//                .build()
//
//        val service: Service = retrofit.create(Service::class.java)
//
//        service.getDetailData(29560).enqueue(object : Callback<DetailData> {
//            override fun onResponse(call: Call<DetailData>, response: Response<DetailData>) {
//                println(response.toString() + "TU RESPONSE")
//
//                if (!response.isSuccessful){
//                    println("Zły CALL")
//                }
////                val body = response.body()!!
////                val name = body.name
//
//                _binding.textFragment.text = response.body()?.tvShow?.name.toString()
//            }
//
//            override fun onFailure(call: Call<DetailData>, t: Throwable) {
//                println("Nie DZIAłA")
//            }
//        })
        return _binding.root
    }


}