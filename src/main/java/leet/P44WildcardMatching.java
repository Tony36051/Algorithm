package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P44WildcardMatching {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("aa","a", false),
                Arguments.of("aa","*", true),
                Arguments.of("cb","?a", false),
                Arguments.of("adceb","*a*b", true),
                Arguments.of("acdcb","a*c?b", false)
        );
    }
    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String s, String p, boolean expect) {
        assertEquals(expect, isMatch(s,p));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length()+1;
        int n = p.length()+1;
        boolean[][] dp = new boolean[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = false; // 空模式p，无法匹配任何串s，空s除外
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = isAllStar(p,i);
        }
        dp[0][0] = true;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char pc = p.charAt(j-1);
                char sc = s.charAt(i - 1);
                if (pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else{
                    dp[i][j] = (pc == sc) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    private boolean isAllStar(String p, int j) {
        boolean flag = true;
        for (int i = 0; i < j; i++) {
            if(p.charAt(i)!='*'){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
