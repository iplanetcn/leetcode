package solutions

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class P0004MedianOfTwoSortedArraysTest {
    private var solutions: P0004MedianOfTwoSortedArrays? = null

    companion object {
        @JvmStatic
        fun generateData(): Stream<Arguments> = Stream.of(
                Arguments.of(intArrayOf(1, 3), intArrayOf(2), 2),
                Arguments.of(intArrayOf(1, 2), intArrayOf(3, 4), 2.5)
        )
    }

    @BeforeEach
    fun setUp() {
        solutions = P0004MedianOfTwoSortedArrays()
    }

    @AfterEach
    fun tearDown() {
        solutions = null
    }

    @ParameterizedTest(name = "solution#{index} ==> input=\"{0} {1}\", expect={2}")
    @MethodSource("generateData")
    fun solution(num1: IntArray?, num2: IntArray?, answer: Double) {
        Assertions.assertEquals(answer, solutions!!.findMedianSortedArrays(num1!!, num2!!))
    }
}