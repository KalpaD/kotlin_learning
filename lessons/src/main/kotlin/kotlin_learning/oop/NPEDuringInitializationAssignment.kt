package kotlin_learning.oop

// Complete the declaration of the class
// A without throwing NullPointerException explicitly so that NPE was
// thrown during the creation of its subclass B instance.


open class ParentClazz(open val value: String) {
    init {
        // child value is not initialised at this time
        // the problem is the non final open value, which allow the sub class the override the value
        value.length
    }
}

class ChildClazz(override val value: String) : ParentClazz(value)

fun main(args: Array<String>) {
    ChildClazz("a")
}