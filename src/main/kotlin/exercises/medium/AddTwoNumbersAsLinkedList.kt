package exercises.medium

/**
 * Add two numbers (as LinkedList)
 *
 * You have two numbers and want to sum them. This numbers are represented
 * as LinkedLists:
 *
 *      [3]<-[4]<-[2]  +
 *      [4]<-[6]<-[5]
 * -------------------
 *      [8]<-[0]<-[7]
 *
 *           1
 *          [3]<-[4] +
 *          [9]<-[6]
 *          --------
 *     [1]<-[3]<-[0]
 *
 * Solution:
 * 1. pass first node of each number, assign them to head1, head2.
 * 2. while each head node is != to null, iterate
 * 3. sum adding the carry over if exists // 10
 * 4. calculate the digit result by mod 10 // 0
 * 5. calculate the new carry over by decreasing 10 // 1
 * 6. resultNode = generate a new node (result) using the digit result
 * 7. if currentNode == null then assign resultNode
 * 8  if not then currentNode.next = resultNode and currentNode = currentNode.next
 * 9. if one of the next values of each head is not null, assign a zero node value to the null one
 * 10. head1, head2 -> head1.next && head2.next
 * 11. iterate again
 * 12. return the currentNode variable
 *
 */

private data class SumLlNode(val value: Int, var next: SumLlNode? = null)

// iterative way
private fun sumTwoNumbers(n1: SumLlNode, n2: SumLlNode, carryOver: Int = 0): SumLlNode {
    var head1: SumLlNode? = n1
    var head2: SumLlNode? = n2
    var carryO = carryOver
    var firstNode: SumLlNode? = null
    var currentNode: SumLlNode? = null

    while (head1 != null || head2 != null) {

        val sum = head1!!.value + head2!!.value + carryO
        carryO = sum / 10
        val digitResult = sum % 10
        val resultNode = SumLlNode(digitResult)

        if (currentNode == null) {
            currentNode = resultNode
            firstNode = currentNode
        } else {
            currentNode.next = resultNode
            currentNode = currentNode.next
        }

        if (head1.next != null || head2.next != null) {
            if (head1.next == null) {
                head1.next = SumLlNode(0)
            }
            if (head2.next == null) {
                head2.next = SumLlNode(0)
            }
        }

        head1 = head1.next
        head2 = head2.next

    }

    return firstNode!!

}

// recursively way
private fun sumTwoNumbersRecursive(n1: SumLlNode, n2: SumLlNode, carryOver: Int = 0): SumLlNode {
    val sum = n1.value + n2.value + carryOver
    val carryO = sum / 10
    val sumDigit = sum % 10
    val resultNode = SumLlNode(sumDigit)

    if (n1.next != null || n2.next != null) {
        if (n1.next == null) n1.next = SumLlNode(0)
        if (n2.next == null) n2.next = SumLlNode(0)
        resultNode.next = sumTwoNumbersRecursive(n1.next!!, n2.next!!, carryO)
    } else if (resultNode.next == null) {
        resultNode.next = SumLlNode(carryO)
    }
    return resultNode
}

fun main() {
    val n1 = SumLlNode(4).apply { next = SumLlNode(3) }
    val n2 = SumLlNode(6).apply { next = SumLlNode(9) }
    // prints [0]->[3]->[1]

    // val n1 = SumLlNode(2).apply { next = SumLlNode(4).apply { next = SumLlNode(3) } }
    //val n2 = SumLlNode(5).apply { next = SumLlNode(6).apply { next = SumLlNode(4) } }
    //prints [7]->[0]->[8]

    var result: SumLlNode? = sumTwoNumbersRecursive(n1, n2)
    while (result != null) {
        print(result.value.toString().plus(" "))
        result = result.next
    }
}