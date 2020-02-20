package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReverseList {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(ListNode.makeList(new int[]{1, 2, 4}), ListNode.makeList(new int[]{1, 3, 4}),
                        ListNode.makeList(new int[]{1, 1, 2, 3, 4, 4}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode l2, ListNode output) {
        assertEquals(mergeTwoLists(l1, l2), output);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode p =  sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        while (l1 != null) {
            p.next = l1;
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = l2;
            p = p.next;
            l2 = l2.next;
        }
        return sentinel.next;
    }
}

