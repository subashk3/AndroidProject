package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.AdapterListUpdateCallback

class SignUp : AppCompatActivity() {
    private val genderList = arrayOf("Gender", "Male", "Female", "Other")
    private lateinit var spinner: Spinner
    private lateinit var backButton: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        /*|------Spinner widget-----|*/
        spinner = findViewById(R.id.gender)
        val listOfGender = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            genderList
        )
        spinner.adapter = listOfGender
        /*|------End of Spinner-----|*/
        backButton = findViewById(R.id.back_login)
        val intent = Intent(this, MainActivity::class.java)
        backButton.setOnClickListener {
            startActivity(intent)
        }


    }
}