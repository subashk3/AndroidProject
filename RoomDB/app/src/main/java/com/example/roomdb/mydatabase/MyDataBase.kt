package com.example.roomdb.mydatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyTable::class], version = 1)
abstract class MyDataBase : RoomDatabase() {

    companion object {
        private var OBJECT: MyDataBase? = null
        fun getInstance(context: Context): MyDataBase? {

            if (OBJECT == null) {
                OBJECT = Room.databaseBuilder(context, MyDataBase::class.java, "MyDataBase").build()
                return OBJECT
            }
            return OBJECT
        }

    }
    abstract fun tableDao(): TableDao
}