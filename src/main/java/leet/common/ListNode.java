package leet.common;

/**
 * Definition for singly-linked list.
 */
pubclass ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode p = this;
        ListNode q = (ListNode) o;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        if (p != null || q != null) {
            return false;
        }
        return true;
    }

}
