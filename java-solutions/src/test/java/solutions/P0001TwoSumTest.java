package solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * P0001TwoSumTest
 *
 * @author john
 * @since 2019-02-25
 */
class P0001TwoSumTest {
    private P0001TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new P0001TwoSum();
    }

    @AfterEach
    void tearDown() {
        twoSum = null;
    }

    /**
     * setup data for testing
     */
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.arguments(new int[]{1, 3, 5, 9, 13}, 18, new int[]{2, 4})
        );
    }


    @DisplayName("Solution First")
    @ParameterizedTest(name = "solutionFirst#{index} ==> nums={0}, target={1}, answer={2}")
    @MethodSource("argumentsProvider")
    void solutionFirst(int[] nums, int target, int[] answer) {
        assertArrayEquals(answer,  twoSum.solutionFirst(nums, target));
    }

    @DisplayName("Solution Second")
    @ParameterizedTest(name = "solutionSecond#{index} ==> nums={0}, target={1}, answer={2}")
    @MethodSource("argumentsProvider")
    void solutionSecond(int[] nums, int target, int[] answer) {
        assertArrayEquals(answer, twoSum.solutionSecond(nums, target));
    }

    @ParameterizedTest(name = "solutionThird#{index} ==> nums={0}, target={1}, answer={2}")
    @MethodSource("argumentsProvider")
    void solutionThird(int[] nums, int target, int[] answer) {
        assertArrayEquals(answer, twoSum.solutionThird(nums, target));
    }
}
