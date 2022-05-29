 package com.example.trying_navigation_with_myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_vi_term_mobile_app.RecyclerAdapter
import com.example.project_vi_term_mobile_app.ViewModel
import com.example.trying_navigation_with_myapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

 class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        navController = navHostFragment.navController
//
//        setupActionBarWithNavController(navController)

    }


}