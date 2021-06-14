package kotlin_learning.assingment

import kotlin.math.min

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    // the zip gives us [(B, A), (C, C), (D, E), (F, B)] then we find the pairs where first chat == second char
    val rightPosition = secret.zip(guess).count { it.first == it.second }

    // then try to find the number of minimum common letters in two strings
    val commonLetters =  "ABCDEF".sumBy { ch ->
        min( secret.count{ it == ch }, guess.count{ it == ch})
    }

    // then subtract the rightPosition from commonLetters , which gives the correct letter but wrong positions
    return Evaluation(rightPosition, commonLetters - rightPosition)
}

