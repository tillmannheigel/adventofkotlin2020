package adventofkotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import java.util.regex.Pattern


class Day04 : Advent2020() {

    @BeforeEach
    fun setup() {
        val scan = Scanner(this::class.java.getResourceAsStream("input04"))
        var i = 0;
        var validLines = ArrayList<String>();
        scan.useDelimiter(Pattern.compile("\n\n"))
        while (scan.hasNext()) {
            val line: String = scan.next().replace("\n", " ")
            if (line.contains("byr")
                    && line.contains("iyr")
                    && line.contains("eyr")
                    && line.contains("hgt")
                    && line.contains("hcl")
                    && line.contains("ecl")
                    && line.contains("pid")
            )  {
                i+=1
                validLines.add(line)
            }
        }
        println(i)
        val result = validLines
                .map { s -> s.split(" ") }
                .map { fields -> fields
                        .map { field -> field.split(":") }
                        .filter {
                            var result = false
                            if (it[0].contains("iyr")) result = Integer.parseInt(it[1]) in 2010..2020
                            if (it[0].contains("byr")) result = Integer.parseInt(it[1]) in 1920..2002
                            if (it[0].contains("eyr")) result = Integer.parseInt(it[1]) in 2020..2030
                            if (it[0].contains("hgt")) result = validatehgt(it[1])
                            if (it[0].contains("hcl")) result = it[1].matches(Regex("^#[a-f 0-9]{7}$"))
                            if (it[0].contains("ecl")) result = it[1].matches(Regex("^amb$|^blu$|^brn$|^gry$|^grn$|^hzl$|^oth$"))
                            if (it[0].contains("pid")) result = it[1].matches(Regex("^[0-9]{9}$"))
                            if (it[0].contains("cid")) result = true
                            result}
                }
                .filter { it.size in 6..7  }

        print(result.size)
    }

    private fun validatehgt(entry: String) : Boolean {
        val cm = entry.contains("cm")
        if (cm) {
            val sizeInCm = Integer.parseInt(entry.subSequence(0, entry.length - 2).toString())
            return sizeInCm in 150..193
        }
        val inch = entry.contains("in")
        if (inch) {
            val sizeInInch = Integer.parseInt(entry.subSequence(0, entry.length - 2).toString())
            return sizeInInch in 59..76
        }
        return false
    }


    @Test
    fun run() {
    }

}

