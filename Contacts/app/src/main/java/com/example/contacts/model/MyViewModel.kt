package com.example.contacts.model


import android.app.Application
import androidx.lifecycle.*
import com.example.contacts.database.Contact
import com.example.contacts.database.ContactDao
import com.example.contacts.database.ContactDataBase

class MyViewModel(application: Application) : AndroidViewModel(application) {
    private var contactList: LiveData<List<Contact>>
    private var myDatabase: ContactDao? = null
    init {
        myDatabase = ContactDataBase.getInstance(getApplication())?.contactDao()
        contactList = myDatabase?.getAllContact()!!
    }
    fun getUserContactList() = contactList

    fun deleteAllContact() {
        myDatabase?.deleteAllUsers()
    }

}
