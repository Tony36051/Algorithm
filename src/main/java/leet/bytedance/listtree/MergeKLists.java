package leet.bytedance.listtree;

import leet.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MergeKLists {
    static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(ListNode.makeList(new int[]{1, 2, 3, 4, 5}), ListNode.makeList(new int[]{5, 4, 3, 2, 1}))
        );
    }

//    @MethodSource("provider")
//    @ParameterizedTest
//    void pTest(ListNode l1, ListNode expected) {
//        assertEquals(expected, mergeKLists(l1));
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        return null;
//    }
}

