import java.io.File

abstract class Solution {

    private val fileName = "src/main/resources/input/${this.javaClass.simpleName.lowercase()}.txt"

    val fileContents: List<String> = File(fileName).useLines { it.toList() }

    fun run() {
        println("Day ${this.javaClass.simpleName}")
        println("Part 1: ${pt1()}")
        println("Part 2: ${pt2()}\n")
    }

    abstract fun pt1(): Any
    abstract fun pt2(): Any
}