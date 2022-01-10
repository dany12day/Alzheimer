package com.example.alzheimer.FamilyInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.alzheimer.Emergency.CallActivity
import com.example.alzheimer.Notes.CreateNoteActivity
import com.example.alzheimer.Notes.NotesAdapter
import com.example.alzheimer.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FamilyInfoActivity : AppCompatActivity() {
    private lateinit var familyAdapter: FamilyAdapter
    private lateinit var familyList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_info)

        familyList = findViewById(R.id.familyList)
        familyAdapter = FamilyAdapter(this)
        familyList.adapter = familyAdapter

        familyList.visibility = View.VISIBLE

        familyList.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, CallActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        familyAdapter.notifyDataSetChanged()
        super.onResume()
    }
}