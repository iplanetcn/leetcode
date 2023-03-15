package solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * P0007ReverseIntegerTest
 *
 * @author john
 * @since 2023-02-27
 */
class P0007ReverseIntegerTest {
    private P0007ReverseInteger solution;

    @BeforeEach
    void setUp() {
        solution = new P0007ReverseInteger();
    }

    @AfterEach
    void tearDown() {
        solution = null;
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21)
        );
    }

    @ParameterizedTest(name = "solutionFirst#{index} ==> input=\"{0}\", expect=\"{1}\"")
    @MethodSource("testCases")
    void solutionFirst(int input, int expect) {
        assertEquals(expect, solution.solutionFirst(input));
    }

    @ParameterizedTest(name = "solutionSecond#{index} ==> input=\"{0}\", expect=\"{1}\"")
    @MethodSource("testCases")
    void solutionSecond(int input, int expect) {
        assertEquals(expect, solution.solutionSecond(input));
    }
}