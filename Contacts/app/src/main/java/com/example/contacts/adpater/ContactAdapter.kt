package com.example.contacts.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.database.Contact
import com.example.contacts.util.ContactUtil
import kotlinx.android.synthetic.main.contact_item.view.*
import java.util.*


class ContactAdapter(private val context: Context, private var list: List<Contact>) :

    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val logo = view.logo_text
        val contactName = view.contact_name
        val contactNumber = view.contact_number
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact: Contact = list[position]
        holder.contactName.text = contact.userName
        holder.contactNumber.text = contact.mobileNumber
        holder.logo.text = contact.userName[0].toString().uppercase(Locale.ROOT)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun setContact(newContactList: List<Contact>) {
        val contactDiffUtil = ContactUtil(list, newContactList)
        val contactResult = DiffUtil.calculateDiff(contactDiffUtil,true)
        list.toMutableList().clear()
        list.toMutableList().addAll(newContactList)
        contactResult.dispatchUpdatesTo(this)

    }
}
