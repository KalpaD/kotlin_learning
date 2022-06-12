package kotlin_learning.practical_assingments

fun isValidIdentifier(s: String): Boolean {
    return s.isNotEmpty() && isStartsWithLetterOrUnderscore(s) && isValidContent(s)
}

fun isStartsWithLetterOrUnderscore(s: String): Boolean {
    val c = s[0]
    return c in 'a'..'z' || c in 'A'..'Z' || c == '_'
}

fun isValidContent(s: String): Boolean {
    val chars = s.toCharArray()
    for (c in chars) {
        if (!isAllowedChar(c)) {
            return false
        }
        continue
    }
    return true
}

fun isAllowedChar(c: Char): Boolean = when(c) {
    in 'a'..'z', in 'A'..'Z', in '0'..'9' -> true
    (c) -> c == '_'
    else -> false
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}