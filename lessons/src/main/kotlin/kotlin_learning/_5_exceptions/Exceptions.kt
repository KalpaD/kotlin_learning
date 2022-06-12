package kotlin_learning._5_exceptions

import java.lang.IllegalArgumentException

fun main() {

    println(useOfTry("e10"))
    throwDemo(101)
}

fun throwDemo(number: Int): Int {
    return if (number in 0..100)
        number
    else
        throw IllegalArgumentException("A percentage value must be between 0 and 100")
}


// try is an expression in Kotlin

fun useOfTry(s: String): Int {
    // we can assign result of the try to a variable
    val number = try {
        Integer.parseInt(s)
    } catch (e: NumberFormatException) {
        return 1
    }

    return number
}

// Kotlin does not have the concept of checked exceptions
// but Java still has it hence when calling java method which throws checked exception
// we should use @Throws annotation
