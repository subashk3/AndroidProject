package com.example.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contacts.ContactUpdate


@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase :
    RoomDatabase() {
    abstract fun contactDao(): ContactDao

    /* private class ContactCallBack(private val scope: CoroutineScope) : RoomDatabase.Callback() {
         override fun onCreate(db: SupportSQLiteDatabase) {
             super.onCreate(db)
             INSTANCE?.let { database ->
                 scope.launch {
                     var contactDao = database.contactDao()

                     //Delete all Contact
                     contactDao.deleteAllUsers()

                 }

             }
         }
     }*/


    companion object {

        @Volatile
        private var INSTANCE: ContactDataBase? = null

        /* fun getInstance(context: Context, scope: CoroutineScope): ContactDataBase {


             return INSTANCE ?: synchronized(this) {
                 val instance = Room.databaseBuilder(
                     context.applicationContext,
                     ContactDataBase::class.java,
                     "contact_databse"
                 )
                     .addCallback(ContactCallBack(scope))
                     .build()
                 INSTANCE = instance
                 // return instance
                 instance

             }
         }*/

        fun getInstance(context: Context): ContactDataBase? {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, ContactDataBase::class.java, "contact").build()
            }
            return INSTANCE
        }

    }

}