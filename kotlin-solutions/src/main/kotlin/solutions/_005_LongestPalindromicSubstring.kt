package solutions

import java.util.regex.Pattern

class _005_LongestPalindromicSubstring {
    fun solution(s: String): String {
        if (s.isEmpty() || s.length > 1000) {
            throw RuntimeException("invalid s")
        }

        if (!Pattern.matches("^[a-zA-Z0-9]*$", s)) {
            throw RuntimeException("invalid s")
        }

        val rs = s.reversed()
        var result = s.substring(IntRange(0, 0))

        for (i in s.indices) {
            var end = i + 1
            while (end < s.length) {
                val sub = s.substring(IntRange(i, end))
                if (rs.contains(sub) && sub.length > result.length) {
                    if (sub == sub.reversed()) {
                        result = sub
                    }
                } else {
                    break
                }
                end++
            }
        }

        return result
    }
}

fun main() {
    println(_005_LongestPalindromicSubstring().solution("Hello"))
}