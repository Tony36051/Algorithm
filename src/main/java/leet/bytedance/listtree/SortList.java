package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SortList {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(ListNode.makeList(new int[]{1, 2, 3, 4, 5}), ListNode.makeList(new int[]{5, 4, 3, 2, 1}))
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(ListNode l1, ListNode expected) {
        assertEquals(expected, sortList(l1));
    }

    public ListNode sortList(ListNode head) {
        ListNode sentinel = new ListNode(0);



        return sentinel.next;
    }
}

