package exercises.easy

/**
 * Is a valid Binary Search Tree?
 * A Binary Search Tree is a tree which nodes have only two children,
 * and they are sorted. All nodes to the right are greater than nodes
 * of the left.
 */

private data class BSTNode(
    val value: Int,
    val left: BSTNode? = null,
    val right: BSTNode? = null
)

private fun isValidBST(node: BSTNode?, minValue: Int, maxValue: Int): Boolean {

    if (node == null) return true

    if (node.value > minValue &&
        node.value < maxValue &&
        isValidBST(node.left, minValue, node.value) && // check subtree to the left is valid
        isValidBST(node.right, node.value, maxValue)
    ) {// check subtree to the left is valid
        return true
    }

    return false
}

/**
 * Tree A
 *     5
 *   /   \
 *  3     6
 *
 *
 * Tree B
 *      8
 *    /   \
 *   4     6
 * /  \   /
 * -1  5 9
 *
 * Tree C
 *      8
 *    /   \
 *   5     10
 * /  \   /  \
 * 0  6  9    13
 *            /
 *           11
 */
fun main() {
    val treeA = BSTNode(
        value = 5,
        left = BSTNode(3),
        right = BSTNode(6)
    )

    val treeB = BSTNode(
        value = 8,
        left = BSTNode(4, BSTNode(-1), BSTNode(5)),
        right = BSTNode(6, BSTNode(9))
    )

    val treeC = BSTNode(
        value = 8,
        left = BSTNode(5, BSTNode(0), BSTNode(6)),
        right = BSTNode(10, BSTNode(9), BSTNode(13, BSTNode(11)))
    )

    println(isValidBST(treeA, Int.MIN_VALUE, Int.MAX_VALUE)) // return true
    println(isValidBST(treeB, Int.MIN_VALUE, Int.MAX_VALUE)) // return false
    println(isValidBST(treeC, Int.MIN_VALUE, Int.MAX_VALUE)) // return true
}