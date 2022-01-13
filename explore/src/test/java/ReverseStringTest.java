import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    @Test
    void testReverseString() {
        char[] chars = "gnirtS".toCharArray();
        String expect = "String";
        new ReverseString().reverseString(chars);
        assertEquals(expect, new String(chars));
    }
}