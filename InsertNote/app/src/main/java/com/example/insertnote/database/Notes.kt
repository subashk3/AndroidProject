package com.example.insertnote.database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Int,
    @ColumnInfo(name = "NOTE")
    var note: String,
)