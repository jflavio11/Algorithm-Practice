package exercises

import kotlin.math.pow
import kotlin.math.roundToInt

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
fun isPerfectNumber(number: Int): Boolean {
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

fun main() {
    val numberToCheck = 6
    println("$numberToCheck is perfect number: ${isPerfectNumber(numberToCheck)}")
}