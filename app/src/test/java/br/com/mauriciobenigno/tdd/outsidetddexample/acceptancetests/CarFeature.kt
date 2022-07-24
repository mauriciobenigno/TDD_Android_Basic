package br.com.mauriciobenigno.tdd.outsidetddexample.acceptancetests

import br.com.mauriciobenigno.tdd.Car
import br.com.mauriciobenigno.tdd.Engine
import br.com.mauriciobenigno.tdd.outsidetddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test


class CarFeature {

    private val engine = Engine()
    private val car = Car(engine,6.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasisTheTemperature() = runBlockingTest {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(6001)

        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }

}