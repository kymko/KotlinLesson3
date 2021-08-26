package com.example.kotlinlesson3.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

fun ImageView.load(s: String) {
    Glide.with(context).load(s).centerCrop().into(imageView)
}