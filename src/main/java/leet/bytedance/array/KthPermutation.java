package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class KthPermutation {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(1, 1, "1"),
                Arguments.of(2, 2, "21"),
                Arguments.of(3, 3, "213"),
                Arguments.of(4, 9, "2314")

        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int n, int k, String expect) {
        assertEquals(expect, getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        int f[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        List<Integer> restNums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            restNums.add(i + 1);
        }
        StringBuilder res = new StringBuilder();
        k--;
        while (n-- > 0) {
            int q = k / f[n];
            int r = k - q * f[n];
            res.append(restNums.get(q));
            restNums.remove(q);
            k = r;
        }

        return res.toString();
    }

}
