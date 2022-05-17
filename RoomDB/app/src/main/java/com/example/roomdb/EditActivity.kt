package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdb.mydatabase.MyDataBase
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class EditActivity : AppCompatActivity() {
    //   val testString = "Edit"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val bundle = intent.extras
        edit_first_name.setText(bundle?.get("first").toString())
        edit_second_name.setText(bundle?.get("last").toString())

        //Update user
        update_button.setOnClickListener {
            updateUser(bundle?.get("id").toString().toInt())
        }
    }

    private fun updateUser(id: Int) {
        val myDataBase = MyDataBase.getInstance(this)
        val dataBase = myDataBase?.tableDao()
        var editFirstName = edit_first_name.text.toString().trim()
        var editSecondName = edit_second_name.text.toString().trim()
        CoroutineScope(Dispatchers.IO).launch {
            dataBase?.updateUser(id,
                editFirstName,
                editSecondName)
            withContext(Dispatchers.Main) {
                /*val intent = Intent(this@EditActivity, MainActivity::class.java)
                startActivity(intent)*/
            }
        }
        clearData()
        Toast.makeText(this@EditActivity, "Update Successfully", Toast.LENGTH_LONG).show()
    }

    private fun clearData() {
        edit_first_name.text = null
        edit_second_name.text = null
    }
}


