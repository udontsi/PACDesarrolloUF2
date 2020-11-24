package com.example.pacdesarrollouf2

import androidx.room.Entity
import androidx.room.PrimaryKey

// Definimos tabla Libro

@Entity
data class Libro (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val titulo: String,
    val autor: String,
    val edicion: Int
)