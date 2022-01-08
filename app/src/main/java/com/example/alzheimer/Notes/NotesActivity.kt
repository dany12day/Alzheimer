package com.example.alzheimer.Notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.alzheimer.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotesActivity : AppCompatActivity() {
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var notesList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        notesList = findViewById<ListView>(R.id.notesList)
        registerForContextMenu(notesList)
        notesAdapter = NotesAdapter(context = this,)
        notesList.adapter = notesAdapter

        notesList.visibility = View.VISIBLE

        val addButton = findViewById<FloatingActionButton>(R.id.add_fab)
        addButton.setOnClickListener{
            val intent = Intent(this@NotesActivity, CreateNoteActivity::class.java)
            startActivity(intent)
        }

        notesList.setOnItemClickListener {adapterView, view, position, id ->
            val note = notesAdapter.getItem(position) as NoteModel

            val intent = Intent(this@NotesActivity, NoteDetailsActivity::class.java)
            intent.putExtra("note_details", note)
            startActivity(intent)
        }
    }

    override fun onResume() {
        notesAdapter.notifyDataSetChanged()
        super.onResume()
    }
}