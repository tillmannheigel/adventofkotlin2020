package adventofkotlin

import org.junit.jupiter.api.Test
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.HashMap

class Day06 : Advent2020() {


    @Test
    fun run01() {
        var lines = readLines01()
        val anserweredByAnyone = lines
            .map { it.toSet().count() }


        print(anserweredByAnyone.count())
    }

    private fun readLines01(): ArrayList<String> {
        val lines = ArrayList<String>();

        val scan = Scanner(this::class.java.getResourceAsStream("testinput06"))
        scan.useDelimiter(Pattern.compile("\n\n"))
        while (scan.hasNext()) {
            val line: String = scan.next().replace("\n", "")
            lines.add(line)
        }
        return lines

    }


    @Test
    fun run02() {

        val answeredByEveryone = readLines()
            .map { group ->
                val hashMap = HashMap<Char, Int>()
                group.forEach { person ->
                    person.forEach { answer ->
                        if (!hashMap.contains(answer))
                            hashMap[answer] = group.count { it.contains(answer) }
                    }
                }
                hashMap.entries.count { it.value == group.size }
            }

        print(answeredByEveryone.sum())

    }

    private fun readLines(): ArrayList<List<String>> {
        var lines = ArrayList<List<String>>();

        val scan = Scanner(this::class.java.getResourceAsStream("testinput06"))
        scan.useDelimiter(Pattern.compile("\n\n"))
        while (scan.hasNext()) {
            val line: List<String> = scan.next().split("\n")
            lines.add(line)
        }
        print(lines)

        return lines
    }
}
