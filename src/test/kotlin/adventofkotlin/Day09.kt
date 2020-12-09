package adventofkotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class Day09 : Advent2020() {

    private lateinit var input: List<Long>
    private val PREFIX_SIZE = 25

    @BeforeEach
    fun setup() {
        input = readLines("input09").map { it.toLong() }
    }

    @Test
    fun run01() {
        val timeInMillis = measureTimeMillis {
            for (i in PREFIX_SIZE until input.size) {
                if (!allMultCombinations(input.subList(i - PREFIX_SIZE, i)).contains(input[i])) {
                    println(input[i])
                }
            }
        }
        println("(run01 took $timeInMillis ms)")
    }

    @Test
    fun run02() {
        val timeInMillis = measureTimeMillis {
            for (i in PREFIX_SIZE until input.size) {
                if (!allMultCombinations(input.subList(i - PREFIX_SIZE, i)).contains(input[i])) {
                    println(findContiguousSet(input[i], input))
                }
            }
        }
        println("(run02 took $timeInMillis ms)")
    }

    private fun allMultCombinations(subList: List<Long>): List<Long> {
        val result = ArrayList<Long>()
        subList.indices.forEach { i ->
            subList.indices.minus(0..i).forEach { j -> result.add(subList[i] + subList[j]) }
        }
        return result
    }

    private fun findContiguousSet(expectedResult: Long, input: List<Long>): Long? {
        input.indices.forEach { i ->
            (i + 1..input.size).forEach { j ->
                val sub = input.subList(i, j)
                val sum = sub.sum()
                if (sum > expectedResult) return@forEach
                if (sum == expectedResult) return sub.minOrNull()?.plus(sub.maxOrNull()!!)
            }
        }
        return null
    }

}

