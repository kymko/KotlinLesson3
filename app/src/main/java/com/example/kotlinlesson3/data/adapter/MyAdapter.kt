package com.example.kotlinlesson3.data.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson3.R
import com.example.kotlinlesson3.data.model.Images
import com.example.kotlinlesson3.databinding.ItemListBinding

class MyAdapter(private val img: ArrayList<Images>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var clickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)) }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.onBind(img[position],clickListener)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        clickListener = listener
    }

    override fun getItemCount() = img.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemListBinding.bind(itemView)

        fun onBind(images: Images,listener: OnItemClickListener) {
            binding.imageView.setImageResource(images.image)
            itemView.setOnClickListener{
                listener.onItemClick(images)
                it.setBackgroundColor(Color.YELLOW)
            }

        }
    }

    interface OnItemClickListener{
        fun onItemClick(img: Images)
    }
}
