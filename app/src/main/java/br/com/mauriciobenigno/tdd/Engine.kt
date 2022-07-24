package br.com.mauriciobenigno.tdd

import android.util.Log
import kotlinx.coroutines.delay

class Engine (
    val cc: Int = 2000,
    val horsePower: Int = 150,
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
    ){

    suspend fun turnOn(){
        isTurnedOn = true

        delay(6000)

        temperature = 95

        Log.d("COURSE", "Engine has turned on")
    }

    fun turnOff(){
        isTurnedOn = false
        temperature = 15
    }
}