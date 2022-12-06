import kotlin.math.ceil

class Three : Solution() {

    private val priorities = (97..122).mapIndexed { idx, elem ->
        elem.toChar() to idx + 1
    }.plus((65..90).mapIndexed { idx, elem ->
        elem.toChar() to idx + 27
    }).toMap()

    override fun pt1(): String = fileContents.sumOf {
        val halves = it.chunked(ceil(it.length / 2.0).toInt())
        val halfOne = halves.first().toSet()
        val halfTwo = halves.last().toSet()
        priorities[halfOne.intersect(halfTwo).first()]!!
    }.toString()

    override fun pt2(): String = fileContents.map { it.toSet() }.chunked(3).sumOf {
        priorities[it.fold(it.first().toSet()) { acc, chars -> acc.intersect(chars) }.first()]!!
    }.toString()
}