package com.example.adv160421097week6.model

data class Car(
    val model:String?,
    val year:String?,
    val features:List<String>?,
    val specs:CarSpecifications?
)

data class CarSpecifications(
    val engine: String?,
    val transmission: String?,
    val fuelType: String?,
    val motor: String?,
    val battery:String?
)