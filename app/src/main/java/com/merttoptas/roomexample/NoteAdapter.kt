package com.merttoptas.roomexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter (private val notes : List<Note>, val context: Context) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, p0, false))
    }

    override fun getItemCount(): Int=notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle?.text = notes[position].title
        holder.tvSubject?.text = notes[position].subject
        holder.tvDescrition?.text = notes[position].description

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle = view.rc_txt_title
        val tvSubject = view.rc_txt_subject
        val tvDescrition = view.rc_txt_description
    }
}