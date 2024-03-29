package dataStructures

import java.util.*

private class Node(
    val value: String,
    val children: Array<Node> = emptyArray()
) {

    /**
     * Depth First Search - O(n) -
     * [Wikipedia](https://es.wikipedia.org/wiki/Búsqueda_en_profundidad)
     *
     * A deep search for each node. When it does not have more children, it looks
     * backwards (backtracking) and repeat the process.
     *
     * Pre Order
     * This function will print the node and the goes to the children.
     */
    fun dfs() {
        print(" ${this.value}")
        children.forEach {
            it.dfs()
        }
    }

    /**
     * PostOrder
     * Go to the deepest node and then moves backward (and prints).
     */
    fun postOrder() {
        children.forEach {
            it.postOrder()
        }
        print(" ${this.value}")
    }

    /**
     * PreOrder - Depth First Search
     * Using a stack, we move inside the tree.
     * For each node, we add its children to the stack.
     *
     * The stack is reversed in order to allow accessing
     * the first item that was added.
     *
     *      A
     *    /   \
     *   B     C
     *  / \   / \
     * D   E F  G
     *
     * Evolution of Stack per iteration (left to right):
     * [A] -> addition of first node
     * A
     * [C, B] -> adds children in reversed order...
     * A B
     * [C, E, D] -> adds B children in reversed order
     * A B D
     * A B D E
     * [C]
     * A B D E C
     * [G, F]
     * A B D E C F
     * [G]
     * A B D E C F G
     * []
     */
    fun dfsIterative() {
        val stack = Stack<Node>().apply { add(this@Node) }
        while (stack.size > 0) {
            val node = stack.pop()
            print(" ${node.value}")
            node.children.reversed().forEach {
                stack.add(it)
            }
        }
    }

    /**
     * Breadth First Search [Wikipedia](https://es.wikipedia.org/wiki/Búsqueda_en_anchura)
     * It explores a Node and all its neighborhoods in the same layer/floor.
     * Then, goes to the next layer/floor.
     *      A
     *    /   \
     *   B     C
     *  / \   / \
     * D   E F  G
     *
     * Evolution of Queue per iteration:
     * [A] -> addition of first node
     * [B, C]
     * [C, D, E]
     * [D, E, F, G]
     *
     */
    fun bfsIterative() {
        val queue: Queue<Node> = LinkedList<Node>().apply { add(this@Node) }
        while (queue.size > 0) {
            val node = queue.poll()
            print(" ${node.value}")
            node.children.forEach {
                queue.add(it)
            }
        }
    }

}


fun main() {
    /**
     *      A
     *    /   \
     *   B     C
     *  / \   / \
     * D   E F  G
     */
    val node = Node(
        "A",
        arrayOf(
            Node("B", arrayOf(Node("D"), Node("E"))),
            Node("C", arrayOf(Node("F"), Node("G")))
        )
    )
    println("DFS")
    node.dfs()
    println("\nPostOrder")
    node.postOrder()
    println("\nDSF Iterative")
    node.dfsIterative()
    println("\nBFS Iterative")
    node.bfsIterative()
}