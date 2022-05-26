package com.example.contacts.model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.database.Contact
import com.example.contacts.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository) : ViewModel() {
    val name = MutableLiveData<String>()
    val mobile = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    fun insertContact() {
        var userName = name.value!!
        var userMobile = mobile.value!!
        var userEmail = email.value!!
        insertUser(Contact(0, userName, userMobile, userEmail))
        userName = ""
        userMobile = ""
        userEmail = ""

        Log.d("My test", "Updated")
    }

    private fun insertUser(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }
}