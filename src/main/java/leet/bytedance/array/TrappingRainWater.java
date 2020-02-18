package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrappingRainWater {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[] input, List<List<Integer>> expect) {
        assertEquals(expect, trap(input));
    }

    public int trap(int[] height) {

        return 0;
    }
}
