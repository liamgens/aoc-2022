fun <T> ArrayDeque<T>.peek() = this.removeLastOrNull()
fun <T> ArrayDeque<T>.push(element: T) = addLast(element)
fun <T> ArrayDeque<T>.push(elements: List<T>) = elements.forEach { addLast(it) }
fun <T> ArrayDeque<T>.pop(count: Int): List<T> = (0 until count).map { this.removeLast() }
