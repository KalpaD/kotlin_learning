package kotlin_learning._10_oop

// same as java we can use generic functions, classes, interfaces

fun genericFuncUse(ints: List<Int>) {
    ints.filter { it > 0 }
}

fun genericFuncUseString(strings: List<String>) {
    strings.filter { it.isNotEmpty() }
}

// the types can be nullable as well
fun genericFuncUseNullable(ints: List<Int?>) {
    ints.filter { it != null && it > 0}
}

fun nullablGenricDemo() {
    val ints = listOf(1, 2, 3)
    val i: Int? = ints.firstOrNull()

    val j: Int? = listOf<Int>().firstOrNull()

    val k: Int? = listOf(null, 1).firstOrNull()

}

fun <T> nullElement(list: List<T>) {
    for (element in list) {
        // element can be null here
    }
}

// to make it non-nullable we can use a non nullable upper bound
// Any is at the top of the kotlin class hierarchy.
fun <T: Any> nonNullElement(list: List<T>) {
    for (element in list) {

    }
}

fun nonNullableGenericDemo() {
    val list = listOf(null, 1)

    /*
        Type parameter bound for T in
        fun <T : Any> nonNullElement(list: List<T>): Unit is not satisfied: inferred type Int? is not a subtype of Any
     */
    //nonNullElement(list)
}

// Since the JVM does not allow to have method with the same signature with different generic parameters
// it is not legal to have such functions

/*fun List<Int>.avarage(): Double {
    return (this.sum() / this.size).toDouble()
}

fun List<Double>.avarage(): Double {
    return (this.sum() / this.size).toDouble()
}*/

// to avoid this we can use the special JVM annotation to rename the method when compiled
fun List<Int>.avarage(): Double {
    return (this.sum() / this.size).toDouble()
}

@JvmName("averageOfDouble")
fun List<Double>.avarage(): Double {
    return (this.sum() / this.size).toDouble()
}