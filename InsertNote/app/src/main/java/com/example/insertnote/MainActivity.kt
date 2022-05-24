package com.example.insertnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val NEW_NOTE_ACTIVITY_REQUEST: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton: FloatingActionButton = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val intent = Intent(this@MainActivity, NoteActivity::class.java)
            startActivityForResult(intent, NEW_NOTE_ACTIVITY_REQUEST)

        }
    }


}