package kotlin_learning.functions

// In Kotlin we can store lambda asa a variable, when we store a lambda ina variable
// we call it a FunctionType

val sum: (Int, Int) -> Int = { x , y -> x + y}

val isEven = { i: Int -> i % 2 == 0 }


// this is how we can store a member reference in a variable
val evenPredicate = ::isEven