package com.example.trying_navigation_with_myapp.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.project_vi_term_mobile_app.API.DetailData
import com.example.project_vi_term_mobile_app.API.DetailData2
import com.example.project_vi_term_mobile_app.API.RetrofitBuilder
import com.example.project_vi_term_mobile_app.API.Service
import com.example.trying_navigation_with_myapp.DetailViewModel
import com.example.trying_navigation_with_myapp.R
import com.example.trying_navigation_with_myapp.databinding.FragmentDetailBinding
import com.example.trying_navigation_with_myapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
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
        println(Thread.currentThread().name)

    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        val incomingData = requireArguments().getInt("movieId")

        detailViewModel.refreshMovie(incomingData)
        detailViewModel.movieByIdLiveData.observe(viewLifecycleOwner){ response->
            if (response == null){
                println("SMTH IS WRONG")
                return@observe
            }

            Glide.with(_binding.imageDetail)
                .load(response.tvShow?.image_thumbnail_path)
                .into(_binding.imageDetail)

            _binding.nameDetail.text = response.tvShow?.name.toString()
            _binding.startDateDetail.text = response.tvShow?.start_date.toString()
            _binding.countryDetail.text = response.tvShow?.country.toString()
            _binding.endDateDetail.text = response.tvShow?.status.toString()
            _binding.runtimeDetail.text = response.tvShow?.runtime.toString() + " min"
            _binding.ratingDetail.text = response.tvShow?.rating.toString()
            _binding.descriptionDetail.text = response.tvShow?.description.toString()
        }

        return _binding.root
    }


}