package adventofkotlin

import adventofkotlin.data.Rule
import adventofkotlin.data.Rules
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import java.util.regex.Pattern

class Day07 : Advent2020() {


    private fun readLines01(): ArrayList<String> {
        val lines = ArrayList<String>();

        val scan = Scanner(this::class.java.getResourceAsStream("input07"))
        scan.useDelimiter(Pattern.compile("\n"))
        while (scan.hasNext()) {
            val line: String = scan.next()
            lines.add(line)
        }
        return lines

    }

    private lateinit var allRules: List<Rules>

    @BeforeEach
    fun setup() {
        allRules = readLines01()
                .map { it.replace(".", "") }
                .map { it.split(" bags contain ") }
                .map {
                    val rules = it[1].split(", ")
                            .map { s ->
                                val indexOfFirstSpace = s.indexOfFirst { c -> c == ' ' }
                                val substring = s.substring(0, indexOfFirstSpace)
                                val number = if (substring == "no") 0 else Integer.parseInt(substring)
                                val color = s.substring(indexOfFirstSpace + 1).split(" bag")[0]
                                Rule(number, color)
                            }
                    Rules(it[0], rules)
                }
    }

    @Test
    fun run01() {
        print(countBags("shiny gold", allRules))
    }

    private fun countBags(currentBag: String, currentRules: List<Rules>): Int {
        return currentRules.count {
            it.rules.any { r -> currentBag == r.color || countBags(currentBag, allRules.filter { rules -> rules.color == r.color }) > 0 }
        }
    }

    @Test
    fun run02() {
        print(countBags02("shiny gold"))
    }

    private fun countBags02(currentBag: String): Int {
        return allRules.find { it.color == currentBag }?.rules
                ?.map { 1 + it.number * countBags02(it.color) }
                ?.sum() ?: 0
    }

}
