/**
 * @URL: https://leetcode.com/problems/leaf-similar-trees/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // return leafSimilar1(root1, root2);
        return leafSimilar2(root1, root2);
    }

    /**
     * Generate leaf sequence of both trees and compare them.
     *
     * Time : (m + n)
     * Space: (⌈m / 2⌉ + ⌈n / 2⌉)
     */
    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();
 
        generateLeafSequence(root1, ls1);
        generateLeafSequence(root2, ls2);

        int len = ls1.size();
        if (len != ls2.size()) {
            return false;
        }

        for (int i = 0; i < len; ++i) {
            if ((int) ls1.get(i) != ls2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private int index;
    private List<Integer> ls;

    /**
     * In this approach we don't need to store the leaf sequence of both trees.
     * Generate leaf sequence of 1st tree.
     * While generating the leaf sequence of 2nd tree, keep comparing it with the leaf sequence of 1st tree.
     * 
     * Time : (m + n)
     * Space: (⌈m / 2⌉)
     */
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        ls = new ArrayList<>();
        generateLeafSequence(root1, ls);

        index = 0;
        return checkHasLeafSequence(root2) && index == ls.size();
    }

    private void generateLeafSequence(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        generateLeafSequence(root.left, list);
        generateLeafSequence(root.right, list);
    }

    private boolean checkHasLeafSequence(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return index < ls.size() && root.val == ls.get(index++);
        }

        return checkHasLeafSequence(root.left) && checkHasLeafSequence(root.right);
    }
}