package com.example.testfragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var firstButton: Button
    private lateinit var secondButton: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstButton = findViewById(R.id.button_fragment_one)
        secondButton = findViewById(R.id.button_fragment_two)

        firstButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_id, FragmentsOne())
                .commit()
        }
        secondButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_id, FragmentsTwo())
                .commit()
        }


    }
}

