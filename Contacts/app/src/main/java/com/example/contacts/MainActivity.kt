package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val contactList = ContactList()
    private val contactUpdate = ContactUpdate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.beginTransaction().replace(R.id.my_main_background, contactList)
            .commit()
        // Back Button enable
//      supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //        invalidateOptionsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(
            R.menu.menu_bar,
            menu
        )
//        menu?.getItem(0)?.isVisible = false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
            R.id.add_button -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.my_main_background, contactUpdate, "CONTACT_UPDATE")
                    .addToBackStack(null)
                    .commit()
            }
        }
        return true
    }
}

