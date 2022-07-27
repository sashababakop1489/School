package com.knubisoft.base.trees;

import java.util.*;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        return node1.equals(node2);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> ans= new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(node);
        TreeNode temp;
        TreeNode parentNode;
        ans.add(node.val);
        while (!deque.isEmpty()) {
            temp = deque.pop();
            if (temp.right != null) {
                parentNode = temp;
                deque.addLast(temp.right);
                ans.add(ans.indexOf(parentNode.val) + 1, temp.right.val);
            }
            if (temp.left != null) {
                parentNode = temp;
                deque.addFirst(temp.left);
                ans.add(ans.indexOf(parentNode.val), temp.left.val);
            }
        }
        return ans;
    }

    @Override
    public boolean isSymmetric(TreeNode node) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        deque.addFirst(leftNode);
        deque.addLast(rightNode);
        while (!deque.isEmpty()) {
            leftNode = deque.pollFirst();
            rightNode = deque.pollLast();

            if (leftNode.val != rightNode.val)
                return false;

            if (rightNode.right != null)
                deque.addLast(rightNode.right);

            if (leftNode.left != null)
                deque.addFirst(leftNode.left);
        }
        return true;
    }

    @Override
    public int maxDepth(TreeNode node) {
        if(node == null){
            return 0;
        }
        int nLeft = maxDepth(node.left);
        int nRight = maxDepth(node.right);
        return (nLeft > nRight) ? nLeft + 1 : nRight + 1;
    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return targetSum == node.val;
        return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
    };

    @Override
    public TreeNode invertTree(TreeNode node) {
        if (node == null)
            return node;

        /* recursive calls */
        TreeNode leftNode = invertTree(node.left);
        TreeNode rightNode = invertTree(node.right);

        /* swap the left and right pointers */
        node.left = rightNode;
        node.right = leftNode;

        return node;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {
            if(node == null)
                return 0;
            if(node.left != null && node.left.left == null && node.left.right == null)
                return node.left.val + sumOfLeftLeaves(node.left) + sumOfLeftLeaves(node.right);
            return sumOfLeftLeaves(node.left) + sumOfLeftLeaves(node.right);
        }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        TreeNode result ;
        if(node1 == null && node2 == null){
            return null ;
        }
        if(node1 == null && node2 != null){
            return node2 ;
        }
        if(node1 != null && node2 == null){
            return node1 ;
        }

        result = new TreeNode(node1.val + node2.val) ;
        result.left = mergeTrees(node1.left, node2.left) ;
        result.right = mergeTrees(node1.right, node2.right) ;

        return result ;
    }
}
