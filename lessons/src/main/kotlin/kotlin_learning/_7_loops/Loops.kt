package kotlin_learning._7_loops


fun main() {
    forLoop()

    forLoopWithIndex()

    iterateOverMap()

    iterateOverRange()

    iterateOverRangeUsingUntil()

    iterateOverString("abc")
    iterateOverString("dog")
}

// we have the same do {} while () loop as Java

// for loops are bit different to Java
fun forLoop() {
    val list = listOf("a", "b", "c")
    for (s in list) {
        println(s)
    }
}

// we can iterate with index if we want
fun forLoopWithIndex() {
    val list = listOf("a", "b", "c")
    for ((index, element) in list.withIndex()) {
        println("printing with index $index : $element")
    }
}

fun forLoopWithType() {
    val list = listOf("a", "b", "c")
    // we can express the type if we want
    for (s: String in list) {
        println(s)
    }
}

fun iterateOverMap() {
    // iterating over map
    val map = mapOf<Int, String>(1 to "one", 2 to "two", 3 to "three")

    for ((key, value) in map) {
        println("$key = $value")
    }
}

// note that when we use the range with a..b semantics, it includes the upper bound
fun iterateOverRange() {
    for (i in 1..9) {
        print(i)
    }
}

// note tha when we use the range with until operator, the upper bound is omitted
fun iterateOverRangeUsingUntil() {
    print("  ")
    for(i in 1 until 9) {
        print(i)
    }
}

fun iterateOverString(str : String) {
    // when str = "abc"  prints , "bcd" which is really strange since
    // we have not even provided d but the range operation get it from the alphabet :-o
    for (c in str) {
        print(c + 1)
    }
    println()
}






