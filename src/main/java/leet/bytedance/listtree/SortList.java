package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SortList {
    static Stream<Arguments> provider() {
        return Stream.of(
//                Arguments.of(ListNode.makeList(new int[]{4, 2}), ListNode.makeList(new int[]{2, 4})),
                Arguments.of(ListNode.makeList(new int[]{4, 2, 1, 3}), ListNode.makeList(new int[]{1, 2, 3, 4})),
                Arguments.of(ListNode.makeList(new int[]{-1, 5, 3, 4, 0}), ListNode.makeList(new int[]{-1, 0, 3, 4, 5})),
                Arguments.of(ListNode.makeList(new int[]{}), ListNode.makeList(new int[]{})),
                Arguments.of(ListNode.makeList(new int[]{-1}), ListNode.makeList(new int[]{-1})),
                Arguments.of(ListNode.makeList(new int[]{-1, 5}), ListNode.makeList(new int[]{-1, 5}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode expected) {
        assertEquals(expected, sortList(l1));
    }

    public ListNode sortList(ListNode head) {
        return mSort(head);
    }

    ListNode qSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (q.val < head.val) {
                p = p.next;
                int t = p.val;
                p.val = q.val;
                q.val = t;
            }
            q = q.next;
        }
        int t = p.val;
        p.val = head.val;
        head.val = t;

        ListNode right = qSort(p.next);
        p.next = null;
        head = qSort(head);
        p.next = right;
        return head;
    }

    ListNode mSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        // be careful while lise size == 2
        // q.next != null for odd; q.next.next != null for even
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        q = mSort(p.next);
        p.next = null;
        p = mSort(head);
        // merge two lists
        ListNode sentinel = new ListNode(0);
        ListNode np = sentinel;
        while (p != null && q != null) {
            if (p.val < q.val) {
                np.next = p;
                p = p.next;
            } else {
                np.next = q;
                q = q.next;
            }
            np = np.next;
        }
        np.next = p != null ? p : q;
        return sentinel.next;
    }

    public ListNode bottomUpMergeSort(ListNode head) {
        ListNode sentinel = new ListNode(0);
//        ListNode tail = sentinel;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        p = sentinel;
        for (int sortedLen = 1; sortedLen < n; sortedLen *= 2) {
            ListNode thisHead = head;
            ListNode nextHead = findNextHead(thisHead, sortedLen*2);
            while (true) {
                ListNode s1 = p;
                for (int i = 0; i < sortedLen; i++) {
                    p = p.next;
                }
                ListNode s2 = p;

            }


        }
        return sentinel.next;
    }

    private ListNode findNextHead(ListNode p, int step) {
        while (p != null && step!=0) {
            p=p.next;
            step--;
        }
        return p;
    }


    private ListNode merge(ListNode p, ListNode q, int len) {
        ListNode sentinel = new ListNode(0);
        ListNode tail = sentinel;
        int l1 = 0;
        int l2 = 0;
        while (p != null && q != null) {
            if (l1 < len && l2 < len) {
                if (p.val < q.val) {
                    tail.next = p;
                    p = p.next;
                    l1++;
                } else {
                    tail.next = q;
                    q = q.next;
                    l2++;
                }
                tail = tail.next;
            } else {
                tail.next = l1 < len ? p: q;
            }
        }
        return sentinel.next;
    }

}

