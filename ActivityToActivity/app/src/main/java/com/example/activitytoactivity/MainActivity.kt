package com.example.activitytoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var enterButton: Button
    private lateinit var firstEditView: EditText
    private lateinit var secondEditView: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enterButton = findViewById(R.id.enter)
        firstEditView = findViewById(R.id.first_name)
        secondEditView = findViewById(R.id.second_name)
        val intent = Intent(this, Details::class.java)
        enterButton.setOnClickListener {
            intent.putExtra("first", firstEditView.text.toString())
            intent.putExtra("second", secondEditView.text.toString())
            startActivity(intent)
        }
    }
}


