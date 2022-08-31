package com.example.firstapp.Classes

class Car():Port() {

    var Type: String?=null
    var Model: String?=null
    private var Price: Int ?=null

    constructor(Type: String, Model: String, Price: Int) : this() {
        println("Le type de ma voitur $Type ");
        println("Model de  $Model ");
        println("Je l'ai achete en  $Price ");
    }

    fun GetPrice(): Int? {
        return this.Price
    }

    fun SetPrice(Price: Int){
        this.Price = Price
    }

}