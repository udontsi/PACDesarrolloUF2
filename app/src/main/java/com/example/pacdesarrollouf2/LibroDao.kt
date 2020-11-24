package com.example.pacdesarrollouf2

import androidx.room.*

// Metodos de la clase

@Dao
interface LibroDao {

    @Insert
    suspend fun insertLibro(libro: Libro)

    @Query ("SELECT * FROM Libro")
    suspend fun verLibros(): List<Libro>

}