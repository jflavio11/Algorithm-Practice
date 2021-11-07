package exercises.easy

/**
 * Image you have a magazine full of letters. You want to check if a given
 * word can be formed with those letters on the magazine.
 *
 * For example, we have this magazine:
 *  -------|--------
 * |       | A B C |
 * |       | D E F |
 * |_______|_O M N_|
 *
 * We can form the word "BED" because there are a B, an E and a D.
 * But we cannot form the word CAR because an R is missed.
 *
 */

/**
 * Use a HashMap to find in O(1) each character.
 */
private fun canWordBeFormed(letters: List<Char>, word: String): Boolean {
    val map = hashMapOf<Char, Int>()
    letters.forEach { map[it] = 1 }
    word.forEach { c -> if (!map.contains(c)) return false }
    return true
}

/**
 * But what if we want to exactly spell the word? For example, if the
 * magazine contains only one B, then the word: BBED cannot be formed.
 *
 * To solve this, we use the HashMap to sum the quantities of letters. When
 * we look for the word, we decrease the numbers of letters contained in the map.
 */
private fun canBeSpelled(letters: List<Char>, word: String): Boolean {
    val map = hashMapOf<Char, Int>()
    letters.forEach { map[it] = map[it]?.plus(1) ?: 1 }
    word.forEach { c ->
        if (map.containsKey(c) && map[c]!! > 0) {
            map[c] = map[c]!! - 1
        } else {
            return false
        }
    }
    return true
}

fun main() {
    val letters = listOf('A', 'B', 'C', 'D', 'D', 'E', 'F', 'O', 'M', 'N')
    val word1 = "BED"
    val word2 = "CAR"
    val word3 = "BEDDD"
    val word4 = "BEDD"
    println(canWordBeFormed(letters, word1)) // retrun true
    println(canWordBeFormed(letters, word2)) // return false
    println(canWordBeFormed(letters, word3)) // return true

    println(canBeSpelled(letters, word3)) // return false
    println(canBeSpelled(letters, word4)) // return true
}