package kotlin_learning

import kotlin_learning.assingment.Evaluation
import kotlin_learning.assingment.evaluateGuess
import org.junit.Assert
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

internal fun testEvaluation(first: String, second: String, positions: Int, letters: Int) {
    val evaluation = Evaluation(positions, letters)
    testEvaluationOneWay(secret = first, guess = second, expected = evaluation)
    testEvaluationOneWay(guess = second, secret = first, expected = evaluation)
}

internal fun testEvaluationOneWay(secret: String, guess: String, expected: Evaluation) {
    val evaluation = evaluateGuess(secret, guess)
    Assert.assertEquals("Wrong evaluation for secret=$secret, guess=$guess",
            expected, evaluation)
}



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestMastermindDifferentLetters {

    @Test
    fun test01SampleEqual() = testEvaluation("ABCD", "ABCD", 4, 0)

    @Test
    fun test02SampleOnlyWrongPositions() = testEvaluation("ABCD", "CDBA", 0, 4)

    @Test
    fun test03SampleSwap() = testEvaluation("ABCD", "ABDC", 2, 2)

    @Test
    fun test04RightPositions() = testEvaluation("ABCD", "ABCF", 3, 0)

    @Test
    fun test05WrongPositions() = testEvaluation("DAEF", "FECA", 0, 3)

    @Test
    fun test06BothRightAndWrong() = testEvaluation("ACEB", "BCDF", 1, 1)

    @Test
    fun test07() = testEvaluation("FBAE", "ABCD", 1, 1)

    @Test
    fun test08() = testEvaluation("FBAE", "AFDC", 0, 2)

    @Test
    fun test09() = testEvaluation("FBAE", "CBAE", 3, 0)

    @Test
    fun test10() = testEvaluation("FBAE", "CBFE", 2, 1)

    @Test
    fun test11() = testEvaluation("FBAE", "FBAE", 4, 0)

    @Test
    fun test12() = testEvaluation("EBAC", "ABCD", 1, 2)

    @Test
    fun test13() = testEvaluation("EBAC", "AFCB", 0, 3)

    @Test
    fun test14() = testEvaluation("EBAC", "CBDF", 1, 1)

    @Test
    fun test15() = testEvaluation("EBAC", "EBAC", 4, 0)
}

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestMastermindRepeatedLetters {

    @Test
    fun test01Sample() = testEvaluation("AABC", "ADFE", 1, 0)

    @Test
    fun test02Sample() = testEvaluation("AABC", "ADFA", 1, 1)

    @Test
    fun test03Sample() = testEvaluation("AABC", "DFAA", 0, 2)

    @Test
    fun test04Sample() = testEvaluation("AABC", "DEFA", 0, 1)

    @Test
    fun test05() = testEvaluation("ABCD", "EAAA", 0, 1)

    @Test
    fun test06() = testEvaluation("AABC", "ADFA", 1, 1)

    @Test
    fun test07() = testEvaluation("AABC", "DEFA", 0, 1)

    @Test
    fun test08() = testEvaluation("EDEB", "CBFE", 0, 2)

    @Test
    fun test09() = testEvaluation("CFDF", "FCCD", 0, 3)

    @Test
    fun test10() = testEvaluation("AABC", "AEFD", 1, 0)

    @Test
    fun test11() = testEvaluation("DCFC", "ABEC", 1, 0)

    @Test
    fun test12() = testEvaluation("FDCD", "FBAD", 2, 0)

    @Test
    fun test13() = testEvaluation("DEFA", "AABC", 0, 1)

    @Test
    fun test14() = testEvaluation("DAAE", "AABC", 1, 1)

    @Test
    fun test15() = testEvaluation("BBDC", "DFBB", 0, 3)

    @Test
    fun test16() = testEvaluation("DBFF", "FFDD", 0, 3)

    @Test
    fun test17() = testEvaluation("BDAD", "AAAE", 1, 0)

    @Test
    fun test18() = testEvaluation("FDDB", "CABB", 1, 0)

    @Test
    fun test19() = testEvaluation("BDBC", "DDFC", 2, 0)

    @Test
    fun test20() = testEvaluation("ECDE", "CEEE", 1, 2)

    @Test
    fun test21() = testEvaluation("AAAF", "ABCA", 1, 1)

    @Test
    fun test22() = testEvaluation("BCDA", "AFEA", 1, 0)

    @Test
    fun test23() = testEvaluation("EEEE", "AFEA", 1, 0)

    @Test
    fun test24() = testEvaluation("EEBE", "AFEA", 0, 1)

    @Test
    fun test25() = testEvaluation("EEAD", "EEEE", 2, 0)

    @Test
    fun test26() = testEvaluation("BACD", "EAFF", 1, 0)
}

