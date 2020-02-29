package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MmergeKLists {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new ListNode[]{
                        ListNode.makeList(new int[]{}),
                        ListNode.makeList(new int[]{}),
//                        ListNode.makeList(new int[]{2, 6})
                }, ListNode.makeList(new int[]{1, 1, 2, 3, 4, 4, 5, 6}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode[] l1, ListNode expected) {
        assertEquals(expected, mergeKLists(l1));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if(lists.length==1) return lists[0];
        int k = lists.length;
        MinPQ minPQ = new MinPQ(k);
        for (int i = 0; i < k; i++) {
            minPQ.insert(lists[i]);
        }
        ListNode minListNode = null;
        ListNode sentinel = new ListNode(0);
        ListNode p = sentinel;
        while (!minPQ.isEmpty()) {
            minListNode = minPQ.delMin();
            p.next = minListNode;
            p = p.next;
            minPQ.insert(minListNode.next);
//            if (minListNode.next != null) {
//                minPQ.insert(minListNode.next);
//            }
        }
        return sentinel.next;
    }

    class MinPQ {
        ListNode[] pq;
        int n = 0;
        public MinPQ(int maxN) {
            pq = new ListNode[maxN + 1];

        }

        public void insert(ListNode v) {
            if(v==null) return;
            pq[++n] = v;
            swim(n);
        }

        public ListNode delMin() {
            ListNode ret = pq[1];
            exch(1, n--);
            pq[n + 1] = null;
            sink(1);
            return ret;
        }

        private void swim(int k) {
            while (k > 1 && less(k, k / 2)) {
                exch(k, k / 2);
                k /= 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && less(j + 1, j)) j = j + 1;
                if (less(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        private boolean less(int i, int j) {
            return pq[i].val < pq[j].val;
        }

        private void exch(int i, int j) {
            ListNode t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }

        private boolean isEmpty() {
            return n == 0;
        }
    }
}
