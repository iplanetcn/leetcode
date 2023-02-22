package solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * P0006ZigzagConversionTest
 *
 * @author john
 * @since 2023-02-22
 */
class P0006ZigzagConversionTest {

    private P0006ZigzagConversion solution;

    @BeforeEach
    void setUp() {
        solution = new P0006ZigzagConversion();
    }

    @AfterEach
    void tearDown() {
        solution = null;
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A")
        );
    }


    @ParameterizedTest(name = "solutionFirst#{index} ==> s=\"{0}\", numRows={1}, expect=\"{2}\"")
    @MethodSource("testCases")
    void solutionFirst(String s, int numRows, String expect) {
        assertEquals(expect, solution.solutionFirst(s, numRows));
    }
}