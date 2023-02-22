package solutions;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import solutions.P0002AddTwoNumbers.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static solutions.P0002AddTwoNumbers.Utils.toCommonList;
import static solutions.P0002AddTwoNumbers.Utils.toListNode;

/**
 * P0002AddTwoNumbersTest
 *
 * @author john
 * @since 2019-02-26
 */
class P0002AddTwoNumbersTest {
    private P0002AddTwoNumbers addTwoNumbers;


    @BeforeEach
    void setUp() {
        addTwoNumbers = new P0002AddTwoNumbers();
    }

    /**
     * prepare testing data
     */
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.arguments(
                        toListNode(new ArrayList<>(Arrays.asList(2, 4, 3)), null),
                        toListNode(new ArrayList<>(Arrays.asList(5, 6, 4)), null),
                        toListNode(new ArrayList<>(Arrays.asList(7, 0, 8)), null)
                ),
                Arguments.arguments(
                        toListNode(new ArrayList<>(Collections.singletonList(5)), null),
                        toListNode(new ArrayList<>(Collections.singletonList(5)), null),
                        toListNode(new ArrayList<>(Arrays.asList(0, 1)), null)
                ),
                Arguments.arguments(
                        toListNode(new ArrayList<>(Arrays.asList(1, 8)), null),
                        toListNode(new ArrayList<>(Collections.singletonList(0)), null),
                        toListNode(new ArrayList<>(Arrays.asList(1, 8)), null)
                ),
                Arguments.arguments(
                        toListNode(new ArrayList<>(Collections.singletonList(0)), null),
                        toListNode(new ArrayList<>(Arrays.asList(1, 8)), null),
                        toListNode(new ArrayList<>(Arrays.asList(1, 8)), null)
                ),
                Arguments.arguments(
                        toListNode(new ArrayList<>(Collections.singletonList(9)), null),
                        toListNode(new ArrayList<>(Arrays.asList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)), null),
                        toListNode(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)), null)

                )
        );
    }

    @AfterEach
    void tearDown() {
        addTwoNumbers = null;
    }

    @DisplayName("Solution First")
    @ParameterizedTest(name = "solutionFirst#{index} ==> one={0}, another={1}, answer={2}")
    @MethodSource("argumentsProvider")
    void solutionFirst(ListNode one, ListNode another, ListNode answer) {
        ListNode result = addTwoNumbers.solutionFirst(one, another);
        assertArrayEquals(
                toCommonList(result, new ArrayList<>()).toArray(),
                toCommonList(answer, new ArrayList<>()).toArray()
        );
    }

    @DisplayName("Solution Second")
    @ParameterizedTest(name = "solutionSecond#{index} ==> one={0}, another={1}, answer={2}")
    @MethodSource("argumentsProvider")
    void solutionSecond(ListNode one, ListNode another, ListNode answer) {
        ListNode result = addTwoNumbers.solutionSecond(one, another);
        assertArrayEquals(
                toCommonList(result, new ArrayList<>()).toArray(),
                toCommonList(answer, new ArrayList<>()).toArray()
        );
    }


    @DisplayName("Solution Third")
    @ParameterizedTest(name = "solutionThird#{index} ==> one={0}, another={1}, answer={2}")
    @MethodSource("argumentsProvider")
    void solutionThird(ListNode one, ListNode another, ListNode answer) {
        ListNode result = addTwoNumbers.solutionThird(one, another);
        assertArrayEquals(
                toCommonList(result, new ArrayList<>()).toArray(),
                toCommonList(answer, new ArrayList<>()).toArray()
        );
    }
}
