package leet.bytedance.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MaxAreaOfIsland {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 1, 0},
                        {1, 0, 0},
                        {0, 1, 1},
                        {0, 0, 0}}, 3),
                Arguments.of(new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}, 6),
                Arguments.of(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}, 0)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[][] input, int expect) {
        assertEquals(expect, maxAreaOfIsland(input));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int l1 = grid.length; // l1管第一坐标，l2管第二坐标
        int l2 = grid[0].length;
        boolean[][] used = new boolean[l1][l2];

        int maxSum = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (used[i][j] || grid[i][j]==0) {
                    continue;
                }
                Integer sum = dfs(grid, used, i, j);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    int dfs(int[][] grid, boolean[][] used, int x, int y) {
        int l1 = grid.length;
        int l2 = grid[0].length;
        if (x < 0 || x >= l1 || y < 0 || y >= l2) {
            return 0;
        }
        if (used[x][y]) {
            return 0;
        }
        if (grid[x][y] == 0) {
            used[x][y] = true;
            return 0;
        }
        used[x][y] = true;
        int sum  = 0;
        if (grid[x][y] == 1) {
            sum++;
        }
        sum += dfs(grid, used, x-1, y);
        sum += dfs(grid, used, x+1, y);
        sum += dfs(grid, used, x, y-1);
        sum += dfs(grid, used, x, y+1);
        return sum;
    }

}
