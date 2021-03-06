package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DetectCycle {
    static Stream<Arguments> provider() {
        ListNode l1 = ListNode.makeLinkedListWithCycle(new int[]{3,2,0,-4},1);
        ListNode l2 = l1.next;
        return Stream.of(
                Arguments.of(l1,l2)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode expected) {
        assertEquals(expected, detectCycle(l1));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = slow;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        while (meet != head) {
            meet = meet.next;
            head = head.next;
        }
        return meet;
    }


}

