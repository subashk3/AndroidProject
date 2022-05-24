package com.example.insertnote.viewmodel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel

import com.example.insertnote.database.NoteDao
import com.example.insertnote.database.NoteDatabase
import com.example.insertnote.database.Notes

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = this.javaClass.name
    private var noteDatabase: NoteDao? = null

    init {
        val noteDatabase = NoteDatabase?.getInstance(application)?.noteDao()
    }

    fun insert(notes: Notes) {
        val execute = InsertAsyncTask(noteDatabase).execute(notes)
    }

    class InsertAsyncTask(noteDatabase: NoteDao?) : AsyncTask<Notes, Unit, Unit>() {
        lateinit var noteDatabase: NoteDao

        init {
            if (noteDatabase != null) {
                this.noteDatabase = noteDatabase
            }
        }

        override fun doInBackground(vararg params: Notes?): Unit? {


            return null
        }

    }

}