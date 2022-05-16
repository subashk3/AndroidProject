package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var signUpButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*--------Button action -----*/
        signUpButton = findViewById(R.id.signIn)
        val intent = Intent(this, SignUp::class.java)
        signUpButton.setOnClickListener { startActivity(intent) }

    }
}