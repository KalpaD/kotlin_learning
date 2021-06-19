package kotlin_learning.oop

// in kotlin we get a static nested class by default

class Outer {
    val foo: String = "foo outer"
    inner class Inner {
        val foo: String = "foo inner"
    }

    fun getInner(): String {
        return Inner().foo
    }
}

fun main() {

    val outer = Outer()
    println(outer.foo)

    // by default this is the static inner class
    val innerfoo = outer.getInner()
    println(innerfoo)
}