package leet.common;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P208ImplementTriePrefixTree {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(Arrays.asList("looked", "just", "like", "her", "brother"), "jesslookedjustliketimherbrother", 7)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String[] dictionary, String sentence, int expect) {
        assertEquals(expect, respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {
        

        return 0;
    }
}
