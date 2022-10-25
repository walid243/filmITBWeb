package com.example.templates

import com.example.models.Film
import io.ktor.server.html.*
import kotlinx.html.*

class FilmTemplate(private val film: Film): Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +film.title }
        }
        body {
            header {
                img {
                    src = "static/${film.image}"
                    alt = film.image
                }
            }
            main {
                section {
                    h1 { +film.title }
                    p { +"Año: ${film.year}" }
                    p { +"Genero: ${film.genre}" }
                    p { +"Director: ${film.director}" }
                }
            }
        }
    }
}