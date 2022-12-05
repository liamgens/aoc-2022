class Five : Solution() {
    private val stackInput: List<String> = fileContents.filterNot { it.contains("move") }
    private val rows: List<List<String>>
    private val colSize = 4
    private val stacks: Map<Int, ArrayDeque<Char>>
    private val instructions: List<Instruction> =
        fileContents.filter { it.contains("move") }.map { Instruction.create(it) }

    init {
        rows = stackInput.map { it.chunked(colSize) }.dropLast(2)
        stacks = (1..rows.maxOf { it.size }).associateWith {
            ArrayDeque(emptyList())
        }
        setInitialStackLayout()
    }

    private fun setInitialStackLayout() {
        rows.reversed().forEach { col ->
            col.forEachIndexed { stack, elem ->
                if (elem.isNotBlank()) {
                    stacks[stack + 1]?.push(elem.elementAt(1))
                }
            }
        }
    }

    private fun Instruction.execute(reversed: Boolean = false) {
        stacks[this.from]?.pop(this.amount)?.let {
            when (reversed) {
                true -> stacks[this.to]?.push(it.reversed())
                else -> stacks[this.to]?.push(it)
            }
        }
    }

    private fun executeInstructions(reversed: Boolean = false) = instructions.forEach { it.execute(reversed) }

    data class Instruction(val amount: Int = 0, val from: Int = 0, val to: Int = 0) {
        companion object {
            fun create(instruction: String): Instruction =
                ".*\\s([0-9]+)\\s.*([0-9]+)\\s.*([0-9]+)".toRegex().find(instruction).let {
                    it?.let { mr ->
                        mr.groupValues.subList(1, 4).map { v -> v.toInt() }.let { vals ->
                            Instruction(
                                vals.elementAt(0),
                                vals.elementAt(1),
                                vals.elementAt(2)
                            )
                        }
                    } ?: Instruction()
                }
        }
    }

    private fun runSolution(reversed: Boolean = false): Any =
        setInitialStackLayout().also { executeInstructions(reversed) }.let {
            stacks.map { entry -> entry.value.peek() }.filterNotNull().joinToString("")
        }

    override fun pt1(): Any = runSolution()
    override fun pt2(): Any = runSolution(true)
}