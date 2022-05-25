package com.example.contacts.model

import android.app.Application
import com.example.contacts.database.ContactDataBase
import com.example.contacts.repository.ContactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ContactApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())


    val database by lazy {
        ContactDataBase.getTableObject(this, applicationScope)
    }
    val repository by lazy { database?.let { ContactRepository(it.contactDao()) } }

}