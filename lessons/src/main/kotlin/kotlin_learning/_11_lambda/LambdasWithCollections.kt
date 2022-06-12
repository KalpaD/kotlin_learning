package kotlin_learning._11_lambda

data class Employee(
    val city: City, val age: Int
)

enum class City {
    SYDNEY, NEWYORK, COLOMBO, KANDY, STOCKHOLM, ROME
}

val employees = mutableListOf(
        Employee(City.COLOMBO, 28),
        Employee(City.NEWYORK, 20),
        Employee(City.STOCKHOLM, 30),
        Employee(City.ROME, 37),
        Employee(City.KANDY, 27),
        Employee(City.STOCKHOLM, 29),
        Employee(City.ROME, 31))

fun filter() {
    println("Start filtering employees who are less than 30 years old and print their city")
    employees.filter { it.age < 30 }.map { it.city }.map { println(it) }
    println("Filtering completed")
}


fun any() {
    // any function check , if there is a any element which satisfies the given condition

    println("Is there any employee who is older than 30 years ? ${employees.any { it.age > 30}}")
}

/**
 * Find finds the element satisfying the given predicate and returns it as a result.
 */
fun find() {
   val employeeFromSydney = employees.find { it.city == City.SYDNEY && it.age == 30 }
    println("Find returns $employeeFromSydney")
}

/**
 * Partition divides the collection in to two collections
 * It returns two collection once match the predicate other not
 */
fun partition() {
    val partition: Pair<List<Employee>, List<Employee>> = employees.partition { employee -> employee.age > 29 }

    println("First partition")
    partition.first.forEach { println(it) }

    println("Second partition")
    partition.second.forEach { println(it) }
}

/**
 * Group by divides the collection in to groups by the given key
 */
fun groupBy() {
    // here we use city as the key to group the collection
    val groupBy: Map<City, List<Employee>> = employees.groupBy { it.city }

    groupBy.mapValues { (key, value) -> println("key : $key , value : $value") }
}

/**
 * associateBy also does the grouping, but it only returns one value for a given key
 * and it removes the duplicates from results
 */
fun associateBy() {

    val associateBy = employees.associateBy { it.city }
    associateBy.mapValues { (key, value) -> println("key : $key , value : $value") }
    /*
    key : COLOMBO , value : Employee(city=COLOMBO, age=28)
    key : NEWYORK , value : Employee(city=NEWYORK, age=20)
    key : STOCKHOLM , value : Employee(city=STOCKHOLM, age=29)
    key : ROME , value : Employee(city=ROME, age=31)
    key : KANDY , value : Employee(city=KANDY, age=27)
    * */
}

fun associate() {
    val associate = employees.associate { it.city to it.age }
    associate.mapValues { (key, value) -> println("key : $key , value : $value") }
}

fun zip() {
    val charList = listOf("A", "B", "C", "D")
    val numList = listOf(1, 2, 3, 4)

    val zippedResult: List<Pair<String, Int>> = charList.zip(numList)
    zippedResult.forEach { println(it) }
}

fun zipWithNext() {
    val numList = listOf(1, 2, 3, 4)
    numList.zipWithNext().forEach { println(it) }
}

fun main() {

    println("--filter()--")
    filter()
    println("--any()--")
    any()
    println("--find()--")
    find()
    println("--partition()--")
    partition()
    println("--groupBy()--")
    groupBy()
    println("--associateBy()--")
    associateBy()
    println("--associate()--")
    associate()
    println("--zip()--")
    zip()
    println("--zipWithNext()--")
    zipWithNext()

}