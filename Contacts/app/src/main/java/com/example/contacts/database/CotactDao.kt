package com.example.contacts.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert
    suspend fun insert(contact: Contact): Long

    @Update
    suspend fun update(contact: Contact): Int

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM CONTACT ORDER BY NAME ASC")
    fun getAllContact(): LiveData<List<Contact>>

    @Query("DELETE FROM CONTACT WHERE ID=:id")
    suspend fun deleteUser(id: Int)

    @Query("DELETE FROM CONTACT")
    fun deleteAllUsers(): Int
}