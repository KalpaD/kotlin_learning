package kotlin_learning._11_lambda


data class Hero(val name: String, val age: Int, val gender: Gender?)

enum class Gender {
    MALE, FEMALE
}

val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE))


fun q1(): String {
     return heroes.last().name
}

fun q2(): String? {
    return heroes.firstOrNull { it.age == 30 }?.name
}

fun q3(): Int {
    return heroes.map { it.age }.distinct().size
}

fun q4(): String {
    val (first, second) = heroes

            // this is how we should not use the syntactic convention `it`
            // Do not use `it` if it has different types in neighbouring lines.
            // prefer using explicit parameters
            .flatMap { heroes.map { hero -> it to hero } }
            .maxBy { it.first.age - it.second.age }!!
    return first.name
}

fun q4better(): String {
    val allPossiblePairs = heroes
            .flatMap {
                first -> heroes.map { second -> first to second }
            }
            // as a results we will have
            // The Captain -> The Captain
            // The Captain -> Frenchy
            // The Captain -> The Kid
            // The Captain -> Lady Lauren
            // The Captain -> First Mate
            // The Captain -> "Sir Stephen
            // ... to all the other possible pairs of heros,
            // then the flatMap() flatten it
    val (first, second) = allPossiblePairs
            .maxBy { it.first.age - it.second.age }!!
    return first.name
}

fun main() {
    println("Output of `heroes.last().name`: ${q1()}")
    println("Output of `heroes.firstOrNull { it.age == 30 }?.name`: ${q2()}")
    println("Output of `heroes.map { it.age }.distinct().size`: ${q3()}")
    println("Output of `q4`: ${q4()}")

}