package br.com.mauriciobenigno.tdd.outsidetddexample.unittests

import br.com.mauriciobenigno.tdd.Car
import br.com.mauriciobenigno.tdd.Engine
import br.com.mauriciobenigno.tdd.outsidetddexample.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import org.junit.Test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule


class CarShould {

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() = runBlockingTest {

        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    public fun turnOnItsEngine() = runBlockingTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }

}