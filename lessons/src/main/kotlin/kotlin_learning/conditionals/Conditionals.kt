package kotlin_learning.conditionals


fun main() {

    println(whenAsSwitch(Color.BLUE))

    val petCat = Cat()
    val petDog = Dog()
    println(typeCheckWithWhen(petCat))
    println(typeCheckWithWhen(petDog))

    println(getSound())
}

fun max(a: Int, b: Int): Int {
    // if is an expression in Kotlin
    // that means if returns a value
    val max = if (a > b) a else b
    return max
    // There is no ternary operator in Kotlin
}

enum class Color {
    BLUE, ORANGE, RED, YELLOW, VIOLET, INDEGO
}

// note that unlike Java , the conditional statement does not need to be
// stopped by applying a break. It stops by itself once the condition is satisfied and return.
fun whenAsSwitch(color: Color): String =
    when (color) {
        Color.BLUE -> "cold"
        Color.ORANGE -> "mild"
        Color.RED -> "hot"
        else -> throw Exception("Unidentified color")
    }

// Any expression can be used as a branch condition
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.ORANGE
        setOf(Color.BLUE, Color.VIOLET) -> Color.ORANGE
        else -> throw Exception("Unidentified color combination")
    }

interface Pet {
    fun meow(): String
    fun woof(): String
}

class Cat : Pet {

    override fun meow(): String = "meow, meow"

    override fun woof(): String = "Are you crazy, cats do not make dog sounds"
}

class Dog : Pet {

    override fun meow(): String = "Are you crazy, dogs do not make cat sounds"

    override fun woof(): String = "woof, woof"
}

// when can use to check types as well
fun typeCheckWithWhen(pet : Pet) =
    when (pet) {
        is Cat -> pet.meow()
        is Dog -> pet.woof()
        else -> throw Exception("We do not know how to make sound")
    }

// we can use when without arguments as well

fun updateWeather(degrees: Int) {
    val (description, colour) = when {
        degrees < 5 -> "cold" to Color.BLUE
        degrees < 23 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }
}

fun getMyFavouritePet(): Pet {
    val rand = (0..1).random()
    return if (rand == 0) Cat() else Dog()
}

// when expression is good when we have multiple expressions to evaluate
fun getSound(): String =
        when (val pet = getMyFavouritePet()) {
            is Cat -> pet.meow()
            is Dog -> pet.woof()
            else -> "---"
        }