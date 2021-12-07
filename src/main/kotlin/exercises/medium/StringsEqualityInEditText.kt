package exercises.medium

import java.util.*

/**
 * Given two strings that have been manipulated in a text editor,
 * find if they are equals. Each # character means a backspace.
 *
 * That is:
 * #d##c -> c ; because there were 3 backspaces and the left char is 'c'
 * a#efhk##p -> efp
 *
 * This can be solved using a Stack. Fill each character and pop it
 * when a # is found.
 */

private fun areEquals(typed1: String, typed2: String): Boolean {
    return finalString(typed1).contentEquals(finalString(typed2))
}

private fun finalString(typed: String): String {
    val stack: Stack<Char> = Stack<Char>()
    typed.forEach { c ->
        if (c == '#' && stack.size > 0) {
            stack.pop()
        } else {
            stack.push(c)
        }
    }
    return stack.toString()
}

private fun main() {
    val typed1 = "#d##c" // c
    val typed2 = "cab##" // c
    println("$typed1 and $typed2 are equal?  ${areEquals(typed1, typed2)}")

    val typed3 = "a#efhk##p" // efp
    val typed4 = "eef##fpop##" // efp
    println("$typed3 and $typed4 are equal?  ${areEquals(typed3, typed4)}")

    val typed5 = "pok#op#op#" // pooo
    val typed6 = "pok##op##op" // pop
    println("$typed5 and $typed6 are equal?  ${areEquals(typed5, typed6)}")
}
