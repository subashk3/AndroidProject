package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0
    private lateinit var printNumber: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*findViewById<View>(R.id.textView).setOnClickListener {
            Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
        }*/
        printNumber = findViewById<View>(R.id.textView) as TextView
        //Count increment
        findViewById<View>(R.id.bt1).setOnClickListener {
            printNumber.text = (++counter).toString()
        }
        //Count decrement
        findViewById<View>(R.id.bt2).setOnClickListener {
            printNumber.text = (--counter).toString()
        }
        //Reset count
        findViewById<View>(R.id.rest_count).setOnClickListener {
            printNumber.text = (0).toString()
            counter = 0
        }
//Landscape Mode data transfer

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("Counter")
            printNumber.text = ("" + counter)
        }
        Log.d("MainActivity", "onCreate ****")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState****")
        outState.putInt("Counter", counter)
    }


    /*private fun counter() {

        val printNumber = findViewById<View>(R.id.textView) as TextView
        val ranNumber = Random().nextInt(6) + 1
        printNumber.text = ranNumber.toString()
    }*/

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart ****")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "App Starting", Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", "onResume ****")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause ****")
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "App Stopped", Toast.LENGTH_SHORT).show()
        Log.d("MainActivity", "onStop ****")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity", "onRestart ****")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "onDestroy ****")
    }


}