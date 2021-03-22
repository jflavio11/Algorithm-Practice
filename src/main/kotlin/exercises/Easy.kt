package exercises

import kotlin.math.pow
import kotlin.math.roundToInt

// region Reverse a LinkedList
// class LinkedListNode
private class LlNode(val value: Int, var next: LlNode?)

private fun printLinkedList(root: LlNode?) {
    val ll = StringBuilder()
    var currentLlNode: LlNode? = root
    while (currentLlNode != null) {
        ll.append(currentLlNode.value).append(" -> ")
        currentLlNode = currentLlNode.next
    }
    ll.append("NULL")
    println(ll)
}

/**
 * [Animation of Reversing a LinkedList](https://media.geeksforgeeks.org/wp-content/cdn-uploads/RGIF2.gif)
 */
private fun reverseLinkedList(root: LlNode) {
    print("Original LinkedList: ")
    printLinkedList(root)
    var previousLlNode: LlNode? = null
    var head: LlNode? = root
    while (head != null) {
        val nextNode = head.next
        head.next = previousLlNode
        previousLlNode = head
        head = nextNode
    }
    print("Reversed LinkedList: ")
    printLinkedList(previousLlNode)
}
// endregion

// region Perfect Number
/**
 * Perfect number
 *
 * A perfect number is a positive integer that is equal to the sum
 * of all its positive divisors except itself.
 *
 * Given an integer n, write a function that returns true when
 * it is a perfect number and false when it is not.
 *
 * Example:
 * ```
 * Input: 28
 * Output: true
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * ```
 *
 * ```
 * Input: 6
 * Output: true
 * Explanation: 6 = 1 + 2 + 3
 * ```
 *
 **/
private fun isPerfectNumber(number: Int): Boolean {
    val factors = arrayListOf<Int>()

    if (number <= 0) return false

    // from 1 to number^0.5     or   from 1 to sqrt(number)
    for (i in 1..(number.toDouble().pow(0.5)).roundToInt()) {
        if (number % i == 0) { // if this i number is a divisor of [number]
            factors.add(i)
            factors.add(number / i)
        }
    }

    // at this time, if the number is 6, then the array should be
    // [1, 6, 2, 3]

    var sum = 0
    if (factors.isNotEmpty()) {
        // we sum all the values and rest the original number (1 + 6 + 2 + 3) - 6
        sum = factors.reduce { acc, i -> acc + i } - number
        return sum == number
    }

    return false
}
// endregion

fun main() {
    val numberToCheck = 6
    println("$numberToCheck is perfect number: ${isPerfectNumber(numberToCheck)}")

    val linkedList = LlNode(1, LlNode(2, LlNode(3, LlNode(4, null))))
    reverseLinkedList(linkedList)
}