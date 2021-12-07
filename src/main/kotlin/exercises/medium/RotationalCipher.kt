package exercises.medium

/**
 *
 * One simple way to encrypt a string is to "rotate" every alphanumeric
 * character by a certain amount. Rotating a character means replacing
 * it with another character that is a certain number of steps away in
 * normal alphabetic or numerical order.
 *
 * For example, if the string "Zebra-493?" is rotated 3 places,
 * the resulting string is "Cheud-726?". Every alphabetic character
 * is replaced with the character 3 letters higher (wrapping around
 * from Z to A), and every numeric character replaced with the character
 * 3 digits higher (wrapping around from 9 to 0). Note that the
 * non-alphanumeric characters remain unchanged.
 *
 *
 * Let us first note that, for alphabetic characters, any rotationFactor
 * greater than 25 can be reduced to a factor in the range [0, 25] since
 * rotating 26 times is the same as rotating 0 times. Similarly, when
 * rotating a numeric character, any rotationFactor greater than 9 can
 * be reduced to the range [0, 9]. Subtracting 26 (or 10) repeatedly is
 * a slow way to reduce the factor, so we can instead use modular arithmetic.
 * In most languages, the % operator is the modulo operator.
 *
 * A % B returns the remainder after dividing A by B, which is the same as
 * subtracting B repeatedly until you have a value in the range [0, B).
 * Some languages have an explicit mod(A, B) function instead of a
 * first-class operator.
 *
 * Once we’ve reduced our factor to a small value, there are a few ways
 * to achieve O(1) rotations per character. Some of these take additional
 * (though constant) space such as making a series of hash tables that map
 * an input character to a ciphered character, one for each level of rotation
 * from 0 to 25. But instead, we can take advantage of the fact that the
 * characters a-z, A-Z, and 0-9 all exist in a contiguous range of ASCII values.
 *
 * Most languages let you convert characters to and from ASCII values,
 * and many let you perform arithmetic directly on characters. If you want
 * to rotate ‘E’ by 5, you can simply compute 'E' + 5 = 'J'.
 *
 *
 * We must take care, however, to wrap around if we go past the last character.
 * We don’t want to do 'Z' + 4 = '^'! We can use modular arithmetic once more
 * to avoid this problem. Consider this pseudocode:
 *
 *  rotateCharacter(c, rotationFactor) {
 *      return ((c - 'A' + rotationFactor) % 26) + 'A';
 *  }
 *
 * c - 'A' will let us represent each letter as a number from [0, 25].
 * This step is necessary because the ASCII value of ‘A’ is not 0.
 * We then add the rotation factor (and note that it isn’t actually necessary
 * to reduce it beforehand) and then take this sum modulo 26 to get the
 * [0, 25]-representation of the rotated character. We add ‘A’ back in at the
 * end to translate this value back into the ASCII range of A-Z.
 *
 */
private fun main() {
    // Call rotationalCipher() with test cases here
    println(rotationalCipher("ABC", 1)) // BCD
    println(rotationalCipher("WXY?Z", 6)) // bcd
    // TODO: improve for special characters!
}

private fun rotationalCipher(input: String, rotationFactor: Int): String {
    val finalString = StringBuilder()
    input.forEach { finalString.append(rotateChar(it, rotationFactor)) }
    return finalString.toString()
}

private fun rotateChar(c: Char, rotationFactor: Int): Char {
    return (((c - 'A' + rotationFactor) % 26) + 'A'.toInt()).toChar()
}