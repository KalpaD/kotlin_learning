@file:JvmName("Functions") // we can use @JvmName annotation to change the package name of the file
package functions

fun main() {

    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))
}

// consider this as a public function
// hence the return type is mentioned
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// we can have expression as the function body
fun min(a: Int, b: Int): Int = if (a < b) b else a


// Functions can return Unit. we can think is as void
                    //        :Unit   compiler infer type Unit when we have not defined it.
fun displayMax(a: Int, b: Int) {
    println(max(a, b))
}

// that is equivalent to following

fun displayMin(a: Int, b: Int): Unit {
    println(min(a, b))
}



// In Kotlin functions everywhere
class A {
    fun member() = 2  // this is a member function
}

fun other() {
    fun local() = 3   // this is a local function
}

// if we want to call a top level function in a Kotlin file
// we can call it as a static function of the class
// which name corresponds to a file name


