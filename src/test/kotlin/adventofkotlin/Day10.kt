package adventofkotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class Day10 : Advent2020() {

    private lateinit var input: List<String>
    private lateinit var testinput: List<String>

    @BeforeEach
    fun setup() {
        input = readLines("input10")
        testinput = readLines("testinput10")
    }

    @Test
    fun run01() {
        val timeInMillis = measureTimeMillis {
            println(testinput)
        }
        println("(run01 took $timeInMillis ms)")
    }

    @Test
    fun run02() {
        val timeInMillis = measureTimeMillis {
            println(testinput)
        }
        println("(run02 took $timeInMillis ms)")
    }

}

