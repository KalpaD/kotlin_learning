package kotlin_learning._15_inandrange


fun main() {

    inForIteration()
    println()

    println(inForBelonging('c'))

    println(isLetter('6'))

    println(recognize('6'))

    println(stringComparision("kl"))
}


// in operator can be used for iteration
fun inForIteration() {
    for (i in 1..9) {
        print(i)
    }
}

fun inForBelonging(a: Char) = a in 'a'..'z'
    // and also can use to check for belonging

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

// in as when condition
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It is a digit"
    in 'a'..'z', in 'A'..'Z' -> "It is a letter"
    else -> "I do not know"
}

fun stringComparision(s: String): Boolean {
    return s in "a".."k"
}



