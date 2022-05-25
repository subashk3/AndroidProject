package com.example.contacts.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope

import com.example.contacts.database.Contact
import com.example.contacts.repository.ContactRepository
import kotlinx.coroutines.launch


class ContactViewModel(private val repository: ContactRepository) : ViewModel() {


    val allContact: LiveData<List<Contact>> = repository.allContact


    /* Insert function */
    fun insert(user: Contact) = viewModelScope.launch {
        repository.insert(user)
    }


}

class ContactViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}