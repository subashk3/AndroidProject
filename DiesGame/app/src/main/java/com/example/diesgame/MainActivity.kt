package com.example.diesgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var dieImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener { runDies() }
    }

    fun runDies() {

        var randomNumber = (1..6).random()
//        var randomNumber = Random.nextInt(7)
        dieImage = findViewById<ImageView>(R.id.image)
        var drawableImageSource = when (randomNumber) {
            1 -> dieImage.setImageResource(R.drawable.die_1)
            2 -> dieImage.setImageResource(R.drawable.die_2)
            3 -> dieImage.setImageResource(R.drawable.die_3)
            4 -> dieImage.setImageResource(R.drawable.die_4)
            5 -> dieImage.setImageResource(R.drawable.die_5)
            else -> {
                dieImage.setImageResource(R.drawable.die_6)
            }
        }
        //    dieImage.setImageResource(drawableImageSource)
    }
}