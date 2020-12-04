package adventofkotlin

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01 : Advent2020() {

    @Test
    fun test01() {
        val integers = readLines("testinput01")!!.map(Integer::parseInt)

        val result = findTuple(integers)

        assertEquals(result, 514579)
    }

    @Test
    fun test02() {
        val integers = readLines("testinput01")!!.map(Integer::parseInt)

        val result = findTriple(integers)

        assertEquals(result, 241861950)
    }

    @Test
    fun run01() {
        val integers = readLines("input01")!!.map(Integer::parseInt)

        val result = findTuple(integers)

        assertEquals(result, 658899)
    }

    @Test
    fun run02() {
        val integers = readLines("input01")!!.map(Integer::parseInt)

        val result = findTriple(integers)

        assertEquals(result, 155806250)
    }

    private fun findTuple(integers: List<Int>): Int {
        var result = 0
        integers.any { a ->
            integers.any { b ->
                    val check = a + b  == 2020
                    if (check) result = a * b
                    check
            }
        }
        return result
    }

    private fun findTriple(integers: List<Int>): Int {
        var result = 0
        integers.any { a ->
            integers.any { b ->
                integers.any { c ->
                    val check = a + b + c == 2020
                    if (check) result = a * b * c
                    check
                }
            }
        }
        return result
    }

}