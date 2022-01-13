package solutions

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class _005_LongestPalindromicSubstringTest {
    private var solution: _005_LongestPalindromicSubstring? = null

    companion object {
        @JvmStatic
        fun testCases(): Stream<Arguments> = Stream.of(
            Arguments.of("babad", "bab"),
            Arguments.of("cbbd", "bb"),
            Arguments.of("abcdedcba", "abcdedcba"),
            Arguments.of("aabbccbbaa", "aabbccbbaa"),
            Arguments.of("xaabacxcabaaxcabaax", "xaabacxcabaax"),
            Arguments.of("aacabdkacaa", "aca"),
            Arguments.of("abacab", "bacab")

        )

    }

    @BeforeEach
    fun setUp() {
        solution = _005_LongestPalindromicSubstring()
    }

    @AfterEach
    fun tearDown() {
        solution = null
    }

    @ParameterizedTest(name = "solution#{index} ==> input={0}, expect={1}")
    @MethodSource("testCases")
    fun solution(s: String, expect: String) {
//        assertEquals(expect, solution?.solution(s))
    }
}