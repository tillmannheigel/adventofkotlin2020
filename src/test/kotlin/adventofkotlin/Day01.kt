package adventofkotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day01 : Advent2020() {

    private lateinit var integers: List<Int>

    @BeforeEach
    fun setup() {
        integers = readLines("input01")!!.map(Integer::parseInt)
    }

    @Test
    fun run02() {
        integers.any { a ->
            integers
                .any { b ->
                    integers
                        .any { c -> match(a, b, c) }
                }
        }
    }

    private fun match(a: Int, b: Int, c: Int): Boolean {
        val result = a + b + c == 2020
        if (result) {
            print(a * b * c)
        }
        return result
    }
}