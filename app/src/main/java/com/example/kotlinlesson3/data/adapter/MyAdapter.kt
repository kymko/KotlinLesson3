package com.example.kotlinlesson3.data.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson3.R
import com.example.kotlinlesson3.databinding.ItemListBinding
import com.example.kotlinlesson3.extensions.load

class MyAdapter(private val imgUrls: ArrayList<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

     private lateinit var clickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false),clickListener
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(imgUrls[position])
    }


    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    override fun getItemCount() = imgUrls.size

    class MyViewHolder(itemView: View, var clickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        private val binding = ItemListBinding.bind(itemView)

        fun onBind(imgUrl: String) {
            itemView.setOnClickListener {
                clickListener.onItemClick(imgUrl)
                it.setBackgroundColor(Color.YELLOW)
                binding.imageView.load(imgUrl)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(img: String)
    }
}