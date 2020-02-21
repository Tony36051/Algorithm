package leet.bytedance.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PermutationSubstring {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("adc", "dcda", true),
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically", false)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String s1, String s2, boolean included) {
        assertEquals(included, checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] c = new int['z' - 'a' + 1];
        for (int i = 0; i < s1.length(); i++) {
            c[s1.charAt(i) - 'a']++;
            c[s2.charAt(i) - 'a']--;
        }
        if (isAllZero(c)) return true;
        for (int i = 0; i < l2 - l1; i++) {
            c[s2.charAt(i) - 'a']++;
            c[s2.charAt(l1+i) - 'a']--;
            if (isAllZero(c)) return true;
        }
        return false;
    }

    boolean isAllZero(int[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(String s1, boolean[] used, StringBuilder path, String s2) {
        //TLE
        if (path.length() == s1.length()) {
            System.out.println(path);
            return s2.contains(path);
        }
        for (int i = 0; i < s1.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                path.append(s1.charAt(i));
                if (s1.length() > s2.length() || s2.contains(path) == false) {
                    path.deleteCharAt(path.length() - 1);
                    used[i] = false;
                    continue;
                }
                if (dfs(s1, used, path, s2)) {
                    return true;
                }
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
        return false;
    }


}
