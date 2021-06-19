package kotlin_learning.properties

class A1 {
    // this variable does not get initialised at the constructor
    // but in a  later stage via setUp(), before getting accessed
    // but compile does not know that, hence we will have to assign null for it
    // at the init time, then deal with nullability of the variable
    var prop: String? = null

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

class A {
    // A1 is not nice, for this we can use lateinit keyword
    //'lateinit' modifier is allowed only on mutable properties, becasue this varibale can be changed via Java
    // then if we allow val here, we will endup having a variable which is mutable from Java but not from Kotlin
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun lateInitNotHappenDemo() {
    // what if the init did not happen and we access the variable
    val a = A()
    a.display()
    // Exception in thread "main" kotlin.UninitializedPropertyAccessException: lateinit property prop has not been initialized
}



fun main(args: Array<String>) {
    lateInitNotHappenDemo()

}