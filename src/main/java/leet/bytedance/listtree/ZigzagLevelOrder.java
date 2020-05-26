package leet.bytedance.listtree;

import leet.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ZigzagLevelOrder {
    static Stream<Arguments> provider() {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode root = t3;
        root.left = t5;
        root.right = t1;
        t5.left = t6;
        t5.right = t2;
        t2.left = t7;
        t2.right = t4;
        t1.left = t0;
        t1.right = t8;
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(new Integer[]{3}),
                Arrays.asList(new Integer[]{1, 5}),
                Arrays.asList(new Integer[]{6, 2, 0, 8}),
                Arrays.asList(new Integer[]{4, 7})
        );
        return Stream.of(
                Arguments.of(root, expected)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(TreeNode root, List<List<Integer>> expected) {
        assertEquals(expected, zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left2right=true;
        TreeNode curNode;
        while (!queue.isEmpty()) {
            int thisLayerSize = queue.size();
            List<Integer> thisLayerNode = new LinkedList<Integer>();
            for (int i = 0; i < thisLayerSize; i++) {
                curNode = queue.poll();
                if(curNode.left!=null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                if (left2right) {
                    thisLayerNode.add(curNode.val);
                }else{
                    thisLayerNode.add(0, curNode.val);
                }
            }
            left2right = !left2right;
            result.add(thisLayerNode);
        }
        return result;
    }


}
