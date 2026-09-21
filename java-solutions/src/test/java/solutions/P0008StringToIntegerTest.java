package solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P0008StringToIntegerTest
 *
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 *
 * @author john
 * @since 2023-03-15
 */
class P0008StringToIntegerTest {
    P0008StringToInteger solution;

    @BeforeEach
    void setUp() {
        solution = new P0008StringToInteger();
    }

    @AfterEach
    void tearDown() {
        solution = null;
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("4193 with words", 4193),
                Arguments.of("", 0),
                Arguments.of(" ", 0)
        );
    }

    @ParameterizedTest(name = "solutionFirst#{index} ==> input=\"{0}\", expect=\"{1}\"")
    @MethodSource("testCases")
    void myAtoiTest(String input, int expect) {
        assertEquals(expect, solution.myAtoi(input));
    }
}