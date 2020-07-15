package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class P350IntersectionOfTwoArraysII {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{1,2,2,1}, new int[]{2,2}, new int[]{2,2}),
                Arguments.of(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{4,9})
//                ,Arguments.of(2, 1118596, 1118596, new int[]{3,4,5,6})
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] nums1, int[] nums2, int[] expect) {
        int[] ret = intersect(nums1, nums2);
        Arrays.sort(ret);
        assertArrayEquals(expect, ret);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer numCnt = map.getOrDefault(i, 0);
            map.put(i, numCnt + 1);
        }
        int[] intersections = new int[nums1.length];
        int idx = 0;
        for (int num : nums2) {
            Integer numCnt = map.getOrDefault(num,0);
            if (numCnt > 0) {
                intersections[idx++] = num;
                numCnt--;
                if (numCnt == 0) {
                    map.remove(num);
                }else{
                    map.put(num, numCnt);
                }
            }
        }
        return Arrays.copyOfRange(intersections, 0, idx);
    }
}
