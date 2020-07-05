package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P378 {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}}, 8, 13),
                Arguments.of(new int[][]{
                        {1, 9},
                        {5, 11}}, 2, 5),
                Arguments.of(new int[][]{
                        {1, 9},
                        {5, 11}}, 3, 9),
                Arguments.of(new int[][]{
                        {1, 9},
                        {5, 11}}, 4, 11),
                Arguments.of(new int[][]{
                        {1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}}, 5, 5)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[][] input, int k, int expect) {
        assertEquals(expect, kthSmallest(input, k));
    }


    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = 0;
        }

        int r = 0;
        int smallest = Integer.MAX_VALUE;
        while (k > 0) {

            int rMin;
            if (idx[r] >= n) {
                r++;
                continue;
            } else {
                rMin = matrix[r][idx[r]];
            }

            int nRMin;
            if (r + 1 >= n || idx[r + 1] >= n) {
                nRMin = Integer.MAX_VALUE;
            } else {
                nRMin = matrix[r + 1][idx[r + 1]];
            }

            if (rMin < nRMin) {
                smallest = rMin;
                idx[r]++;
            } else {
                smallest = nRMin;
                idx[r + 1]++;
            }
            k--;
        }
        return smallest;
    }
}
