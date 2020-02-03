package leet.bytedance.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LongestCommonPrefixString {

    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"a"}, "a"),
                Arguments.of(new String[]{"action", "actor", "actual"}, "act")
        );
    }

    public String longestCommonPrefix(String[] strs) { // 一开始想用trie树，后来看了答案...
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int j = 0; j < strs[0].length(); j++) {
            final char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || c != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String[] input, String output) {
        assertEquals(longestCommonPrefix(input), output);
    }

}
