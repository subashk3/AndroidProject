package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val contactList = ContactList()
        supportFragmentManager.beginTransaction().replace(R.id.my_main_background, contactList)
            .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(
            R.menu.menu_bar,
            menu
        )
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_button -> {
                val contactUpdate = ContactUpdate()
                supportFragmentManager.beginTransaction().replace(R.id.my_main_background, contactUpdate)
                    .commit()

                Toast.makeText(this, "Add button", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                return true
            }
        }
    }

}

