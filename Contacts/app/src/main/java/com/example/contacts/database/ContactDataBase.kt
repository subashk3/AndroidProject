package com.example.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase :
    RoomDatabase() {
    companion object {
        @Volatile
        private var OBJECT: ContactDataBase? = null
        fun getInstance(context: Context): ContactDataBase? {
            if (OBJECT == null) {
                OBJECT = Room.databaseBuilder(context, ContactDataBase::class.java, "contact").build()
            }
            return OBJECT
        }
    }
    abstract fun contactDao(): ContactDao
}