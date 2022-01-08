package com.example.alzheimer.Documents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.alzheimer.R

class DocumentAdapter(context: Context): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    companion object{
        private var dataSource: MutableList<DocumentModel> = mutableListOf()
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
        val itemView = inflater.inflate(R.layout.document_list_item, parent, false)
        val documentTitle = itemView.findViewById<TextView>(R.id.documentTitle)
        val document = getItem(position) as DocumentModel

        documentTitle.text = document.title

        return itemView
    }

    fun setList(newList: MutableList<DocumentModel>){
        dataSource = newList
        notifyDataSetChanged()
    }
}