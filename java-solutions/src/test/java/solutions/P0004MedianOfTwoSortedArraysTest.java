package solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P0004MedianOfTwoSortedArraysTest {
    private P0004MedianOfTwoSortedArrays solutions;

    @BeforeEach
    void setUp() {
        solutions = new P0004MedianOfTwoSortedArrays();
    }

    @AfterEach
    void tearDown() {
        solutions = null;
    }

    @ParameterizedTest(name = "solution#{index} ==> input=\"{0} {1}\", expect={2}")
    @MethodSource("generateData")
    void solution(int[] num1, int[] num2, double answer) {
        assertEquals(answer, solutions.findMedianSortedArrays(num1, num2));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
          Arguments.of(new int[]{1, 3}, new int[]{2}, 2),
          Arguments.of(new int[]{1, 2}, new int[]{3,4},2.5)
        );
    }
}