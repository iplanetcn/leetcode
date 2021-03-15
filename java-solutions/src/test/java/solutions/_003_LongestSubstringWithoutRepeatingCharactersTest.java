package solutions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _003_LongestSubstringWithoutRepeatingCharactersTest {
    private _003_LongestSubstringWithoutRepeatingCharacters  solutions;

    @BeforeEach
    void setUp() {
        solutions = new _003_LongestSubstringWithoutRepeatingCharacters();
    }

    @AfterEach
    void tearDown() {
        solutions = null;
    }

    @ParameterizedTest(name = "allSolutionsTest#{index} ==> input=\"{0}\", expect={1}")
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb,  1",
            "pwwkew, 3",
            "au, 2",
            ",0",
            "dvdf, 3",
            "ohvhjdml, 6",
            "bpoiexpqhmebhhu, 8",
            "ggububgvfk, 6"
    })
    void allSolutionsTest(String str, int answer) {
        Assertions.assertAll("allSolutionTest",
                ()->assertEquals(answer, solutions.first(str)),
                ()->assertEquals(answer, solutions.second(str)),
                ()->assertEquals(answer, solutions.third(str)),
                ()->assertEquals(answer, solutions.fourth(str)),
                ()->assertEquals(answer, solutions.fifth(str)),
                ()->assertEquals(answer, solutions.sixth(str))
        );
    }

    @ParameterizedTest(name = "solutionFirst#{index} ==> input=\"{0}\", expect={1}")
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb,  1",
            "pwwkew, 3",
            "au, 2",
            ",0",
            "dvdf, 3",
            "ohvhjdml, 6",
            "bpoiexpqhmebhhu, 8",
            "ggububgvfk, 6"
    })
    void solutionFirst(String str, int answer) {
        assertEquals(answer, solutions.second(str));
    }

    @ParameterizedTest(name = "solutionSecond#{index} ==> input=\"{0}\", expect={1}")
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb,  1",
            "pwwkew, 3",
            "au, 2",
            ",0",
            "dvdf, 3",
            "ohvhjdml, 6",
            "bpoiexpqhmebhhu, 8",
            "ggububgvfk, 6"
    })
    void solutionSecond(String str, int answer) {
        assertEquals(answer, solutions.second(str));
    }

    @ParameterizedTest(name = "solutionThird#{index} ==> input=\"{0}\", expect={1}")
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb,  1",
            "pwwkew, 3",
            "au, 2",
            ",0",
            "dvdf, 3",
            "ohvhjdml, 6",
            "bpoiexpqhmebhhu, 8",
            "ggububgvfk, 6"
    })
    void solutionThird(String str, int answer) {
        assertEquals(answer, solutions.third(str));
    }


    @ParameterizedTest(name = "solutionFourth#{index} ==> input=\"{0}\", expect={1}")
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb,  1",
            "pwwkew, 3",
            "au, 2",
            ",0",
            "dvdf, 3",
            "ohvhjdml, 6",
            "bpoiexpqhmebhhu, 8",
            "ggububgvfk, 6"
    })
    void solutionFourth(String str, int answer) {
        assertEquals(answer, solutions.fourth(str));
    }
}