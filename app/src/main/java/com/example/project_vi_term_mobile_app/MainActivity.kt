package com.example.project_vi_term_mobile_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_vi_term_mobile_app.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)

        initializeRecyclerView()
        initializeViewModel()
    }

    private fun initializeRecyclerView(){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
//            val dividerDecoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
//            addItemDecoration(dividerDecoration)
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