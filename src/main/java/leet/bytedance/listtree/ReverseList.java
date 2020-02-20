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
                Arguments.of(ListNode.makeList(new int[]{1, 2, 3, 4, 5}), ListNode.makeList(new int[]{5, 4, 3, 2, 1}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode output) {
        assertEquals(reverseListRecursively(l1), output);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode p; // delete p
        while (head.next != null) {
            // delete p
            p = head.next;
            head.next = p.next; // delete p, connect head to p.next
            // insert p after sentinel
            p.next = sentinel.next;
            sentinel.next = p;
        }
        return sentinel.next;
    }


    ListNode reverseListRecursively(ListNode head) {
        if (head == null ||head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursively(head.next);
        ListNode rest = newHead;
        while (rest.next != null) {
            rest = rest.next;
        }
        head.next = null;
        rest.next = head;
        return newHead;
    }
}

