package com.example.rockpaperscisoor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var firstPlayerImage: ImageView
    private lateinit var secondPlayerImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener { gameStart() }

    }

    private fun gameStart() {
        val firstPlayerNumber = (1..3).random()
        val secondPlayerNumber = (1..3).random()
        firstPlayerImage = findViewById(R.id.first_player)
        secondPlayerImage = findViewById(R.id.second_player)
        /*First player images load*/
        when (firstPlayerNumber) {
            1 -> firstPlayerImage.setImageResource(R.drawable.image_1)
            2 -> firstPlayerImage.setImageResource(R.drawable.image_2)
            else -> firstPlayerImage.setImageResource(R.drawable.image_3)
        }
        /*Second player images load*/
        when (secondPlayerNumber) {
            1 -> secondPlayerImage.setImageResource(R.drawable.image_1)
            2 -> secondPlayerImage.setImageResource(R.drawable.image_2)
            else -> secondPlayerImage.setImageResource(R.drawable.image_3)
        }

        if (firstPlayerNumber == secondPlayerNumber) {
            Toast.makeText(this, "Match Draw", Toast.LENGTH_SHORT).show()
        } else if (firstPlayerNumber == 1) {
            if (secondPlayerNumber == 2) {
                Toast.makeText(this, "Second Player win", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Fist Player win", Toast.LENGTH_SHORT).show()
            }

        } else if (firstPlayerNumber == 2) {

            if (secondPlayerNumber == 3) {
                Toast.makeText(this, "Second Player win", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "First Player win", Toast.LENGTH_SHORT).show()
            }

        } else {
            if (secondPlayerNumber == 1) {
                Toast.makeText(this, "Second Player win", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "First Player win", Toast.LENGTH_SHORT).show()
            }

        }


    }
}