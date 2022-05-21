package com.example.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton = findViewById<MaterialButtonToggleGroup>(R.id.toggle_button)
        toggleButton.addOnButtonCheckedListener { _, checkId, ischeck ->
            run {
                if (ischeck) {
                    when (checkId) {
                        R.id.first_button -> Toast.makeText(this,
                            "First Button Clicked",
                            Toast.LENGTH_SHORT).show()
                        R.id.second_button -> Toast.makeText(this,
                            "Second Button Clicked",
                            Toast.LENGTH_SHORT).show()
                        R.id.third_button -> Toast.makeText(this,
                            "Third Button Clicked",
                            Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


