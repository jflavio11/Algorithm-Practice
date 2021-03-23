package exercises.easy

/**
 * Sales by match
 *
 * There is a large pile of socks that must be paired by color. Given
 * an array of integers representing the color of each sock, determine
 * how many pairs of socks with matching colors there are.
 *
 * Example:
 * ```
 * n = 7
 * ar = [ 1 , 2 , 1 , 2 , 1 , 3 , 2]
 * ```
 * - There is one pair of color 1 and one of color 2.
 * - There are three odd socks left, one of each color.
 * - The number of pairs is 2.
 **/
private fun sockMerchant(n: Int, ar: Array<Int>): Int {

    var numberOfPairs = 0
    val pairMap = hashMapOf<Int, Int>()

    for (i in 0..ar.size.minus(1)) {
        if (pairMap.get(ar[i]) == null) {
            pairMap[ar[i]] = 1
        } else {
            pairMap[ar[i]] = pairMap[ar[i]]?.plus(1)!!
        }
        // println("${ar[i]} : ${pairMap[ar[i]]} ")
    }

    pairMap.forEach { (_, value) ->
        if (value != 0) {
            // imagine that for color 1, there are 5 socks (value = 5)
            // ( value - value % 2 ) / 2
            //  (5 - 1) / 2  -> we divide by 2 to get the number of pairs
            numberOfPairs += ((value - value.rem(2)) / 2)
        }
    }

    return numberOfPairs
}

/**
 * Another solution by unknown user:
 * ```
 *     Set<Integer> colors = new HashSet<>();
 *     int pairs = 0;
 *
 *     for (int i = 0; i < n; i++) {
 *         if (!colors.contains(c[i])) {
 *             colors.add(c[i]);
 *         } else {
 *             pairs++;
 *             colors.remove(c[i]);
 *         }
 *     }
 * ```
 */

private fun main() {
    val array = arrayOf(1, 2, 1, 2, 1, 3, 2)
    println("Number of socks ${sockMerchant(array.size, array)}")
}