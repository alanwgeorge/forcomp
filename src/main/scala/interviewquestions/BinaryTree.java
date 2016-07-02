package interviewquestions;

import java.util.Stack;

public class BinaryTree {
    private Stack<BinaryTreeNode> stack = new Stack<>();

    public BinaryTree() {

    }

    public BinaryTree(BinaryTreeNode root) {
        BinaryTreeNode node = root.left;

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public BinaryTreeNode next() {
        BinaryTreeNode node = stack.pop();

        if (node.right != null) {
            BinaryTreeNode addNode = node.right;
            while (addNode != null) {
                stack.add(addNode);
                addNode = addNode.left;
            }
        }

        return node;
    }

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
        BinaryTreeNode root = new BinaryTreeNode(1);

        root.insertLeft(2);
        root.insertRight(3);

        root.left.insertLeft(4);
//        root.left.left.insertRight(5);
//
//        System.out.println("isSuperBalanced: " + tree.isSuperBalanced(root));

        BinaryTree tree2 = new BinaryTree(root);
        System.out.println("isSuperBalanced2: " + tree2.isSuperBalanced2());

    }

    public boolean isSuperBalanced(BinaryTreeNode tree) {
        if (tree.left == null && tree.right != null && (tree.right.right != null || tree.right.left != null)) {
            return false;
        }
        if (tree.right == null && tree.left != null && (tree.left.right != null || tree.left.left != null)) {
            return false;
        }
        if (tree.left != null) return isSuperBalanced(tree.left);
        if (tree.right != null) return isSuperBalanced(tree.right);

        return true;
    }

    public boolean isSuperBalanced2() {
        while (hasNext()) {
            BinaryTreeNode node = next();
            if (node.left == null && node.right != null && (node.right.right != null || node.right.left != null)) {
                return false;
            }
            if (node.right == null && node.left != null && (node.left.right != null || node.left.left != null)) {
                return false;
            }
        }

        return true;
    }
}
