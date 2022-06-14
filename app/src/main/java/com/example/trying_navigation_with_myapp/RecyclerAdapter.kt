package com.example.project_vi_term_mobile_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_vi_term_mobile_app.API.ListData
import com.example.trying_navigation_with_myapp.Fragments.DetailFragment
import com.example.trying_navigation_with_myapp.R
import com.example.trying_navigation_with_myapp.databinding.RecyclerViewBinding

class RecyclerAdapter: PagingDataAdapter<ListData, RecyclerAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        val positionItem = getItem(position)
        holder.bind(positionItem!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.MyViewHolder {
        return MyViewHolder(RecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    class MyViewHolder(private val binding: RecyclerViewBinding): RecyclerView.ViewHolder(binding.root){


        init {
            itemView.setOnClickListener { p0 ->

                itemView.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, Bundle().apply {
                    putInt("movieId", binding.id.text.toString().toInt())
                })

            }
        }

        fun bind(data: ListData){
            binding.title.text = data.name
            binding.startDate.text = data.start_date
            binding.country.text = data.country
            binding.id.text = data.id

            Glide.with(binding.image)
                .load(data.image_thumbnail_path)
                .circleCrop()
                .into(binding.image)
        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<ListData>(){
        override fun areItemsTheSame(oldItem: ListData, newItem: ListData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ListData, newItem: ListData): Boolean {
            return oldItem.name == newItem.name && oldItem.start_date == newItem.start_date && oldItem.country == newItem.country
        }

    }

}