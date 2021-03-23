package exercises.easy

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

private fun main() {
    val linkedList = LlNode(1, LlNode(2, LlNode(3, LlNode(4, null))))
    reverseLinkedList(linkedList)
}