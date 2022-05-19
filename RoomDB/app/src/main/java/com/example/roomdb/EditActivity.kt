package com.example.roomdb

import android.content.Intent
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
    private lateinit var bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        bundle = intent.extras!!

        CoroutineScope(Dispatchers.IO).launch {
            val editUser = MyDataBase.getInstance(this@EditActivity)?.tableDao()
                ?.selectUserId(bundle.get("id") as Int)
            withContext(Dispatchers.Main) {
                val tempFirstName = editUser?.firstName.toString()
                val tempSecondName = editUser?.lastName.toString()
                edit_first_name.setText(tempFirstName)
                edit_second_name.setText(tempSecondName)
            }

        }


        //Update user
        update_button.setOnClickListener {
            updateUser(bundle.get("id") as Int)
        }
    }


    private fun updateUser(id: Int) {
        val dataBase = MyDataBase.getInstance(this)?.tableDao()
        val editFirstName = edit_first_name.text.toString().trim()
        val editSecondName = edit_second_name.text.toString().trim()
        //var userData: MyTable?
        CoroutineScope(Dispatchers.IO).launch {
            dataBase?.updateUser(id,
                editFirstName,
                editSecondName)
            //  userData = dataBase?.selectUserId(id)
            withContext(Dispatchers.Main) {
                val intent = Intent(this@EditActivity, MainActivity::class.java)
                startActivity(intent)
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




