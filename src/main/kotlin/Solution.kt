import java.io.File

abstract class Solution {

    private val fileName = "src/main/resources/input/${this.javaClass.simpleName.lowercase()}.txt"

    val fileContents: List<String> = File(fileName).useLines { it.toList() }

    fun run() {
        println("Part 1: ${pt1()}")
        println("Part 2: ${pt2()}")
    }

    abstract fun pt1(): String
    abstract fun pt2(): String

}