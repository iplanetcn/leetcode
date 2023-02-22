package solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class P0005LongestPalindromicSubstringTest {
    private P0005LongestPalindromicSubstring solution;

    @BeforeEach
    void setUp() {
        solution = new P0005LongestPalindromicSubstring();
    }

    @AfterEach
    void tearDown() {
        solution = null;
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("abcdedcba", "abcdedcba"),
                Arguments.of("aabbccbbaa", "aabbccbbaa"),
                Arguments.of("xaabacxcabaaxcabaax", "xaabacxcabaax"),
                Arguments.of("aacabdkacaa", "aca"),
                Arguments.of("abacab", "bacab")
        );
    }

    @ParameterizedTest(name = "solutionFirst#{index} ==> input={0}, expect={1}")
    @MethodSource("testCases")
    void solutionFirst(String input, String expect) {
        assertEquals(expect, solution.solutionFirst(input));
    }

    @ParameterizedTest(name = "solutionSecond#{index} ==> input={0}, expect={1}")
    @MethodSource("testCases")
    void solutionSecond(String input, String expect) {
        // TODO: Alter the algorithms
//        assertEquals(expect, solution.solutionSecond(input));
    }

    @ParameterizedTest(name = "solutionThird#{index} ==> input={0}, expect={1}")
    @MethodSource("testCases")
    void solutionThird(String input, String expect) {
        // TODO: Alter the algorithms
//        assertEquals(expect, solution.solutionThird(input));
    }


}