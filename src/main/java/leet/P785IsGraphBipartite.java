package leet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P785IsGraphBipartite {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3},{0,2},{1,3},{0,2}}, true),
                Arguments.of(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}, false)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(int[][] input, boolean expect) {
        assertEquals(expect, isBipartite(input));
    }

    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] v = new int[m];
        int flag = 1;
        int newBegin = getUnvisited(v);
        while (newBegin >= 0) {
            if (!dfs(graph, v, newBegin, flag)) {
                return false;
            }
            newBegin = getUnvisited(v);
        }
        return true;
    }

    private boolean dfs(int[][] g, int[] v, int u, int flag) {
        if (v[u] == 0) {
            v[u] = flag;
            for (int i = 0; i < g[u].length; i++) {
                if( !dfs(g, v, g[u][i], -1*flag)){
                    return false;
                }
            }
        }else if(v[u]==flag){
            return true;
        }else {
            return false;
        }
        return true;
    }

    private int getUnvisited(int[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
