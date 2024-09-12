package com.example.mycityai.ui.theme

data class Item(
    val title: String,
    val image: Int,
    val recommendations: List<Recommendation>
)

data class Recommendation(
    val name: String,
    val image: Int,
    val details: String
)
