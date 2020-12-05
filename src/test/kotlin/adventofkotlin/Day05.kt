package adventofkotlin

import org.junit.jupiter.api.Test
import kotlin.math.ceil

class Day05 : Advent2020() {

    @Test
    fun test01() {
        val boardingPass = readLines("testinput05")!![0]
        val result: Int = seatId(boardingPass)
        print(result)
    }

    @Test
    fun run01() {
        val result = readLines("input05")!!
            .maxOf { seatId(it) }

        print(result)
    }

    @Test
    fun run02() {

        val seatIds = readLines("input05")!!
            .map { seatId(it) }
            .sorted()

        val complete = seatIds.first()..seatIds.last()

        val missing = complete.filter { i -> !seatIds.contains(i) }

        println(missing)

    }

    private fun seatId(it: String): Int {
        val row = toInteger(it.subSequence(0, 7), 0..127)
        val column = toInteger(it.subSequence(7, 10), 0..7)
        return row * 8 + column
    }

    private fun toInteger(sequence: CharSequence, range: IntRange): Int {
        if (range.first == range.last) return range.first
        val half = (range.first + range.last).toDouble() / 2
        val nextRange =
            if (sequence[0] == 'B' || sequence[0] == 'R') roundedUp(half)..range.last else range.first..half.toInt()
        return toInteger(sequence.substring(1), nextRange)
    }

    private fun roundedUp(half: Double) = ceil(half).toInt()
}