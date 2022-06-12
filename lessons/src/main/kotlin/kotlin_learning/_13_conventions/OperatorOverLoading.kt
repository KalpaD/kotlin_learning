package kotlin_learning._13_conventions


class Point(val x: Int, val y: Int) {

    // the operator key word allows us to call plus as operator

    operator fun plus(other: Point): Point {
        return Point(this.x + other.x, this.y + other.y)
    }
}

fun operatorDemo() {
    val pointA = Point(1, 2)
    val pointB = Point(3, 4)

    val value = pointA + pointB
    println("new point x : ${value.x}, y : ${value.y}")
}

fun main() {
    operatorDemo()
}

