package leet.bytedance.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RestoreIpAddresses {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("010010", Arrays.asList(new String[]{"0.10.0.10","0.100.1.0"})),
                Arguments.of("25525511135", Arrays.asList(new String[]{"255.255.11.135", "255.255.111.35"}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String input, List<String> expect) {
        assertEquals(expect, restoreIpAddresses(input));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(3, s, new Stack<>(), res);  // split by 3 dot
        return res;
    }

    void backtrack(int n, String s, Stack<String> parts, List<String> res) {
        if (n == 0) {
            if (validPart(s)) {
                parts.push(s);
                res.add(parts.stream().collect(Collectors.joining(".")));
                parts.pop();
            }
            return;
        }
        for (int i = 1; i <= 3 && i < s.length(); i++) {
            String cur = s.substring(0, i);
            if (validPart(cur)) {
                parts.push(cur);
                String rest = s.substring(i);
                backtrack(n - 1, rest, parts, res);
                parts.pop();
            }
        }
    }

    boolean validPart(String s) {
        if (s.equals("0")) {
            return true;
        }
        if (s.charAt(0) == '0' || s.length()>3) {
            return false;
        }
        return Integer.valueOf(s) <= 255 ;
    }
}
