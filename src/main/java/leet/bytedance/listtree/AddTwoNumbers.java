package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddTwoNumbers {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(ListNode.makeList(new int[]{2, 4, 3}), ListNode.makeList(new int[]{5, 6, 4}),
                        ListNode.makeList(new int[]{7, 0, 8})),
                Arguments.of(ListNode.makeList(new int[]{2, 4, 3}), ListNode.makeList(new int[]{1, 1}),
                        ListNode.makeList(new int[]{3, 5, 3})),
                Arguments.of(ListNode.makeList(new int[]{0}), ListNode.makeList(new int[]{5, 6, 4}),
                        ListNode.makeList(new int[]{5, 6, 4})),
                Arguments.of(ListNode.makeList(new int[]{5, 6, 4}), ListNode.makeList(new int[]{0}),
                        ListNode.makeList(new int[]{5, 6, 4})),
                Arguments.of(ListNode.makeList(new int[]{0}), ListNode.makeList(new int[]{0}),
                        ListNode.makeList(new int[]{0})),
                Arguments.of(ListNode.makeList(new int[]{5}), ListNode.makeList(new int[]{5}),
                        ListNode.makeList(new int[]{0, 1}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode l2, ListNode expected) {
        assertEquals(expected, addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode resSentinel = new ListNode(0);
        ListNode p = resSentinel;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rest = l1 != null ? l1 : l2;
        while (rest != null) {
            sum = rest.val + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            rest = rest.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return resSentinel.next;
    }
}

