package kotlin_learning._1_variables

fun main() {

    val greeting = "Hi" // read only variables defines with val

    var mutableVar = "Name" // mutable variables defined with var

    // Note that the compiler infer the variable type for you.

    // variables defines with val can not be re-assigned
    //greeting = "hello";

    val languages = mutableListOf("Java") // this variable is read only

    // but as same as Java final references there is no read immutability for the content

    languages.add("Go")

    println(languages)

    val immutableLanguages = listOf("Java", "Kotlin")

    //immutableLanguages.add() // immutable list does not have method for mutability.
}