package com.example.roomdb.itemadapter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.EditActivity
import com.example.roomdb.MainActivity
import com.example.roomdb.R
import com.example.roomdb.mydatabase.MyDataBase
import com.example.roomdb.mydatabase.MyTable
import kotlinx.android.synthetic.main.item_list_card.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ItemAdapter(private val context: MainActivity, private val list: List<MyTable>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private lateinit var editButton: ImageButton
    private lateinit var deleteButton: ImageButton


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            editButton = view.edit_button
            deleteButton = view.delete_button
        }

        var firstName: TextView = view.tv_first_name
//      var secondName = view.tv_second_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_list_card, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: MyTable = list[position]
        holder.firstName.text = user.firstName + " " + user.lastName

        // Edit Button Actions
        editButton.setOnClickListener {
            // Log.d("Test", "Edited for ${user.firstName}")
            navigateEditPage(user.id, user.firstName, user.lastName)
        }

        // Delete Button Actions
        deleteButton.setOnClickListener {
            val myDataBase = MyDataBase.getInstance(context)
            val database = myDataBase?.tableDao()
            CoroutineScope(Dispatchers.IO).launch {
                database?.deleteUser(user.id)
                withContext(Dispatchers.Main) {
                    context.getDataList()
                }
            }
        }
        //  notifyItemChanged(holder.adapterPosition)
    }

    private fun navigateEditPage(id: Int, firstName: String, lastName: String) {
        val bundle = Bundle()
        val intent = Intent(context, EditActivity::class.java)
        bundle.putString("id", id.toString())
        bundle.putString("first", firstName)
        bundle.putString("last", lastName)
        intent.putExtras(bundle)
        startActivity(context, intent, bundle)
    }


    override fun getItemCount(): Int {
        return list.size
    }
}


