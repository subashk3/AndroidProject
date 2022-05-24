package com.example.insertnote.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NoteDao {
    @Insert
    fun insert(notes: Notes)
}