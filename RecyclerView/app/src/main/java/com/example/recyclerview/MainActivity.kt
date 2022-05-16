package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* // FULL SCREEN
         window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN*/

        //Vertical View Recycler View
        recycler_view.layoutManager = LinearLayoutManager(this)

        // Horizontal Recycler View
        /*recycler_view.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)*/

        val itemAdapter = ItemAdapter(this, getList())

        recycler_view.adapter = itemAdapter


    }

    private fun getList(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 1..30) {
            list.add("Item $i")
        }
        return list
    }
}