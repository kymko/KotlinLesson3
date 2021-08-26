package com.example.kotlinlesson3.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinlesson3.R
import com.example.kotlinlesson3.ui.activities.adapter.MyAdapter
import com.example.kotlinlesson3.extensions.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var imgUrls: ArrayList<String> = ArrayList()
    private var myAdapter: MyAdapter? = null
    var urlList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.title = getString(R.string.images)

        imgUrls = arrayListOf(
            "https://cdn.pixabay.com/photo/2016/11/29/04/19/ocean-1867285__340.jpg",
            "https://cdn.pixabay.com/photo/2015/07/27/19/47/turtle-863336__340.jpg",
            "https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547__340.jpg",
            "https://cdn.pixabay.com/photo/2013/10/02/23/03/mountains-190055__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/14/04/15/mountains-6544522__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/02/11/03/hallelujah-6516410__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/24/01/44/cat-6569156__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/03/07/02/bee-6518669__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/22/12/24/mountains-6564997__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/02/11/03/hallelujah-6516410__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/24/01/44/cat-6569156__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/03/07/02/bee-6518669__340.jpg",
            "https://cdn.pixabay.com/photo/2021/08/22/12/24/mountains-6564997__340.jpg",
            "https://cdn.pixabay.com/photo/2021/07/28/19/28/bee-6503344__340.jpg"
        )

        myAdapter = MyAdapter(imgUrls)

        recyclerview.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = myAdapter
        }

        myAdapter?.setOnItemClickListener(object : MyAdapter.OnItemClickListener {

            override fun onItemClick(imgUrl: String) {
                //showToast("item clicked!")
                urlList.add(imgUrl)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sent_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_send -> {
                showToast("clicked menu")
                openAnotherActivity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAnotherActivity() {
        val intent = Intent(this@MainActivity, SelectedActivity::class.java).apply {
            putStringArrayListExtra(KEY_RES, urlList)
        }
        startActivity(intent)
    }

    companion object {
        const val KEY_RES = "key"
    }
}
