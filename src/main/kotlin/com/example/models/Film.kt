package com.example.models

import kotlinx.serialization.Serializable

@Serializable
class Film(val id:Int, val title:String, val year: String, val genre: String, val director:String, val image:String) {
}