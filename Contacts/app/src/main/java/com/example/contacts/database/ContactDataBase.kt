package com.example.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.contacts.ContactList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase :
    RoomDatabase() {

    companion object {
        @Volatile
        private var OBJECT: ContactDataBase? = null

        fun getTableObject(context: Context, scope: CoroutineScope): ContactDataBase? {
            if (OBJECT == null) {
                OBJECT =
                    Room.databaseBuilder(context, ContactDataBase::class.java, "contact")
                        .addCallback(ContactDatabaseCallBack(scope)).build()
                return OBJECT
            }
            return OBJECT
        }


        private class ContactDatabaseCallBack(private val scope: CoroutineScope) :
            RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                OBJECT?.let { database ->
                    scope.launch {
                        populateDatabase(database.contactDao())
                    }
                }
            }

            private fun populateDatabase(contactDao: ContactDao) {
                contactDao.deleteAllUsers()
                val user: Contact = Contact(0, "A SampleName", "+91 9876543210", "sample@gmail.com")
                contactDao.insert(user)


            }
        }

    }


    abstract fun contactDao(): ContactDao
}