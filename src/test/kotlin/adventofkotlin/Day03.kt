package adventofkotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day03 : Advent2020() {

    private lateinit var input: List<CharArray>

    @BeforeEach
    fun setup() {
        input = readLines("input03")!!
            .map { it.toCharArray() }
    }

    @Test
    fun run01() {
        print(
            calcTreesRek(0, 0, 1, 1).toBigInteger()
                    * calcTreesRek(0, 0, 1, 3).toBigInteger()
                    * calcTreesRek(0, 0, 1, 5).toBigInteger()
                    * calcTreesRek(0, 0, 1, 7).toBigInteger()
                    * calcTreesRek(0, 0, 2, 1).toBigInteger()
        )
    }

    private fun calcTreesRek(x: Int, y: Int, a: Int, b: Int): Int {
        if (x >= input.size) return 0
        var i = 0
        if (input[x][y % input[x].size] == '#') i = 1
        return i + calcTreesRek(x + a, y + b, a, b)
    }
}

