class Two : Solution() {

    private enum class Shape(val points: Int) {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);

        companion object {
            fun getShapeMapping(letter: String): Shape =
                when (letter) {
                    "A", "X" -> ROCK
                    "B", "Y" -> PAPER
                    "C", "Z" -> SCISSORS
                    else -> throw Exception("Invalid Mapping - $letter")
                }

            fun getResultMapping(letter: String): Int =
                when (letter) {
                    "X" -> 0
                    "Y" -> 3
                    "Z" -> 6
                    else -> throw Exception("Invalid Mapping - $letter")
                }
        }
    }

    private val grid = listOf(
        listOf(3, 6, 0),
        listOf(0, 3, 6),
        listOf(6, 0, 3)
    )

    private fun matchPoints(shape1: Shape, shape2: Shape): Int = grid[shape1.points - 1][shape2.points - 1]
    private fun getResultingShape(shape1: Shape, desiredOutcome: Int): Shape =
        Shape.values()[grid[shape1.points - 1].indexOf(desiredOutcome)]

    override fun pt1(): String =
        fileContents.sumOf {
            val shapes = it.split(" ")
            val shape1 = Shape.getShapeMapping(shapes.first())
            val shape2 = Shape.getShapeMapping(shapes.last())
            matchPoints(shape1, shape2) + shape2.points
        }.toString()

    override fun pt2(): String =
        fileContents.sumOf {
            val shapes = it.split(" ")
            val shape1 = Shape.getShapeMapping(shapes.first())
            val desiredOutcome = Shape.getResultMapping(shapes.last())
            val shape2 = getResultingShape(shape1, desiredOutcome)

            matchPoints(shape1, shape2) + shape2.points
        }.toString()
}