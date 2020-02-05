package leet.bytedance.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SimplifyPath {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("/../", "/"),
                Arguments.of("///TJbrd/owxdG//", "/TJbrd/owxdG"),
                Arguments.of("/home/", "/home"),
                Arguments.of("/../", "/"),
                Arguments.of("/home//foo/", "/home/foo"),
                Arguments.of("/a/./b/../../c/", "/c"),
                Arguments.of("/a/../../b/../c//.//", "/c"),
                Arguments.of("/a//b////c/d//././/..", "/a/b/c")
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String input, String expect) {
        assertEquals(expect, simplifyPath(input));
    }

    public String simplifyPath(String path) {
        String[] ss = path.split("/+");
        List<String> res = new LinkedList<>();
        for (int i = 1; i < ss.length; i++) {
            switch (ss[i]) {
                case ".":
                    break;
                case "..":
                    if (!res.isEmpty()) {
                        res.remove(res.size() - 1);
                    }
                    break;
                default:
                    res.add(ss[i]);
            }
        }
        return "/" + String.join("/", res);
    }
}
