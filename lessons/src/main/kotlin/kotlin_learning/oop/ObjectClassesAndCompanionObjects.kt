package kotlin_learning.oop

// Concept #1 for the object key word
// work as a class modifier to make a class Singleton

object Singleton {
    val foo: String = "fooValue"

}

fun singletonDemo() {
    val singleton = Singleton
    val secondSingleton = Singleton

    singleton.foo

    println(singleton == secondSingleton)
}


// Concept #2 for the object key word
// object expression
// object expressions replace the Java anonymous inner classes

val helloWorld = object {
    val hello = "Hello"
    val world = "World"
    // object expressions extend Any, so `override` is required on `toString()`
    override fun toString() = "$hello $world"
}
open class X(x: Int) {
    public open val y: Int = x
}

interface Y { /*...*/ }

val ab: X = object : X(1), Y { override val y = 15 }


// Companion objects

class OuterClass {
    companion object {
        fun foo() = 1
    }
}


// companion objects can implement an interface
interface Factory<T> {
    fun create(type: ClientType): T
}
enum class ClientType {
    A, B;
}
class Client(val type: ClientType) {

    companion object : Factory<Client> {
        override fun create(type: ClientType): Client {
            return if (type == ClientType.A) {
                Client(ClientType.A)
            } else {
                Client(ClientType.B)
            }
        }
    }
}


fun companionObjectDemo() {
    // we can access companion object's members by the outer class name.
    // just like Java static methods
    println(OuterClass.foo())

    val typeAClient = Client.create(ClientType.A)
    println(typeAClient.type)
    val typeBClient = Client.create(ClientType.B)
    println(typeBClient.type)
}

fun main() {
    singletonDemo()
    companionObjectDemo()
}