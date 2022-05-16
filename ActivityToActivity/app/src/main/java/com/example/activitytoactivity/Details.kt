package com.example.activitytoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Details : AppCompatActivity() {
    private lateinit var firstName: TextView
    private lateinit var secondName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        firstName = findViewById(R.id.first_get_name)
        secondName = findViewById(R.id.second_get_name)
        var firstNameOfUser = intent.getStringExtra("first")
        var secondNameOfUser = intent.getStringExtra("second")
        firstName.text = firstNameOfUser
        secondName.text = secondNameOfUser
    }
}