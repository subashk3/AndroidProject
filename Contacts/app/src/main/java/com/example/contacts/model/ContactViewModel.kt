package com.example.contacts.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.contacts.database.Contact
import com.example.contacts.repository.ContactRepository


class ContactViewModel(repository: ContactRepository) : ViewModel() {


    val allContact: LiveData<List<Contact>> = repository.allContact

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */




}

class WordViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}