package com.example.alzheimer.Emergency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.alzheimer.Maps.ImportantLocation

class ContactsAdapter (
    private val context: Context,
) : BaseAdapter() {

    companion object {

        private var contactsList: MutableList<Contact> = mutableListOf()

        private var contact: Contact = Contact("", "")
    }

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = contactsList.size

    override fun getItem(p0: Int): Any = contactsList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    fun getContactsList(): MutableList<Contact> {
        return contactsList
    }

    fun getContactsNameList(): MutableList<String> {
        var names : MutableList<String> = mutableListOf()
        val numbersIterator =  contactsList.iterator()
        while (numbersIterator.hasNext()) {
            numbersIterator.next().name?.let { names.add(it) }
        }
        return names
    }

    fun setList(importantLocationsListNew: MutableList<Contact>) {
        contactsList = importantLocationsListNew
        notifyDataSetChanged()
    }
}