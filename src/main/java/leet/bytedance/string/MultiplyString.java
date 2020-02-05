package leet.bytedance.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultiplyString {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("23", "56", "1288"),
                Arguments.of("123456789", "987654321", "121932631112635269"),
                Arguments.of("123", "2", "246"),
                Arguments.of("123", "0", "0"),
                Arguments.of("99999", "99", "9899901")
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(String s1, String s2, String product) {
        assertEquals(product, multiply(s1, s2));
    }

    public String multiply(String num1, String num2) {
        int[] a = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                a[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder(a.length);
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] >= 10) {
                a[i - 1] += a[i] / 10;
                a[i] %= 10;
            }
        }
        int idx = 0;
        while (idx < a.length && a[idx] == 0) {
            idx++;
        }
        if (idx == a.length) {
            return "0";
        }
        for (; idx < a.length; idx++) {
            sb.append(a[idx]);
        }
        return sb.toString();
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String[] reversedSums = new String[num1.length()];
        int curSum;
        int unit;
        int carry;
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < num1.length() - 1 - i; k++) {
                sb.append('0');
            }
            carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                curSum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                unit = curSum % 10;
                carry = curSum / 10;
                sb.append(unit);
            }
            if (carry > 0) {
                sb.append(carry);
            }
            reversedSums[i] = sb.toString();
        }
        StringBuilder res = new StringBuilder();

        final Integer maxLength = Arrays.stream(reversedSums).map(t -> t.length()).max(Integer::compareTo).get();
        carry = 0;
        for (int i = 0; i < maxLength; i++) {
            curSum = 0;
            for (int j = 0; j < reversedSums.length; j++) {
                curSum += (i < reversedSums[j].length() ? reversedSums[j].charAt(i) : '0') - '0';
            }
            curSum += carry;
            unit = curSum % 10;
            carry = curSum / 10;
            res.append(unit);
        }
        if (carry > 0) {
            res.append(new StringBuilder(String.valueOf(carry)).reverse().toString());
        }
        return res.reverse().toString();
    }
}
