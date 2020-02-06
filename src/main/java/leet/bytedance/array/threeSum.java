package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class threeSum {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2)))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, List<List<Integer>> expect) {
        assertEquals(expect, threeSum(input));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //离开初始值
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) continue; // 离开初始值，也即离开前一位
                for (int k = nums.length - 1; k >= 0; k++) {
                    
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //离开初始值
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) continue; // 离开初始值，也即离开前一位
                int k = Arrays.binarySearch(nums, j + 1, nums.length, 0 - nums[i] - nums[j]);
                if (k > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return res;
    }
}
