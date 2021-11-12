package exercises.easy

/**
 * You have a sorted array, let's say:
 * [1, 3, 3, 5, 6, 8, 9, 9, 9, 10, 15]
 *
 * You have to find the first and last index of a given number.
 * For example, for the list above, if the target number is 9, then
 * the indices are: 6 and 8
 *
 * We can solve it with an O(n) solution by iterating through all the array, or
 * we can go for a solution that uses a binary search (the array is sorted!).
 */

class Solution {
    fun indicesForNumberInList(list: Array<Int>, target: Int) {
        val first = indexBinarySearchIterative(list, 0, list.size - 1, target, true)
        val last = indexBinarySearchIterative(list, 0, list.size - 1, target, false)
        println("Indices are $first and $last")
    }

    private fun indexBinarySearch(array: Array<Int>, low: Int, high: Int, target: Int, findFirst: Boolean): Int {
        if (low > high) return -1
        val middle = low + (high - low) / 2
        if (findFirst) {
            if (middle == 0 || target == array[middle] && target > array[middle - 1]) {
                return middle
            }
            return if (target > array[middle]) {
                indexBinarySearch(array, middle + 1, array.size - 1, target, true)
            } else {
                indexBinarySearch(array, low, middle - 1, target, true)
            }
        } else {
            if (middle == array.size - 1 || target == array[middle] && target < array[middle + 1]) {
                return middle
            }
            return if (target < array[middle]) {
                indexBinarySearch(array, low, middle - 1, target, false)
            } else {
                indexBinarySearch(array, middle + 1, high, target, false)
            }
        }
    }

    private fun indexBinarySearchIterative(array: Array<Int>, low: Int, high: Int, target: Int, findFirst: Boolean): Int {
        var lowValue = low
        var highValue = high
        while (true) {
            if (lowValue > highValue) return -1
            val middle = lowValue + (highValue - lowValue) / 2
            if (findFirst) {
                if (middle == 0 || target == array[middle] && target > array[middle - 1]) {
                    return middle
                }
                if (target > array[middle]) {
                    lowValue = middle + 1
                } else {
                    highValue = middle - 1
                }
            } else {
                if (middle == array.size - 1 || target == array[middle] && target < array[middle + 1]) {
                    return middle
                }
                if (target < array[middle]) {
                    highValue = middle - 1
                } else {
                    lowValue = middle + 1
                }
            }
        }
    }
}

fun main() {
    val list = arrayOf(1, 3, 3, 5, 6, 8, 9, 9, 9, 10, 15)
    Solution().indicesForNumberInList(list, 9)
}