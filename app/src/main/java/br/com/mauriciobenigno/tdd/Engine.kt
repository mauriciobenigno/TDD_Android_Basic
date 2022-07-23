package br.com.mauriciobenigno.tdd

class Engine (
    val cc: Int = 2000,
    val horsePower: Int = 150,
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
    ){

    fun turnOn(){
        isTurnedOn = true
        temperature = 95
    }

    fun turnOff(){
        isTurnedOn = false
        temperature = 15
    }
}