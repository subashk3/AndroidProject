package com.example.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase :
    RoomDatabase() {

    companion object {

        private var OBJECT: ContactDataBase? = null

        fun getTableObject(context: Context): ContactDataBase? {
            if (OBJECT == null) {
                OBJECT =
                    Room.databaseBuilder(context, ContactDataBase::class.java, "contact").build()
                return OBJECT
            }
            return OBJECT
        }

    }

    abstract fun contactDao(): ContactDao
}