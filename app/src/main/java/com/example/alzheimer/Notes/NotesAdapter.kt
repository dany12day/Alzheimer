package com.example.alzheimer.Notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.alzheimer.R

class NotesAdapter(context: Context): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    companion object{
        private var dataSource: MutableList<NoteModel> = mutableListOf()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        println(dataSource)
        val itemView = inflater.inflate(R.layout.notes_list_item, parent, false)
        val notesLabel = itemView.findViewById<TextView>(R.id.notesLabel)
        val noteDateLabel = itemView.findViewById<TextView>(R.id.noteDateLabel)
        val note = getItem(position) as NoteModel

        notesLabel.text = note.title
        noteDateLabel.text = "${note.date.dayOfMonth} ${note.date.month} ${note.date.year}"

        return itemView
    }

    fun removeNote(position: Int) {
        dataSource.removeAt(position)
        notifyDataSetChanged()
    }

    fun setList(newList: MutableList<NoteModel>){
        dataSource = newList
        notifyDataSetChanged()
    }
}