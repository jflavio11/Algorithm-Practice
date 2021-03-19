package sortAlgorithms

fun main() {
    // print(selectionSort(arrayListOf(4, 0, 3, 2, 9, 100, 50, 89, 56, 78, 120, 23)))
    print(selectionSort(arrayListOf(4 , 3 , 2 , 5 , 1)))
}

/**
 * Selection sort algorithm
 *
 * Loops the entire array and compares the current iteration value
 * with the other values of the list to find the minimum.
 *
 * Once minimum is found, it is swapped with the current iteration value.
 *
 * This is repeated until the end.
 *
 * After the first swap, a new "inside-array is created". This is, a part
 * of the original array that is sorted, and the one not looped yet, is unsorted.
 *
 * For example:
 * [ 3 , 2 , 1 , 5 , 4]
 *
 * - For the first iteration (i=0), 3 is compared with [i+1], that is, 2.
 * - 2 is minor than 3, so now our minimum value is 2 (located in i=1)
 * - Then, we are going to compare this new minimum value (2) with the next one [i+1] -> [2] = 1
 * - 1 is minor than 2, so now our minimum value is 1 (located in i=2)
 * - We continue until the end of the array. We notice than there's no other value minimum than 1.
 * - 1 is our minimum value and we are going to swap it with the current main iteration number [0] = (3)
 * - So now, the array is:
 *               sorted | unsorted
 *                  [ 1 , 2 , 3 , 5 , 4 ]
 *
 * - Now, the second iteration (i=1), 2 is compared with [i+1], that is, 3.
 * - And so on...
 *
 * From GeeksForGeeks - https://www.geeksforgeeks.org/selection-sort/
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element (considering ascending order) from unsorted part and putting it at the
 * beginning. The algorithm maintains two subarrays in a given array.
 *      1) The subarray which is already sorted.
 *      2) Remaining subarray which is unsorted.
 *
 * In every iteration of selection sort, the minimum element (considering ascending order)
 * from the unsorted subarray is picked and moved to the sorted subarray.
 *
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more
 * than O(n) swaps and can be useful when memory write is a
 * costly operation.
 *
 *
 * GIF: https://stackabuse.s3.amazonaws.com/media/selection-sort-in-javascript-1.gif
 *
 */
fun selectionSort(list: ArrayList<Int>): List<Int> {
    println(list)
    // we loop into the original array [ 4 , 3 , 2 , 5 , 1]
    for (i in 0 until list.size) {
        // our counter shift, index from where the unsorted array starts
        var pivot = i

        // we start looping from the current i iteration (the "unsorted part" of the array)
        // we first are going to compare array[i] with array[i+1]
        for (j in i + 1 until list.size) {

            // if this item of the unsorted array is greater than the item in the loop position
            // then our index for the minimum value is updated
            if (list[pivot] > list[j]) {
                pivot = j
            }

        }

        // we swap the current main iteration item with the one that is in the position of the pivot
        val aux = list[i]
        list[i] = list[pivot]
        list[pivot] = aux

        // now i+1, that is, from now, our array is divided in two parts
        // the part before this i iteration is the sorted, and the next loop is for the unsorted
        println(list)

    }

    return list

}