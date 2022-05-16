package com.example.bindingtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
private lateinit var firstButton : Button
private lateinit var secondtButton : Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.layout.fragment_first_fragement,FirstFragments())
        firstButton=findViewById(R.id.btn1)
        secondtButton=findViewById(R.id.btn2)
    }
    /*private fun replaceFra(result: Fragment) {
        val fragementManger: FragmentManager = supportFragmentManager
        val fragmentTranscation: FragmentTransaction = fragementManger.beginTransaction()
        fragmentTranscation.replace(R.id.fragment_id, result)
        fragmentTranscation.commit()
    }*/
}