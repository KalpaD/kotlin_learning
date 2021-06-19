package kotlin_learning.oop

// the difference here is that , enums are not another type in kotlin
// they are modified classes, `enum` keyword is the modifier
enum class Color {
    BLUE, BLACK, RED
}

// we can pass constructor arguments as any other class
enum class Color2(val r: Int, val g: Int, val b: Int) {
    BLUE(0, 0, 225), ORANGE(255, 165, 0), RED(255, 0, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

