package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrappingRainWater {
    static Stream<Arguments> provider() {
        return Stream.of(
//                Arguments.of(new int[]{5, 4, 1, 2}, 1),
                Arguments.of(new int[]{5, 2, 1, 2, 1, 5}, 14),
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, int expect) {
        assertEquals(expect, trap(input));
    }

    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int i = 0, sum = 0;
        while (i < height.length) {
            while (!s.empty() && height[i] > height[s.peek()]) {
                int bottomIndex = s.pop();
                if(s.empty())break;
                int boundedHeight = Math.min(height[s.peek()], height[i]) - height[bottomIndex];
                int distance = i - s.peek() - 1;
                sum += distance * boundedHeight;
            }
            s.push(i++);
        }
        return sum;
    }

    public int trapDP(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int[] lm = new int[height.length];
        int curMaxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            curMaxHeight = Math.max(height[i], curMaxHeight);
            lm[i] = curMaxHeight;
        }

        int[] rm = new int[height.length];
        curMaxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            curMaxHeight = Math.max(height[i], curMaxHeight);
            rm[i] = curMaxHeight;
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.max(0, Math.min(lm[i], rm[i]) - height[i]);
        }
        return sum;
    }

    public int trap1(int[] height) {
        int p = 0;
        int q = height.length - 1;
        int sum = 0;
        while (p < q) {
            int shorterSide = Math.min(height[p], height[q]);

            if (height[p] == shorterSide) {
                p++;
                while (height[p] < shorterSide && p < q) {
                    sum += shorterSide - height[p];
                    p++;
                }
            } else {
                q--;
                while (height[q] < shorterSide && p < q) {
                    sum += shorterSide - height[q];
                    q--;
                }
            }
        }
        return sum;
    }
}
