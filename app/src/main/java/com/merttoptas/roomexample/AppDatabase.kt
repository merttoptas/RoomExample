package com.merttoptas.roomexample

import androidx.room.Database
import androidx.room.RoomDatabase
import com.merttoptas.roomexample.*

@Database(entities = [Note::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun notedao(): NoteDao

}