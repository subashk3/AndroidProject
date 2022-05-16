package com.example.roomdb


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.itemadapter.ItemAdapter
import com.example.roomdb.mydatabase.MyDataBase
import com.example.roomdb.mydatabase.MyTable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_card.*
import kotlinx.coroutines.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val dataList = ArrayList<MyTable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Add data from the list
        add_button.setOnClickListener { this.insertDataFromDatabase() }

        recyclerView = recycler_id

        recyclerView.layoutManager = LinearLayoutManager(this)

        //Recycler View function to show the list of data
        setDataList()
    }

    override fun onResume() {
        super.onResume()


    }
    //Set data Recycler View
    @SuppressLint("NotifyDataSetChanged")
    fun setDataList() {
        val myDataBase = MyDataBase.getInstance(this)
        val database = myDataBase?.tableDao()
        val itemAdapter = ItemAdapter(this, dataList)

        CoroutineScope(Dispatchers.IO).launch {
            database?.getAllData()?.let {
                dataList.clear()
                dataList.addAll(it)
                withContext(Dispatchers.Main) {
                    if (recyclerView.adapter != null) {
                        (recyclerView.adapter as ItemAdapter).notifyDataSetChanged()
                    } else {
                        recyclerView.adapter = itemAdapter
                    }
                }
            }
        }
    }
    // Insert function
    private fun insertDataFromDatabase() {
        val firstName = first_name.text.toString().trim()
        val secondName = second_name.text.toString().trim()

        if (firstName.isNotEmpty() && secondName.isNotEmpty()) {
            val myTable = MyTable(0, firstName, secondName)
            val myDataBase = MyDataBase.getInstance(this)
            val database = myDataBase?.tableDao()
            GlobalScope.launch {
                database?.insert(myTable)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Successfully added", Toast.LENGTH_SHORT)
                        .show()
                    setDataList()
                }
            }
            resetInput()
        } else {
            if (firstName.isEmpty()) {
                first_name.setBackgroundColor(Color.parseColor("#D54477"))
            } else {
                second_name.setBackgroundColor(Color.parseColor("#D54477"))
            }
            Toast.makeText(
                this@MainActivity,
                "First Name or Second Name are empty. Please try again",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun resetInput() {
        first_name.text = null
        second_name.text = null
      //  Toast.makeText(this, "Reset data", Toast.LENGTH_SHORT).show()
    }
}