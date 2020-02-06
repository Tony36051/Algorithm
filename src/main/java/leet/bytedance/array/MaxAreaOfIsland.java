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


        return 0;
    }

    void dfs(int[][] grid, boolean[][] used, int x, int y, int sum) {
        int yLength = grid.length;
        int xLength = grid[0].length;
        int x1 = x - 1 > 0 ? x - 1 : 0;
        int x2 = x + 1 < xLength - 1 ? x + 1 : xLength - 1;
        int y1 = y - 1 > 0 ? y - 1 : 0;
        int y2 = y + 1 < yLength - 1 ? y + 1 : yLength - 1;
        if (used[x1][y] && used[x2][y] && used[x][y1] && used[x][y2]) {

        }

    }
}
