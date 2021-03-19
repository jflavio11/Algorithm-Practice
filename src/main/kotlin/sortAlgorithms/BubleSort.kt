package sortAlgorithms

fun main() {
    // print(selectionSort(arrayListOf(4, 0, 3, 2, 9, 100, 50, 89, 56, 78, 120, 23)))
    println(bubbleSort(arrayListOf(4, 3, 2, 5, 1)))
}

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 *
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 *
 * https://www.geeksforgeeks.org/bubble-sort/
 */
fun bubbleSort(list: ArrayList<Int>): List<Int> {
    println(list)
    // we iterate over all the array
    for (i in 0 until list.size) {

        println("i = $i")
        // we, again, iterate over all the array but for comparing current value with next value
        // - i - 1 -> considering that in each loop, the last elements are already sorted
        for (j in 0 until list.size - i - 1) {

            // if current is greater than the next one, we swap
            // repeat this until the end of all array iteration
            if (list[j] > list[j + 1]) {
                val aux = list[j]
                list[j] = list[j + 1]
                list[j + 1] = aux
            }
            println(list)

        }

        // we need to loop again to ensure that we do not need more swaps O(n2)
        // loops are independent one of each other
        println("=====")
    }

    return list
}