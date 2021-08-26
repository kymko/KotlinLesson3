package com.example.kotlinlesson3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinlesson3.R
import com.example.kotlinlesson3.ui.activities.adapter.MyAdapter
import com.example.kotlinlesson3.ui.activities.MainActivity.Companion.KEY_RES
import kotlinx.android.synthetic.main.activity_selected.*

class SelectedActivity : AppCompatActivity() {

    private var urls: ArrayList<String> = ArrayList()
    private var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected)
        this.title = getString(R.string.selectedImg)

        val url = intent.getStringArrayListExtra(KEY_RES)
        Log.e("list", url.toString())

        adapter = MyAdapter(url!!)

        recyclerview.apply {
            layoutManager = GridLayoutManager(this@SelectedActivity, 3)
            adapter = adapter
        }
    }
}