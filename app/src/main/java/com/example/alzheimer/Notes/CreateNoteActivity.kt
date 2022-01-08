package com.example.alzheimer.Notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDateTime

class CreateNoteActivity : AppCompatActivity() {
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)
        notesAdapter = NotesAdapter(context = this,)
        val addButton = findViewById<Button>(R.id.createNoteButton)
        addButton.setOnClickListener { addNote() }
    }

    fun addNote(){
        val title = findViewById<TextInputEditText>(R.id.titleFormInput)
        val content = findViewById<TextInputEditText>(R.id.contentFormInput)
        val note = NoteModel(title = title.text.toString(), content = content.text.toString(), date = LocalDateTime.now())
        CurrentUser.userInfo.userData.notesList.add(note)
        notesAdapter.notifyDataSetChanged()
        finish()
    }
}