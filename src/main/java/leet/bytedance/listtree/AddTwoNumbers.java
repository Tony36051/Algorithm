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
                        ListNode.makeList(new int[]{0}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode l2, ListNode output) {
        assertEquals(addTwoNumbers(l1, l2), output);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resSentinel = new ListNode(0);
        while (l1 != null && l2 != null) {
            
        }
        return null;
    }
}

