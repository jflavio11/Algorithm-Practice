package dataStructures

/**
 * Bits manipulation
 *
 * 1 and 1 = 1 (equals to 1) &
 * 0 and 1 = 0 (different) &
 *
 * 0 or 1 = 1 (there's a 1) |
 * 1 or 0 = 1 (there's a 1) |
 *
 * 1010 >> 1 = 0101  (one bit to the right)
 *
 * 1010 << 1 = 0100 (one bit to the left)
 *
 * 1 xor 1 = 0 (there are equals so results 0) ^
 * 0 xor 1 = 1 (there are not equals so results 1) ^
 *
 */
fun numberToBits(number: Int): String {
    var result = ""
    var num = number
    while (num > 0) {
        result = (num and 1).toString() + result
        num = num shr 1 // num >> 1
    }
    return result
}

fun bitsToNumber(bits: String): Int {
    var num = 0
    bits.forEach {
        num = num shl 1 // num << 1
        if (it == '1') {
            num++
        }
    }
    return num
}

/**
 * Given an array [4, 1, 4, 2, 2] where all numbers appear twice except for one number.
 * Find that number.
 *
 * Note: using XOR, a number xor with itself results in zero.
 * The result of the XOR op is only 1 when both numbers are different.
 */
fun findSingleNumber(numbers: Array<Int>): Int {
    var result = 0
    numbers.forEach {
        result = result xor it
    }
    return result
}

fun main() {
    println(bitsToNumber("101"))
    println(numberToBits(5))
    println(findSingleNumber(arrayOf(4, 7, 4, 2, 2)))
}