package leet.bytedance.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultiplyString {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("2", "3", "6"),
                Arguments.of("123", "456", "56088"),
                Arguments.of("99999", "99", "9899901")
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String s1, String s2, String product) {
        assertEquals(multiply(s1, s2), product);
    }

    public String multiply(String num1, String num2) {


        return "";
    }
}
