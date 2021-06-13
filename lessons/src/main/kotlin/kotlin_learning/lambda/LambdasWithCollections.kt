package kotlin_learning.lambda

data class Employee(
    val city: City, val age: Int
)

enum class City {
    SYDNEY, NEWYORK, COLOMBO
}

val employees = mutableListOf(Employee(City.COLOMBO, 28), Employee(City.NEWYORK, 20), Employee(City.SYDNEY, 30))

fun filter() {
    println("Start filtering employees who are less than 30 years old and print their city")
    employees.filter { it.age < 30 }.map { it.city }.map { println(it) }
    println("Filtering completed")
}


fun any() {
    // any function check , if there is a any element which satisfies the given condition

    println("Is there any employee who is older than 30 years ? ${employees.any { it.age > 30}}")
}

fun partition() {

    employees.partition { employee -> employee.age  > 29 }.first.map { e -> print(e.city) }
}

fun main() {

    filter()
    any()

}