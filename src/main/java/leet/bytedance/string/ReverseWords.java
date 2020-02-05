package leet.bytedance.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReverseWords {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world!  ", "world! hello"),
                Arguments.of("a good   example", "example good a")
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String input, String expect) {
        assertEquals(expect, reverseWords(input));
    }

    //先整个字符串整体翻转一次，然后再分别翻转每一个单词, Java的String不可修改对象，原地修改算法没什么意义
    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    public String reverseWords(String s) {
        Pattern pattern = Pattern.compile("\\s+");
        final String[] ss = pattern.split(s.trim());
        String tmp;
        for (int i = 0; i < ss.length/2; i++) {
            tmp = ss[i];
            ss[i] = ss[ss.length-1-i];
            ss[ss.length-1-i] = tmp;
        }
        return Arrays.stream(ss).collect(Collectors.joining(" "));
    }
}
