package com.example.templates

import com.example.models.Film
import io.ktor.server.html.*
import kotlinx.html.*

class AllFilmsTemplate(storage:List<Film>) : Template<FlowContent> {
    private val films = storage
    override fun FlowContent.apply() {
        table {
            films.forEach{
                tr {
                    td {
                        img {
                            src = it.image
                            alt = it.image
                        }
                    }
                    td {
                        h2 { +it.title }
                    }
                    td {
                        button {
                            id = "filmDetails"
                            onClick = "location.href='/FilmITB/film/${it.id}'"
                        }
                    }
                }
            }

        }
    }
}
