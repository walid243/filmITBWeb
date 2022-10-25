package com.example.templates

import io.ktor.server.html.*
import kotlinx.html.*

class AddFilm : Template<HTML> {
    override fun HTML.apply() {
        head {
            title { +"Add Film" }
        }
        body {
            header {
                h1 { +"Add Film" }
            }
            main {
                section {
                    form {
                        method = FormMethod.post
                        action = "/FilmITB/new"
                        label {
                            htmlFor = "title"
                            +"Title"
                        }
                        input {
                            type = InputType.text
                            name = "title"
                            id = "title"
                        }
                        label {
                            htmlFor = "year"
                            +"Year"
                        }
                        input {
                            type = InputType.text
                            name = "year"
                            id = "year"
                        }
                        label {
                            htmlFor = "genre"
                            +"Genre"
                        }
                        input {
                            type = InputType.text
                            name = "genre"
                            id = "genre"
                        }
                        label {
                            htmlFor = "director"
                            +"Director"
                        }
                        input {
                            type = InputType.text
                            name = "director"
                            id = "director"
                        }
                        label {
                            htmlFor = "image"
                            +"Image"
                        }
                        input {
                            type = InputType.file
                            name = "image"
                            id = "image"
                        }
                        button {
                            type = ButtonType.submit
                            +"Add Film"
                        }
                    }
                }
            }
        }
    }
}