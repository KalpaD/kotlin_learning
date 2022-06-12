package kotlin_learning._11_lambda


fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        // the result of the this invocation is []
        // this is because as language constructs
        // the return , returns from the function it contains
        // not from the lambda
        if (it == 0) return listOf()
        listOf(it, it)
    }
}

// but what is we want o return from the lambda
// we can use labels
fun duplicateNonZeroWithLabels(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0) return@flatMap listOf<Int>()
        listOf(it, it)
    }
}

// another approach would be us ea local function
fun duplicateNonZeroWithLocalFunction(list: List<Int>): List<Int> {
    fun duplicateNonZeroElement(e: Int): List<Int> {
            if (e == 0) return listOf()
            return listOf(e, e)
    }
    return list.flatMap { duplicateNonZeroElement(it) }
}

// or we can use anonymous function
fun duplicateNonZeroWithAnonymousFunction(list: List<Int>): List<Int> {
    return list.flatMap (fun (e): List<Int> {
        if (e == 0) return listOf()
        return listOf(e, e)
    })
}


fun main() {
    println("duplicateNonZero(listOf(3, 0, 5)) prints : ${ duplicateNonZero(listOf(3, 0, 5))}")
    println("duplicateNonZeroWithLabels(listOf(3, 0, 5)) prints : ${ duplicateNonZeroWithLabels(listOf(3, 0, 5))}")
}