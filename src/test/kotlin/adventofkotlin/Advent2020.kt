package adventofkotlin

import org.apache.commons.io.IOUtils
import java.nio.charset.Charset

open class Advent2020 {

    fun readLines(resource: String): List<String> {
        return IOUtils.readLines(this::class.java.getResourceAsStream(resource), Charset.defaultCharset())
    }

}