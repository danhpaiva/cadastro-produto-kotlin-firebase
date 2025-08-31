package com.example.cadastroprodutofirebase.model

data class Product(
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0
)