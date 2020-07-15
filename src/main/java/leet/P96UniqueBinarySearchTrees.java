package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P96UniqueBinarySearchTrees {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(3, 5)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int input, int expect) {
        assertEquals(expect, numTrees(input));
    }

    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }
}
