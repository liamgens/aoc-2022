class Four : Solution() {

    private fun parseInput(): List<Pair<List<Int>, List<Int>>> = fileContents.map {
        it.split(',').let {
            val e1 = it.first().split('-').map { m -> m.toInt() }
            val e2 = it.last().split('-').map { m -> m.toInt() }
            e1 to e2
        }
    }

    override fun pt1(): Int = parseInput().map { pairs ->
        val e1 = pairs.first
        val e2 = pairs.second

        if (e1.first() <= e2.first() && e1.last() >= e2.last()) {
            true
        } else e2.first() <= e1.first() && e2.last() >= e1.last()
    }.filter { it }.size

    override fun pt2(): Int = parseInput().map { pairs ->
        val e1 = pairs.first
        val e2 = pairs.second

        (e1.first() <= e2.last() && e1.last() >= e2.first())
    }.filter { it }.size
}