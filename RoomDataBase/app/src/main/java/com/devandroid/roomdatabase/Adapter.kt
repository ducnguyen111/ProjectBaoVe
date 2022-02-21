package com.devandroid.roomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.devandroid.roomdatabase.model.MC

import com.devandroid.roomdatabase.model.User

class Adapter(
    private val context: Context,
    private val onClick: (MC) -> Unit,
    private val onDelete: (MC) -> Unit
) : RecyclerView.Adapter<Adapter.NoteViewHolder>() {
    private var notes: List<MC> = listOf()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: RadioButton = itemView.findViewById(R.id.txt_item_title)
        private val txtDes: TextView = itemView.findViewById(R.id.txt_item_des)
        private val btnDelete: ImageView = itemView.findViewById(R.id.btn_delete_note)
        private val layoutItem: ConstraintLayout = itemView.findViewById(R.id.layout_item)

        fun onBind(user: MC) {
            txtDes.text =user.title
            txtTitle.text = user.value
            txtTitle.isChecked = user.check
            btnDelete.setOnClickListener { onDelete(user) }
            layoutItem.setOnClickListener { onClick(user) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(notes[position])
    }

    override fun getItemCount(): Int = notes.size

    fun setUser(notes: List<MC>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}