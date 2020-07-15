package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P315 {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 6, 1}, Arrays.asList(new Integer[]{2, 1, 1, 0})),
                Arguments.of(new int[]{26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32, 78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41},
                        Arrays.asList(new Integer[]{10, 27, 10, 35, 12, 22, 28, 8, 19, 2, 12, 2, 9, 6, 12, 5, 17, 9, 19, 12, 14, 6, 12, 5, 12, 3, 0, 10, 0, 7, 8, 4, 0, 0, 4, 3, 2, 0, 1, 0}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, List<Integer> expect) {
        assertEquals(expect, countSmaller(input));
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }
        List<Integer> sorted = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = firstAppearBinarySearch((ArrayList<Integer>) sorted, nums[i]);
            sorted.add(pos, nums[i]);
            ans.add(pos);
        }
        Collections.reverse(ans);
        return ans;
    }

    private int firstAppearBinarySearch(ArrayList<Integer> a, int target) {
        int l = 0;
        int r = a.size();
        while (l < r) {
            int m = l + (r - l) /2;
            if (a.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }


}
