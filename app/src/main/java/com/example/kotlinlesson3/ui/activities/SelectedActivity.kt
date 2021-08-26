package com.example.kotlinlesson3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson3.R
import com.example.kotlinlesson3.data.adapter.MyAdapter
import com.example.kotlinlesson3.data.model.Images
import com.example.kotlinlesson3.ui.activities.MainActivity.Companion.KEY_RES

class SelectedActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<Images>
    private lateinit var imgId: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected)
        this.title = getString(R.string.selectedImg)

        val images: String? = intent.getStringExtra(KEY_RES).toString()

        images?.let {
            imgId = arrayOf() }


        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        arrayList = arrayListOf()
        getData()
    }

    private fun getData() {
        for (i in imgId.indices) {
            val images = Images(imgId[i])
            arrayList.add(images)
        }
        val adapter = MyAdapter(arrayList)
        recyclerView.adapter = adapter
    }
}