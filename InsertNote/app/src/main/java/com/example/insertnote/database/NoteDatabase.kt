package com.example.insertnote.database

import android.content.Context
import androidx.room.*


@Database(entities = [Notes::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    companion object {
       private var OBJECT: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase? {
            if (OBJECT == null) {
                OBJECT = Room.databaseBuilder(context, NoteDatabase::class.java, "Notes"
                ).build()
            }
            return OBJECT
        }
    }

    abstract fun noteDao(): NoteDao


}