class Six : Solution() {
    private fun detectSequence(digits: String, index: Int = 0, size: Int): Int =
        if (digits.substring(index, index + size).toSet().size == size) {
            index + size
        } else detectSequence(digits, index + 1, size)

    override fun pt1(): Any = detectSequence(fileContents.first(), size = 4)
    override fun pt2(): Any = detectSequence(fileContents.first(), size = 14)
}