package kotlin_learning._8_nullabletypes

fun main() {

}


fun nullableDemo() {

    // this is a non null able type
    val s1: String = "not null"

    // this is a nullable type, we tell kotlin compiler that by adding '?' at the end of the type
    val s2: String? = null

    s1.length // not complains from compiler

   // s2.length // compiler would not allow this to happen as it can see that s2 can be null
}


fun dealingWithNullableType() {

    val s: String? // note that the ? mark express that this string can be nullable

    s = getString(0) // getString can return null

    if (s != null) {  // we can use the classic null check
        s.length
    }

    // or we can use Safe access
    var len: Int? = s?.length // note the safe access operator consists of ?. combination

    // if (s != null) -> it returns the length
    // if (s == null) -> it returns null

    // and note that the type of the len variable is not nullable Int , noted by Int?
    // above is same as

    len = if (s != null)  s.length else null

    // and it is important to note that when we use safe access operator
    // the return type also will be nullable

    // for example the above len variable type is Int?

}

fun demoElvisOperator() {
    val s: String? = getString(0)

    val len = if (s != null)  s.length else 0

    // the above can be expressed using elvis "operator" -> ?:

    val leng: Int = s?.length ?: 0

    // consider following example, the elvis operator provides the default value

    val a: Int? = null
    val b: Int? = 1
    val c: Int = 2

    // elvis operator provide the default value
    val s1 = (a ?: 0) + c // 2
    val s2 = (b ?: 0) + c // 3

    print("$s1$s2") // 23

}

fun demoControlFlowAnalysis() {

    val s: String? = getString(0)

    if (s == null) return

    s.length // here compiler allow us to access length since we can null check,
    // and also note that compiler do a smart cast 's' to non-nullable type

    // in cases where Kotlin compiler can not infer the nullability we can
    // use not-null assertion for that (!!)

    s!!

    // As a general rule of thumb prefer
    // ?. - safe operator
    // ?: - elvis operator
    // if-else checks

    // compared to !!


}
data class Name(val key: String, val value: String)
fun isFoo1(n: Name) = n.value == "foo"
// fun isFoo2(n: Name?) = n.value == "foo" // this will not compile as n is nullable and n.value does not use
// safe operator or null assertion
fun isFoo3(n: Name?) = n != null && n.value == "foo"
fun isFoo4(n: Name?) = n?.value == "foo"

fun nullableDemo2() {
    //isFoo1(null)  // this will not compile as the , receiver does not expect any null value
    //isFoo2(null)
    isFoo3(null)
    isFoo4(null)
}

fun getString(a: Int): String? = if (a == 1) "abc" else  null

// nullable types are implemented using annotations, hence like Java optional there is no performance cost

fun foo(list1: List<Int?>, list2: List<Int>?) {
    list1.size
    list2?.size

    val i: Int? = list1.get(0)
    val j: Int? = list2?.get(0)
}