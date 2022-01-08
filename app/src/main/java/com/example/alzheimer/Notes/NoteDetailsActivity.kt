package com.example.alzheimer.Notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser

class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var note: NoteModel
    private lateinit var adapter: NotesAdapter
    private lateinit var title: TextView
    private lateinit var content: TextView
    private lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)
        adapter = NotesAdapter(context = this)
        note = intent.getSerializableExtra("note_details") as NoteModel

        title = findViewById<TextView>(R.id.noteDetailsTitle)
        date = findViewById<TextView>(R.id.noteDetailsDate)
        content = findViewById<TextView>(R.id.noteDetailsContent)

        title.text = note.title
        date.text = "${note.date.dayOfMonth} ${note.date.month} ${note.date.year}"
        content.text = note.content

        val editButton = findViewById<Button>(R.id.editNoteButton)
        editButton.setOnClickListener {
            val intent = Intent(this@NoteDetailsActivity, EditNoteActivity::class.java)
            intent.putExtra("note_details", note)
            startActivityForResult(intent, 2)
        }

        val deleteButton = findViewById<Button>(R.id.deleteNoteButton)
        deleteButton.setOnClickListener {
            var index = -1
            for((i,sel_note) in CurrentUser.userInfo.userData.notesList.withIndex()){
                if(sel_note.title.equals(note.title) && sel_note.content.equals(note.content))
                    index = i
            }
            if(index!=-1)
                CurrentUser.userInfo.userData.notesList.removeAt(index)
            finish()
        }
    }

    override fun onResume() {
        adapter.notifyDataSetChanged()
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 2){
            note = data?.getSerializableExtra("note") as NoteModel
            title.text = note.title
            date.text = "${note.date.dayOfMonth} ${note.date.month} ${note.date.year}"
            content.text = note.content
        }
    }
}