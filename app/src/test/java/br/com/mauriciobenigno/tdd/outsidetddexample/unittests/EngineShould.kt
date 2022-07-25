package br.com.mauriciobenigno.tdd.outsidetddexample.unittests

import br.com.mauriciobenigno.tdd.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @Test
    fun turnOn() = runBlockingTest {
        engine.turnOn()
        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureGraduallyWhenItTurnsOn() = runBlockingTest {
        val flow: Flow<Int> = engine.turnOn()
        val actual: List<Int> = flow.toList()

        assertEquals(listOf(25,50,95), actual)
    }

}