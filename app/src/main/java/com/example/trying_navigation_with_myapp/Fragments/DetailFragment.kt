package com.example.trying_navigation_with_myapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trying_navigation_with_myapp.R
import com.example.trying_navigation_with_myapp.databinding.FragmentDetailBinding
import com.example.trying_navigation_with_myapp.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    private lateinit var _binding: FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false)
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val data =arguments
        _binding.textFragment.text = data!!.get("id").toString()


        return _binding.root
    }


}