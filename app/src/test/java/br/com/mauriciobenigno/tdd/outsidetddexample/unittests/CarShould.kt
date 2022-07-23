package br.com.mauriciobenigno.tdd.outsidetddexample.unittests

import br.com.mauriciobenigno.tdd.Car
import br.com.mauriciobenigno.tdd.Engine
import junit.framework.TestCase.assertEquals
import org.junit.Test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify


class CarShould {

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)

    @Test
    fun looseFuelWhenItTurnsOn(){

        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine(){
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }

}