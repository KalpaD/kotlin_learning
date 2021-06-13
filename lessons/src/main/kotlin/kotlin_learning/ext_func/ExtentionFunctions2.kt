package kotlin_learning.ext_func

// extension function are Java static function
// have a look on following example

open class Parent
class Child: Parent()

fun Parent.foo() = "parent"
fun Child.foo() = "child"

// we are trying the override the existing member function
// get() in String with extension function.
fun String.get(index: Int) = '*'


fun main(args: Array<String>) {
    val parent: Parent = Child()
    println(parent.foo()) // result is parent

    // the reason for that is , foo() extension function is static Java
    // method on the Parent class, there is not reason for the runtime
    // execute Child's foo() static method.


    // extensions are static Java methods under the hood
    // hence no override for extension function is Kotlin

    println("abc".get(1)) // result is 'b', member function always wins against extension function.

    // but extension can be overloaded
}