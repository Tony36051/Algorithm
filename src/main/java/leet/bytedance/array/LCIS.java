package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LCIS {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 4, 7}, 3),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 1)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, int expect) {
        assertEquals(expect, findLengthOfLCIS(input));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int maxLen = 1;
        int curLen = 1;
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] < nums[j]) {
                curLen++;
            } else {
                curLen = 1;
            }
            maxLen = Math.max(curLen, maxLen);
            i++;
            j++;
        }
        return maxLen;
    }
}
