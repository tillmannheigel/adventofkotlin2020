package adventofkotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day08 : Advent2020() {

    private lateinit var input: List<String>

    @BeforeEach
    fun setup() {
        input = readLines("input08")
    }

    @Test
    fun run01() {
        try {
            runProgram(input)
        } catch (l: Machine.LoopException) {
            println(l.acc)
        }
    }

    @Test
    fun run02() {
        for (i in input.indices) {
            val tmpList: ArrayList<String> = ArrayList()
            tmpList.addAll(input)
            when {
                tmpList[i].contains("nop") -> tmpList[i] = tmpList[i].replace("nop", "jmp")
                tmpList[i].contains("jmp") -> tmpList[i] = tmpList[i].replace("jmp", "nop")
                else -> continue
            }
            try {
                val result = runProgram(tmpList)
                print(result)
            } catch (l: Machine.LoopException) {
                continue
            }
        }
    }

    private fun runProgram(instructions: List<String>): Int {
        val machine = Machine(instructions)
        while (machine.isRunning()) {
            machine.step()
        }
        return machine.acc
    }

    private class Machine(private val instructions: List<String>) {
        var acc = 0
        var idx = 0
        val visited = BooleanArray(instructions.size) // for loop-detection

        fun step() {
            loopDetection()
            val instruction = instructions[idx].split(" ")
            val fkt = instruction[0]
            val param = instruction[1]
            if (fkt == "jmp") idx += Integer.parseInt(param)
            if (fkt == "nop") idx++
            if (fkt == "acc") {
                acc += Integer.parseInt(param)
                idx++
            }
        }

        fun isRunning(): Boolean {
            return idx < instructions.size
        }

        private fun loopDetection() {
            if (visited[idx]) throw LoopException(acc)
            visited[idx] = true
        }

        data class LoopException(val acc: Int) : Exception("Infinite Loop detected")
    }
}

