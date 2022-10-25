package com.example.models

class FilmITB {
    private val storage = mutableListOf<Film>()
    fun addFilm(film: Film) {
        storage.add(film)
    }
    fun getFilms(): List<Film> {
        return storage
    }
    fun getFilm(id: Int): Film? {
        return storage.find { it.id == id }
    }
}