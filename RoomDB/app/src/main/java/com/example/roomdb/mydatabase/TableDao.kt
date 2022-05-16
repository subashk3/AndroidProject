package com.example.roomdb.mydatabase

import androidx.room.*

@Dao
interface TableDao {
    @Insert
    fun insert(myTable: MyTable)

    @Update
    fun update(myTable: MyTable)

    @Delete
    fun delete(myTable: MyTable)

    @Query("SELECT * FROM MY_TABLE")
    fun getAllData(): List<MyTable>


    @Query("DELETE FROM MY_TABLE WHERE ID = :id")
    fun deleteUser(id: Int)

    @Query("SELECT * FROM MY_TABLE WHERE ID = :id")
    fun selectUserId(id: Int): MyTable?

    @Query(" UPDATE My_Table set first_name=:firstName, last_name=:lastName where ID = :id")
    fun updateUser(id: Int, firstName: String, lastName: String)


}