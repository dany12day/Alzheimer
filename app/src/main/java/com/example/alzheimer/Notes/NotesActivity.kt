package com.example.alzheimer.Notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.alzheimer.HomeRegisterLogin.MainActivity
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser

class NotesActivity : AppCompatActivity() {
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var notesList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        notesList = findViewById<ListView>(R.id.notesList)
        notesAdapter = NotesAdapter(this)
        notesList.adapter = notesAdapter
        notesList.visibility = View.VISIBLE
    }
}