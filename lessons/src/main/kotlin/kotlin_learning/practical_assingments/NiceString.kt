package kotlin_learning.practical_assingments

/**
 * Nice String
    A string is nice if at least two of the following conditions are satisfied:
    It doesn't contain substrings bu, ba or be;
    It contains at least three vowels (vowels are a, e, i, o and u);
    It contains a double letter (at least two similar letters following one another), like b in "abba".

    Your task is to check whether a given string is nice. Strings for this task will consist of lowercase letters only. Note that for the purpose of this task, you don't need to consider 'y' as a vowel.
    Note that any two conditions might be satisfied to make a string nice. For instance, "aei" satisfies only the conditions #1 and #2, and ```"nn"` satisfies the conditions #1 and #3, which means both strings are nice.
    Example 1
        "bac" isn't nice. No conditions are satisfied: it contains a ba substring, contains only one vowel and no doubles.
    Example 2
        "aza" isn't nice. Only the first condition is satisfied, but the string doesn't contain enough vowels or doubles.
    Example 3
        "abaca" isn't nice. The second condition is satisfied: it contains three vowels a, but the other two aren't satisfied: it contains ba and no doubles.
    Example 4
        "baaa" is nice. The conditions #2 and #3 are satisfied: it contains three vowels a and a double a.
    Example 5
        "aaab" is nice, because all three conditions are satisfied.
 */
fun String.isNice(): Boolean {
    val doesNotContainsBuBaBe = !containsBuBaBe(this)
    val hasThreeVowels = hasThreeVowels(this)
    val hasDoubleLetter =  hasDoubleLetter(this)

    val numberOfConditionsMet = listOf(doesNotContainsBuBaBe, hasThreeVowels, hasDoubleLetter)
        .filter { it }
        .count()

    return numberOfConditionsMet >= 2
}

fun containsBuBaBe(input: String): Boolean {
    return input.contains("bu", true) ||
            input.contains("ba", true) ||
            input.contains("be", true)
}

fun hasThreeVowels(input : String): Boolean {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val charGroups: Map<Char, List<Char>> = input.groupBy { it }

    val sumOfVowels = charGroups.filter { pair -> vowels.contains(pair.key) }
        .map { pair -> pair.value.size }
        .sum()

    println(sumOfVowels)
    return sumOfVowels >= 3
}

fun hasDoubleLetter(input: String): Boolean {
    val doubleLetterOccurrenceCount = input.zipWithNext()
        .filter { pair -> pair.first == pair.second }
        .count()
    println(doubleLetterOccurrenceCount)
    return doubleLetterOccurrenceCount > 0
}
