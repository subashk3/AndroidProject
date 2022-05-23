package com.example.contacts.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Int,
    @ColumnInfo(name = "NAME")
    var userName: String,
    @ColumnInfo(name = "MOBILE")
    var mobileNumber: String,
    @ColumnInfo(name = "EMAIL")
    var email: String
    )