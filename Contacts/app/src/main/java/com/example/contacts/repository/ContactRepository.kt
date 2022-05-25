package com.example.contacts.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.contacts.database.Contact
import com.example.contacts.database.ContactDao

class ContactRepository(private val contactDoa: ContactDao) {

    val allContact: LiveData<List<Contact>> = contactDoa.getAllContact()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: Contact) {
        contactDoa.insert(user)
    }
}