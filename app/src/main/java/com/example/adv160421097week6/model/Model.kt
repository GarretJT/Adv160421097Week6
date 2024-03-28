package com.example.adv160421097week6.model

data class Car(
    val id: Int,
    val name: String,
    val brand: String,
    val year: Int,
    val colors: List<String>,
    val features: Features, // Update this line to use Features class
    val images: String
)

data class Features(
    val engine: String,
    val transmission: String
)
