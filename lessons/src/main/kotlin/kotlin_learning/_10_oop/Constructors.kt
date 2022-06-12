package kotlin_learning._10_oop

class A {
    // the default constructor auto generated
}


// primary constructor
class Person(val name: String, val age: Int)


// if we have complex initialisation we use the init block
class ComplexPerson(firstName: String, lastName: String) {
    val name: String

    init {
        this.name = "$firstName $lastName"
    }
}

// we can change the constructor visibility using visibility modifiers
// then we have to use the constructor key work with the visibility modifier
class InternalComponents private constructor(name: String) {

}

// we can have secondary constructor
class Customer(id: Int, val name: String) {

    constructor(id: Int, firstName: String, lastName: String) : this(id, "$firstName $lastName")
}

fun secondConstructorDemo() {
    val customer = Customer(1, "John", "Doe")
    println(customer.name)
}


// For inheritance both extends and implements replaced by colon
interface Animal
class Cat : Animal

open class Parent
class Child: Parent() // note the constructor call

fun main() {
    secondConstructorDemo()
}

