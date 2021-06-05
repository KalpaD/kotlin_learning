package lambda



fun main() {

}

fun lambdaFunc() {
    // in Kotlin lambda syntax is as follows
    // note that they always use curly braces
                // parameters       // body
    var lambda = {x: Int, y: Int -> x + y}
}

fun lambdaWithList() {

    var list = mutableListOf<String>("A", "B", "C")

    // this is one way to express the lambda
    list.any({ str: String -> str.startsWith('A')})

    // but the better way is as follows
    list.any { str: String -> str.startsWith('A')}

    // if lambda has only one argument, we can replace that argument with
    // 'it'
    list.any() { it.startsWith('A') }

    // the following example show how to use lambda with multiline
    list.any() {
        println("processing $it")
        // the last expression is the result of the lambda
        it.length == 1
    }
}

fun lambdaWithMap() {
    var map = mutableMapOf<Char, Int>(Pair('A', 1), Pair('B', 2), Pair('C', 3))

    map.mapValues { (key, value) -> "$key -> $value" }

}