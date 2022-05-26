package com.example.contacts.database

import kotlinx.coroutines.flow.Flow
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
    fun getAllContact(): Flow<List<Contact>>

    @Query("DELETE FROM CONTACT WHERE ID=:id")
    suspend fun deleteUser(id: Int)

    @Query("DELETE FROM CONTACT")
    suspend fun deleteAllUsers(): Int
}