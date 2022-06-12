package kotlin_learning._14_properties

class LazyInitPropertyDemo {

    val lazyValue: String by lazy {
        println("computed")
        "I am lazy initialised property, I get compute only once at the first call"
    }
}

fun lazyInitPropertyDemo() {
    val lazyInitDemo = LazyInitPropertyDemo()
    println(lazyInitDemo.lazyValue)
    println(lazyInitDemo.lazyValue)
    println(lazyInitDemo.lazyValue)
}


fun main() {
    lazyInitPropertyDemo()
}