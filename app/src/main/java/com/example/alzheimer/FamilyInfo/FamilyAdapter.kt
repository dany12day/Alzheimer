package com.example.alzheimer.FamilyInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.alzheimer.R

class FamilyAdapter(context: Context): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    companion object{
        private var dataSource: MutableList<FamilyModel> = mutableListOf()
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
        val itemView = inflater.inflate(R.layout.family_list_item, parent, false)
        val nameLabel = itemView.findViewById<TextView>(R.id.person_name)
        val phoneNumber = itemView.findViewById<TextView>(R.id.phoneNumber)
        val person = getItem(position) as FamilyModel

        nameLabel.text = person.name
        phoneNumber.text = person.phoneNumber

        return itemView
    }

    fun setList(newList: MutableList<FamilyModel>){
        dataSource = newList
        notifyDataSetChanged()
    }

}