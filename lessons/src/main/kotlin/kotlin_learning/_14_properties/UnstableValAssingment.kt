package kotlin_learning._14_properties

// Implement the property 'foo' so that it produced a different value on each access.
// Note that you can modify the code outside the 'foo' getter (e.g. add additional imports or properties).

val foo: Int
    get() = (Math.random() * 10).toInt()

fun main(args: Array<String>) {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}