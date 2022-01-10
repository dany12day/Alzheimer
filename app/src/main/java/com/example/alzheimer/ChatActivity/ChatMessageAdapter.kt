package com.example.alzheimer.ChatActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alzheimer.R

class ChatMessageAdapter : RecyclerView.Adapter<ChatMessageAdapter.ChatMessageViewHolder>() {

    private val dataSource = mutableListOf<ChatMessage>()
    private var design = 1

    override fun getItemViewType(position: Int) =
        when (design) {
            1 -> R.layout.chat_design_1
            2 -> R.layout.chat_design_2
            else -> {
                if (position % 2 == 0) R.layout.chat_design_1
                else R.layout.chat_design_2
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatMessageViewHolder {
        val elementView = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return ChatMessageViewHolder(elementView, viewType)
    }

    override fun onBindViewHolder(holder: ChatMessageViewHolder, position: Int) {
        val item = dataSource[position]
        holder.bindData(item)
    }

    override fun getItemCount(): Int = dataSource.size

    fun setDesign(design: Int) {
        this.design = design
        notifyDataSetChanged()
    }

    fun insertMessage(message: ChatMessage) {
        dataSource.add(0, message)
        this.notifyItemInserted(0)
    }

    inner class ChatMessageViewHolder(itemView: View, design: Int) : RecyclerView.ViewHolder(itemView) {
        private var authorTextView: TextView
        private var contentTextView: TextView
        private var timestampTextView: TextView

        init {
            if (design == R.layout.chat_design_1) {
                authorTextView = itemView.findViewById(R.id.tvAuthor)
                contentTextView = itemView.findViewById(R.id.tvMessage)
                timestampTextView = itemView.findViewById(R.id.tvTimestamp)
            } else {
                authorTextView = itemView.findViewById(R.id.tvAuthor2)
                contentTextView = itemView.findViewById(R.id.tvMessage2)
                timestampTextView = itemView.findViewById(R.id.tvTimestamp2)
            }

        }

        fun bindData(data: ChatMessage) {
            authorTextView.text = data.sender
            contentTextView.text = data.text
            timestampTextView.text = data.timestamp
        }
    }
}