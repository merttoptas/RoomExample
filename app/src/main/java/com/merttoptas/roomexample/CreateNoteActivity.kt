package com.merttoptas.roomexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_create_note.*

class CreateNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

         val db:AppDatabase= Room.databaseBuilder(applicationContext,AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        btn_Add.setOnClickListener {

            if(txt_Title.text!!.isEmpty()  || _txt_Subject.text!!.isEmpty()  || txt_description.text!!.isEmpty()){

                Toast.makeText(applicationContext, "Empty!!", Toast.LENGTH_SHORT).show()

            }else{
                val note:Note= Note(txt_Title.text.toString(),_txt_Subject.text.toString(),txt_description.text.toString())
                db.notedao().insertAll(note)
                startActivity(Intent(this@CreateNoteActivity,MainActivity::class.java))
                finish()
            }

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
