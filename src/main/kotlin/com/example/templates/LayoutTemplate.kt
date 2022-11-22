package com.example.templates

import com.example.models.Film
import io.ktor.server.html.*
import kotlinx.html.*

class LayoutTemplate(storage: List<Film>) : Template<HTML> {
    lateinit var content: String
    private val films = storage
    override fun HTML.apply() {
        head {
            title("Lista de peliculas")
        }
        body {
            header {
                img {
                    src = "/static/fons-alum.png"
                    alt = "logo.png"
                }
            }
            main {
                section {
                    id = "info"
                    button {
                        id = "lista_de_pelis"
                        onClick = "location.href='/FilmITB/all'"
                        text("Lista de peliculas")

                    }
                    button {
                        id = "nueva_peli"
                        onClick = "location.href='/FilmITB/new'"
                        text("Nueva pelicula")
                    }
                    button {
                        id = "about_us"
                        onClick = "location.href='/FilmITB/about_us'"
                        text("About us")
                    }
                }
                section {
                    h1 { +"Lista de peliculas" }
                    insert(AllFilmsTemplate(films), TemplatePlaceholder())
                }
            }
        }
    }
}
