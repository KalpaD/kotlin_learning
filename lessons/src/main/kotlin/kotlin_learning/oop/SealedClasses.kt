package kotlin_learning.oop


interface User
class Employer(val id: Int) : User
class Employee(val id: Int, val name: String) : User


// this does not compile
// 'when' expression must be exhaustive, add necessary 'else' branch
//  because there might be other sub classes of the User that is not known
/*fun problemWithNonSealedClasses(user: User): Unit = when(user) {
    is Employer -> println(user.id)
    is Employee -> println(user.name)
}*/

// to solve above problem, we can use the sealed modifier
// it restricts the class hierarchy
// all subclasses must be located int the same file

sealed class Car
class Bmw(val name: String) : Car()
class Benz(val name: String, val year: Int) : Car()

fun sayWhichCar(car: Car): Unit = when(car) {
    is Bmw -> println("I am super ${car.name}")
    is Benz -> println("I am super ${car.name} made in ${car.year}")
}

fun main() {
    sayWhichCar(Bmw("BMW"))
    sayWhichCar(Benz("Benz", 2021))
}