package com.merttoptas.roomexample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    @Insert
    fun insertAll(vararg note: Note)

    @Query("DELETE from note_table where noteId = :noteId")
    fun deleteById(vararg noteId :Int) :Int
}