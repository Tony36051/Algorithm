package leet.bytedance.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LongestSubstring {


    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("", 0),
                Arguments.of("dvdf", 3)
        );
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                maxLength = set.size() > maxLength ? set.size() : maxLength;
                right++;
            }
        }
        return maxLength;
    }


    @MethodSource("stringAndIntProvider")
    @ParameterizedTest
    void pTest(String s, int length) {
        assertEquals(length, lengthOfLongestSubstring(s));
    }

}
