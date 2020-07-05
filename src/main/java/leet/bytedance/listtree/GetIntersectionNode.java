package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetIntersectionNode {
    static Stream<Arguments> provider() {
        ListNode c1_o1 = ListNode.makeList(new int[]{2, 4});
        ListNode c1_i1 = ListNode.makeList(new int[]{0, 9, 1});
        c1_i1.next.next.next = c1_o1;
        ListNode c1_i2 = new ListNode(3);
        c1_i2.next = c1_o1;

        ListNode c2_o1 = ListNode.makeList(new int[]{8, 4, 5});
        ListNode c2_i1 = ListNode.makeList(new int[]{4, 1});
        c2_i1.next.next = c2_o1;
        ListNode c2_i2 = ListNode.makeList(new int[]{5, 0, 1});
        c2_i2.next.next.next = c2_o1;
        return Stream.of(
//                Arguments.of(c1_i1, c1_i2, c1_o1),
                Arguments.of(c2_i1, c2_i2, c2_o1)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode l2, ListNode expected) {
        assertEquals(expected, getIntersectionNode(l1, l2));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = count(headA);
        int len2 = count(headB);
        ListNode p = headA;
        ListNode q = headB;

        if (len1 > len2) {
            while (len1 > len2) {
                p = p.next;
                len1--;
            }
        } else {
            while (len2 > len1) {
                q = q.next;
                len2--;
            }
        }

        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
    }

    public int count(ListNode head) {
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        return n;
    }
}

