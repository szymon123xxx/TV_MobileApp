package com.example.trying_navigation_with_myapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_vi_term_mobile_app.RecyclerAdapter
import com.example.project_vi_term_mobile_app.ViewModel
import com.example.trying_navigation_with_myapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest

class HomeFragment : Fragment() {

    lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var _binding: FragmentHomeBinding

    //Mozna jak wyzej albo tak
//    private var _binding: FragmentHomeBinding? = null
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initializeRecyclerView()
        initializeViewModel()
        return _binding.root
    }

    private fun initializeRecyclerView(){
        _binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)

            recyclerAdapter = RecyclerAdapter()
            adapter = recyclerAdapter
        }
    }

    private fun initializeViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getData().collectLatest { pagingData ->
                recyclerAdapter.submitData(pagingData)

            }
        }
    }
}