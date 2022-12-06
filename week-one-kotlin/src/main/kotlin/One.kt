class One : Solution() {

    private fun List<String>.getIndicies(): List<Int> =
        this.mapIndexed { index, elem -> if (elem == "") index else -1 }.filterNot { it == -1 }

    private fun calorieTotals(fileContents: List<String>): List<Int> {
        var start = 0
        return fileContents.getIndicies().map {
            val tmp = fileContents.subList(start, it).map { it.toInt() }
            start = it + 1
            tmp
        }.map { it.sum() }
    }

    override fun pt1(): String = calorieTotals(fileContents).max().toString()
    override fun pt2(): String = calorieTotals(fileContents).sortedDescending().subList(0, 3).sum().toString()
}