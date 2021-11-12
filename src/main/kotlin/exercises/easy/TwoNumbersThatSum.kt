package exercises.easy

/**
 * You have a sorted array of numbers and a target.
 * Find the two numbers of the array that might sum equals to the target.
 * For example:
 * [2, 7, 11, 15] ; target = 18
 * Result: [1, 2] -> positions of 7 and 11, that sums 18
 *
 * Solution
 * First approach:
 * 1. iterate each number
 * 2. compare the sum of the current number of the iteration with each number of the list
 *      with the target
 * 3. if the result is equals to the target return i and j
 * Time complexity: O(n^2)
 *
 * Second approach (the best solution):
 * 1. iterate each number
 * 2. look for this current number in a hashtable
 * 3. we rest the target minus the current number
 * 4. if we do not find the result number, then we add the current number with the position as value
 * 5. if we found the result number, then return the value (position) of that found number the current position
 */

fun findTwoNumbersThatSumAsTarget(list: Array<Int>, target: Int): Pair<Int, Int> {
    val sortedList = list.sortedArray()
    val map = hashMapOf<Int, Int>()
    sortedList.forEachIndexed { index, value ->
        val restResult = target - value
        val containedResult = map[restResult]
        if (containedResult != null) {
            return Pair(index, containedResult)
        } else {
            map[value] = index
        }
    }
    return Pair(0, 0)
}

fun main() {
    val list = arrayOf(18, 7, 11, 15, 16, 2, 2)
    val target = 20
    val result = findTwoNumbersThatSumAsTarget(list, target)

    // just to test the printing
    val sortedList = list.sortedArray()
    println("For target $target, numbers that sum it are: ${sortedList[result.first]}, ${sortedList[result.second]}")
}
