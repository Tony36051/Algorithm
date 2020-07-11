package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class M1611DivingBoardLcci {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(1, 2, 3, new int[]{3, 4, 5, 6})
//                ,Arguments.of(2, 1118596, 1118596, new int[]{3,4,5,6})
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int shorter, int longer, int k, int[] expect) {
        assertArrayEquals(expect, divingBoard(shorter, longer, k));
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            res.add(shorter * i + longer * (k - i));
        }
        int[] ret = new int[res.size()];
        int idx = 0;
        for (Integer re : res) {
            ret[idx++] = re;
        }
        Arrays.sort(ret);
        return ret;
    }
}
