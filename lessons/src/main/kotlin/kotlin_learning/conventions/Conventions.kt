package kotlin_learning.conventions

import kotlin_learning.conditionals.Color

// in kotlin we can compare any class that defines coparative method.

fun compare() {

    val abc = "abc"
    val def = "def"

    val res = abc < def

    println("abc < def $res")
}

fun equality() {
    val s1 = "string1"
    val s2 = "string2"

    val res = s1 == s2
    // calls equals under the hood
    println("s1 == s2: $res")

    // it also correctly handles null
    val nullRes = null == "abc"
    println("null == \"abc\" $nullRes")

}

/**
 * De structuring declarations allow you to define several variables at once by
 * assigning one expression and automatically destructuring it.
 */
fun deStructuring() {

    val degrees = 20

    var (description, colour) = when {
        degrees < 10 -> "cold" to Color.BLUE
        degrees < 25 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }

    data class Contact(val name: String, val email: String, val phoneNumber: String)

    val contact = Contact("Jane Smith", "jane.smith@gmail.com", "034638592940")

    val (name, _, phoneNumber) = contact

    println("name : $name")
    println("phoneNumber : $phoneNumber")
}


fun main() {
    compare()
    equality()
    deStructuring()
}