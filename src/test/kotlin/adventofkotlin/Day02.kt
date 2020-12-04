package adventofkotlin

import adventofkotlin.data.Password
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02 : Advent2020() {

    private lateinit var passwords: List<Password>

    @BeforeEach
    fun setup() {
        passwords = readLines("input02")!!
            .map { s -> s.split(" ") }
            .map { split ->
                val interval = split[0].split("-").map { s -> Integer.parseInt(s) }
                Password(interval[0], interval[1], split[1][0], split[2])
            }
    }

    @Test
    fun run01() {
        val count = passwords.filter { it.isValid1() }.count()

        assertEquals(count, 628)
    }

    private fun Password.isValid1(): Boolean {
        val count = password.filter { it == char }.count()
        return count in min..max
    }

    @Test
    fun run02() {
        val count = passwords.filter { it.isValid2() }.count()

        assertEquals(count, 705)
    }

    private fun Password.isValid2(): Boolean {
        val a = password[min - 1] == char
        val b = password[max - 1] == char
        return a.xor(b)
    }

}

