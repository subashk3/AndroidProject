package com.example.fragmentcommunicate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.display_template, fragmentA).commit()
    }

    override fun pushData(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("inputData", editTextInput)  // put the data to bundle object
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle
        // next frag
        transaction.replace(R.id.display_template, fragmentB).commit()
    }


}