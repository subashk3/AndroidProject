package com.example.contacts

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contacts.database.ContactDataBase
import com.example.contacts.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var contactList = ContactList()
    private var contactUpdate = ContactUpdate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().replace(R.id.my_main_background, contactList)
            .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(
            R.menu.menu_bar,
            menu
        )
//        menu?.getItem(0)?.isVisible = false
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        menu.getItem(0).isVisible = !contactUpdate.isVisible
        menu.getItem(1).isVisible = !contactUpdate.isVisible
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                contactUpdate = ContactUpdate()
            }
            R.id.delete_button -> {
                deleteAllContact()
                Toast.makeText(this, "Delete button", Toast.LENGTH_SHORT).show()
            }
            R.id.add_button -> {
//                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                contactUpdate = ContactUpdate()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.my_main_background, contactUpdate, "CONTACT_UPDATE")
                    .addToBackStack(null)
                    .commit()
            }

        }
        return true
    }
    private fun deleteAllContact() {
        val contactDao = ContactDataBase.getInstance(this)?.contactDao()
        CoroutineScope(Dispatchers.IO).launch {
            contactDao?.deleteAllUsers()
            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, "Deleted All", Toast.LENGTH_SHORT).show()
            }
        }

    }


}

