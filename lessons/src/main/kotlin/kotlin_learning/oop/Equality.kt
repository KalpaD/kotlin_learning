package kotlin_learning.oop


fun equalityDemo() {
    val set1 = setOf(1, 2 ,3)
    val set2 = setOf(1, 2 ,3)

    println("Results of == ${set1 == set2} , this calls the equals() method which compares the content")

    println("Results of === ${set1 === set2} , this checks the referential equality")
}


fun equalityDemoWithDataClass() {
    class Foo(val first: Int, val second: Int)
    data class Bar(val first: Int, val second: Int)

    val f1 = Foo(1, 2)
    val f2 = Foo(1, 2)
    // this prints false, as for the none data class, Kotlin generates the trivial equals method
    // which check the reference equality
    println(f1 == f2)

    val b1 = Bar(1, 2)
    val b2 = Bar(1, 2)
    // this prints true, as Kotlin generates the content equality method
    println(b1 == b2)
}



fun main() {
    equalityDemo()
    equalityDemoWithDataClass()
}

