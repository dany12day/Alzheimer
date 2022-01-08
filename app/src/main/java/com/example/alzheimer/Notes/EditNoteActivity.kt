package com.example.alzheimer.Notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser
import com.google.android.material.textfield.TextInputEditText
import java.time.LocalDateTime
import android.content.Intent




class EditNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        val note = intent.getSerializableExtra("note_details") as NoteModel

        val titleInput = findViewById<TextInputEditText>(R.id.editNoteTitleInput)
        val contentInput = findViewById<TextInputEditText>(R.id.editNoteContentInput)

        titleInput.setText(note.title, TextView.BufferType.EDITABLE)
        contentInput.setText(note.content, TextView.BufferType.EDITABLE)
        val editButton = findViewById<Button>(R.id.modifyNoteButton)
        editButton.setOnClickListener {
            var index = -1
            for((i,sel_note) in CurrentUser.userInfo.userData.notesList.withIndex()){
                if(sel_note.title.equals(note.title) && sel_note.content.equals(note.content))
                    index = i
            }
            CurrentUser.userInfo.userData.notesList[index].title = titleInput.text.toString()
            CurrentUser.userInfo.userData.notesList[index].content = contentInput.text.toString()
            CurrentUser.userInfo.userData.notesList[index].date = LocalDateTime.now()

            val intent = Intent()
            intent.putExtra("note", CurrentUser.userInfo.userData.notesList[index])
            setResult(2, intent)
            finish()
        }
    }
}