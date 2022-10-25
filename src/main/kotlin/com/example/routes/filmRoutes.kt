package com.example.routes

import com.example.models.Film
import com.example.models.FilmITB
import com.example.templates.FilmTemplate
import com.example.templates.LayoutTemplate
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.routing.header
import kotlinx.html.*
import java.io.File

fun Route.filmRoutes() {
    val filmITB = FilmITB()
    route("/FilmITB") {
        get("/all") {
            call.respondHtml(HttpStatusCode.OK) {
                LayoutTemplate(filmITB.getFilms()).apply {
                    insert(this, TemplatePlaceholder())
                }
            }
        }
        get("/film/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id != null) {
                val film = filmITB.getFilm(id)
                if (film != null) {
                    call.respondHtml(HttpStatusCode.OK) {
                        FilmTemplate(film).apply {
                            insert(this, TemplatePlaceholder())
                        }
                    }
                } else {
                    call.respond(HttpStatusCode.NotFound)
                }
            } else {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        get("/new") {
            call.respondHtml(HttpStatusCode.OK) {
                LayoutTemplate(filmITB.getFilms()).apply {
                    insert(this, TemplatePlaceholder())
                }
            }
        }
        post("/new") {
            val partData = call.receiveMultipart()
            var id: String = ""
            var title: String = ""
            var year: String = ""
            var genre: String = ""
            var director: String = ""
            var photo: String = ""
            partData.forEachPart { part ->
                when (part) {
                    is PartData.FormItem -> {
                        when (part.name){
                            "id" -> id = part.value
                            "title" -> title = part.value
                            "year" -> year = part.value
                            "genre" -> genre = part.value
                            else -> director = part.value
                        }
                    }
                    is PartData.FileItem -> {
                        photo = part.originalFileName as String
                        val fileBytes = part.streamProvider().readBytes()
                        File("data/$photo").writeBytes(fileBytes)
                    }
                    else -> {}
                }
            }
            val film = Film(id.toInt(),title,year,genre, director, photo)
            filmITB.addFilm(film)
            call.respondText("Film storage correctly", status = HttpStatusCode.Created)
        }
    }
}
