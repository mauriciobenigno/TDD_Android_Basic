package br.com.mauriciobenigno.tdd.outsidetddexample.acceptancetests

import br.com.mauriciobenigno.tdd.Car
import br.com.mauriciobenigno.tdd.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test


class CarFeature {

    private val engine = Engine()
    private val car = Car(engine,6.0)

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasisTheTemperature(){
        car.turnOn()

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }

}