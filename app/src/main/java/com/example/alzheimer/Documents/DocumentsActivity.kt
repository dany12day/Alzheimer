package com.example.alzheimer.Documents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ListView
import com.example.alzheimer.Notes.CreateNoteActivity
import com.example.alzheimer.Notes.NotesAdapter
import com.example.alzheimer.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DocumentsActivity : AppCompatActivity() {
    private lateinit var documentAdapter: DocumentAdapter
    private lateinit var documentsList: ListView

    var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_documents)

        documentsList = findViewById<ListView>(R.id.documentsList)
        documentAdapter = DocumentAdapter(this)
        documentsList.adapter = documentAdapter

        documentsList.visibility = View.VISIBLE

        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        val fabRClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
        val fabRAntiClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlockwise)

        val addButton = findViewById<FloatingActionButton>(R.id.add_document_fab)
        val fileButton = findViewById<FloatingActionButton>(R.id.fileButton)
        val cameraButton = findViewById<FloatingActionButton>(R.id.cameraButton)
        addButton.setOnClickListener{
            if(isOpen){
                fileButton.startAnimation(fabClose)
                cameraButton.startAnimation(fabClose)
                addButton.startAnimation(fabRClockwise)

                isOpen = false
            }
            else
            {
                fileButton.startAnimation(fabOpen)
                cameraButton.startAnimation(fabOpen)
                addButton.startAnimation(fabRAntiClockwise)

                fileButton.isClickable
                cameraButton.isClickable

                isOpen = true
            }

            fileButton.setOnClickListener{

            }
        }
    }

    fun selectImage(){

    }
}