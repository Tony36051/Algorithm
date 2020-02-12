package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SearchInRotatedOrderedArray {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{0}, 0, 0),
                Arguments.of(new int[]{}, 0, -1),
                Arguments.of(new int[]{7, 0}, 2, -1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, int target, int expect) {
        assertEquals(expect, search(input, target));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[0]) {
                start = i;
                break;
            }
        }
        int leftIndex = Arrays.binarySearch(nums, 0, start, target);
        if (leftIndex >= 0) {
            return leftIndex;
        }
        int rightIndex = Arrays.binarySearch(nums, start, nums.length, target);
        if (rightIndex >= 0) {
            return rightIndex;
        }
        return -1;
    }
}
