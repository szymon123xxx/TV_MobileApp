package com.example.project_vi_term_mobile_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_vi_term_mobile_app.API.ListData
import com.example.project_vi_term_mobile_app.databinding.RecyclerViewBinding

class RecyclerAdapter: PagingDataAdapter<ListData, RecyclerAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        val positionItem = getItem(position)
        holder.bind(positionItem!!)
//        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.MyViewHolder {
//        val layout = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
//        return MyViewHolder(layout)
        return MyViewHolder(RecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    class MyViewHolder(private val binding: RecyclerViewBinding): RecyclerView.ViewHolder(binding.root){
//        private val image: ImageView = view.findViewById(R.id.image)
//        private val title: TextView = view.findViewById(R.id.title)
//        private val startDate: TextView = view.findViewById(R.id.start_date)
//        private val country: TextView = view.findViewById(R.id.country)

        fun bind(data: ListData){
            binding.title.text = data.name
            binding.startDate.text = data.start_date
            binding.country.text = data.country

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