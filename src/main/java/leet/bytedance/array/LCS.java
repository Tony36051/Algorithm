package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LCS {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, int expect) {
        assertEquals(expect, longestConsecutive(input));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 1;
        for (Integer a : set) {
            if (set.contains(a - 1)) {
                continue;
            }
            int curLen = 1;
            int nextNum = a + 1;
            while (set.contains(nextNum)) {
                curLen++;
                nextNum++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            if (map.containsKey(a)) {
                continue;
            }
            int left = a - 1;
            while (map.containsKey(left)) {
                map.put(left, a);
                left--;
            }
            int right = a + 1;
            while (map.containsKey(right)) {
                map.put(right, a);
                right++;
            }
            map.put(a, a);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer value : map.values()) {
            if (!countMap.containsKey(value)) {
                countMap.put(value, 1);
            } else {
                countMap.put(value, countMap.get(value) + 1);
            }
        }
        final int maxLen = countMap.values().stream().max(Integer::compareTo).get().intValue();
        return maxLen;
    }
}
