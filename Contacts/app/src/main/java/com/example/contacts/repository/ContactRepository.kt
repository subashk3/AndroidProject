package com.example.contacts.repository

import com.example.contacts.database.Contact
import com.example.contacts.database.ContactDao

class ContactRepository(private val contactDao: ContactDao) {
    val contact = contactDao.getAllContact()


    suspend fun insert(contact: Contact): Long {
        return contactDao.insert(contact)

    }

    suspend fun update(contact: Contact): Int {
        return contactDao.update(contact)
    }

    suspend fun delete(contact: Contact) {
        return contactDao.delete(contact)
    }

    suspend fun deleteAll(): Int {
        return contactDao.deleteAllUsers()
    }


}