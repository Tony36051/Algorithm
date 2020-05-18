package leet.bytedance.listtree;

import leet.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LowestCommonAncestor {
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
        return Stream.of(
                Arguments.of(root, t5, t1, t3),
                Arguments.of(root, t5, t4, t5)
        );
    }

    @MethodSource("provider")
    @ParameterizedTest
    void pTest(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
        assertEquals(expected, lowestCommonAncestor(root, p, q));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pAncestors = new LinkedList<TreeNode>();
        dfs(root, pAncestors, p);
        LinkedList<TreeNode> qAncestors = new LinkedList<TreeNode>();
        dfs(root, qAncestors, q);

        TreeNode lca = root;
        final Iterator<TreeNode> pi = pAncestors.iterator();
        final Iterator<TreeNode> qi = qAncestors.iterator();
        while (pi.hasNext() && qi.hasNext()) {
            TreeNode pn = pi.next();
            TreeNode qn = qi.next();
            if (pn.val == qn.val) {
                lca = pn;
            }else{
                break;
            }
        }

        return lca;
    }

    boolean dfs(TreeNode root, LinkedList<TreeNode> ancestors, TreeNode target) {
        if (root == null) return false;

        ancestors.add(root);
        if (root.val == target.val) {
            return true;
        }
        boolean found = dfs(root.left, ancestors, target);
        if (found) {
            return true;
        }

        found = dfs(root.right, ancestors, target);
        if (found) {
            return true;
        }
        ancestors.removeLast();
        return false;
    }
}
