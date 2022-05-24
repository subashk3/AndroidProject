package com.example.contacts.database

import androidx.room.*

interface ContactDao {
    @Insert
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)

    @Query("SELECT * FROM CONTACT")
    fun getAllContact(): List<Contact>

    @Query("DELETE FROM CONTACT WHERE ID=:id")
    fun deleteUser(id: Int)

    @Query("DELETE FROM CONTACT")
    fun deleteAllUsers()
}