package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P32 {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("(()", 2),
                Arguments.of(")()())", 4),
                Arguments.of("", 0),
                Arguments.of("()()))))()()(", 4),
                Arguments.of(")()())", 4),
                Arguments.of(")", 0),
                Arguments.of("(", 0),
                Arguments.of("()(()", 2),
                Arguments.of("()(())", 6),
                Arguments.of("()()", 4),
                Arguments.of("()", 2),
                Arguments.of(")()(((())))(",10),
                Arguments.of(")()(",2)

        );
    }

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || i == 0) {
                dp[i] = 0;
            } else {
                int leftPos = i - dp[i - 1] - 1;
                if (leftPos >= 0 && s.charAt(leftPos) == '(') {
                    dp[i] = 2 + dp[i - 1];
                    if (leftPos - 1 >= 0) {
                        dp[i] += dp[leftPos - 1];
                    }
                } else {
                    dp[i] = 0;
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
            }
        }
        return maxLength;
    }

    public int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength=0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }else{ // c==')'
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String input, int expect) {
        assertEquals(expect, longestValidParenthesesStack(input));
    }
}
