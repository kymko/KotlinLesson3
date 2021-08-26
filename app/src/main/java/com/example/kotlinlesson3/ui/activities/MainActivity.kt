package com.example.kotlinlesson3.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson3.data.model.Images
import com.example.kotlinlesson3.data.adapter.MyAdapter
import com.example.kotlinlesson3.R
import com.example.kotlinlesson3.data.adapter.MyAdapter.OnItemClickListener
import com.example.kotlinlesson3.extensions.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var startForResult: ActivityResultLauncher<Intent>
    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<Images>
    private lateinit var imgId: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.title = getString(R.string.images)

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->

                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                  //  et_input.setText(intent?.getStringExtra(KEY_RES))
                }
            }
        imgId = arrayOf(
            R.drawable.maksatajy, R.drawable.sadybakasajy,
            R.drawable.maksatajy, R.drawable.sadybakasajy,
            R.drawable.maksatajy, R.drawable.sadybakasajy,
            R.drawable.abdyshykyrajy, R.drawable.sadybakasajy,
            R.drawable.chybakajy, R.drawable.sadybakasajy,
            R.drawable.chybakajy, R.drawable.sadybakasajy,
            R.drawable.chybakajy, R.drawable.sadybakasajy,
            R.drawable.abdyshykyrajy, R.drawable.sadybakasajy,
            R.drawable.abdyshykyrajy, R.drawable.chybakajy,
            R.drawable.abdyshykyrajy, R.drawable.chybakajy,
            R.drawable.abdyshykyrajy, R.drawable.chybakajy
        )
        imgId.shuffle()

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
        adapter.setOnItemClickListener(object : OnItemClickListener {

            override fun onItemClick(img: Images) {
                startForResult.launch(
                    Intent(this@MainActivity, SelectedActivity::class.java)
                        .putExtra(KEY_RES,img.image)
                )
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sent_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.menu_send -> {
                showToast("clicked menu")
                openAnotherActivity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAnotherActivity() {
        val intent: Intent = Intent(this, SelectedActivity::class.java)
        startActivity(intent)

    }

    companion object {
        const val KEY_RES = "key"
    }
}
