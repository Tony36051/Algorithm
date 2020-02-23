package leet.common;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode makeList(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        ListNode p = sentinel;
        for (int i : nums) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return sentinel.next;
    }

    public static ListNode makeLinkedListWithCycle(int[] nums, int pos) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        ListNode head = makeList(nums);
        if (pos >= 0) {
            ListNode cycleStart = null;

            ListNode p = head;
            while (p.next != null) {
                if (pos-- == 0) {
                    cycleStart = p;
                }
                p = p.next;
            }
            p.next = cycleStart;
        }
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.toString().equals(o.toString());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        Set<ListNode> refSef = new HashSet<>();
        while (p!=null) {
            if (refSef.contains(p.next)) {
                sb.append(p.val + " ");
                break;
            }else{
                refSef.add(p);
            }
            sb.append(p.val + " ");
            p = p.next;
        }
        return sb.toString();
    }


}
