package com.merttoptas.roomexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create a notes in list
        val notes:List<Note>

        val db:AppDatabase= Room.databaseBuilder(this,AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        //Get a notes
        notes=db.notedao().getAllNotes()

        //set adapter
        recyclerview.layoutManager= LinearLayoutManager(this)
        recyclerview.adapter=NoteAdapter(notes,this@MainActivity)

        fab.setOnClickListener {
            val intent= Intent(this,CreateNoteActivity::class.java)
            startActivity(intent)
        }
    }
}
