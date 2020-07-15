package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P120Triangle {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        Arrays.asList(2),
                        Arrays.asList(3, 4),
                        Arrays.asList(6, 5, 7),
                        Arrays.asList(4, 1, 8, 3)
                ), 11)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(List<List<Integer>> input, int expect) {
        assertEquals(expect, minimumTotal(input));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int t = triangle.get(i).get(j);
                if (j == dp.size()) {
                    dp.add(dp.get(j - 1) + t);
                } else if (j == 0) {
                    dp.set(j, dp.get(j) + t);
                } else {
                    dp.set(j, Math.min(dp.get(j - 1), dp.get(j)) + t);
                }
            }
        }
        return dp.stream().min(Integer::compareTo).get().intValue();
    }
}
