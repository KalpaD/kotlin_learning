package ext_func

fun main() {

    val c: Char = "abc".lastChar()

    println("last char of the 'abc' : $c")

    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6
}


fun String.lastChar () = this[this.length - 1]

// extension functions need to be imported and used
//import com.example.util.lastChat
//val c : Char = "abc".lastChar()


infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)


//Change the 'sum' function so that it was declared as an extension to List<Int>.

fun List<Int>.sum(): Int {
    var result: Int = 0
    for (i in this) {
        result += i
    }
    return result
}