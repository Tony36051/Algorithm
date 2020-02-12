package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindKthLargest {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.of(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, int k, int expect) {
        assertEquals(expect, findKthLargest(input, k));
    }

    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length-1, k-1);
    }

    int select(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = right;
        pivotIndex = partition(nums, left, right, pivotIndex);
        if (k == pivotIndex) {
            return nums[pivotIndex];
        } else if (k<pivotIndex) {
            return select(nums, left, pivotIndex - 1, k);
        }else{
            return select(nums, pivotIndex + 1, right, k);
        }
    }

    int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivotValue) {
                swap(nums, i, storeIndex++);
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
