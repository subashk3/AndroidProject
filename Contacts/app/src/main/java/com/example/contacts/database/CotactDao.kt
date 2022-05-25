package com.example.contacts.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)

    @Query("SELECT * FROM CONTACT ORDER BY NAME ASC")
    fun getAllContact(): LiveData<List<Contact>>

    @Query("DELETE FROM CONTACT WHERE ID=:id")
    fun deleteUser(id: Int)

    @Query("DELETE FROM CONTACT")
    fun deleteAllUsers()
}