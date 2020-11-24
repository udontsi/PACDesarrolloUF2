package com.example.pacdesarrollouf2

import androidx.room.Database
import androidx.room.RoomDatabase

// Definimos BBDD

@Database(
    entities = [Libro::class],
    version = 1
)

abstract class LibroDB : RoomDatabase() {

    abstract fun libroDao(): LibroDao

}