package com.example.kotlinlesson3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinlesson3.R
import com.example.kotlinlesson3.ui.activities.adapter.MyAdapter
import com.example.kotlinlesson3.ui.activities.MainActivity.Companion.KEY_RES
import kotlinx.android.synthetic.main.activity_selected.*

class SelectedActivity : AppCompatActivity() {

    private var myAdapter: MyAdapter? = null
    private var imgUrls: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected)
        this.title = getString(R.string.selectedImg)

        val url:ArrayList<String>? = intent.getStringArrayListExtra(KEY_RES)
        if (url != null) {
            imgUrls = url
        }
        myAdapter = MyAdapter(imgUrls)

        recyclerview.apply {
            layoutManager = GridLayoutManager(this@SelectedActivity, 3)
            adapter = myAdapter
        }
        myAdapter?.setOnItemClickListener(object : MyAdapter.OnItemClickListener{
            override fun onItemClick(img: String) {
            }
        })
    }
}