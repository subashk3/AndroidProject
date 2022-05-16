package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val listOfColor = arrayOf("RED", "GREEN", "YELLOW", "BLUE", "BLACK", "WHITE")
    private val nameList =
        arrayOf(
            "Anbu",
            "Arvind",
            "Ajith",
            "Muthuram",
            "Arul",
            "Kumar",
            "Santhosh",
            "Subash K",
            "Suthakar"
        )


    //List view data
    private lateinit var listTemplate: ListView
    private var arrayOfList = arrayOf("Android", "Kotlin", "Java", "JavaScript")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*DataBinding Testing*/
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.person = Person("NewName")

        // setContentView(R.layout.activity_main)

//        binding.spinner.adapter = test
        //  val test = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOfColor)
        //   val spin: Spinner = findViewById<Spinner>(R.id.spinner) as TextView
        //    spin.adapter = test

        val autoCompleteAdapter =
            ArrayAdapter(this, androidx.appcompat.R.layout.select_dialog_item_material, nameList)
        val autoCompleteViewer = findViewById<AutoCompleteTextView>(R.id.autoCompleteId)
        autoCompleteViewer.threshold = 1
        autoCompleteViewer.setAdapter(autoCompleteAdapter)
//        autoCompleteViewer.setTextColor(Color.RED)


        listTemplate = binding.listView
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_expandable_list_item_1,
            arrayOfList
        )
        listTemplate.adapter = adapter

    }


}