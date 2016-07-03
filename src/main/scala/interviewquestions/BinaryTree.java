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
        BinaryTreeNode root = new BinaryTreeNode(1);

        root.insertLeft(2);
        root.insertRight(3);

        root.left.insertLeft(4);

        BinaryTree tree = new BinaryTree(root);

        if (!tree.isSuperBalanced()) throw new RuntimeException("should be super");

        root.left.left.insertRight(5);

        tree = new BinaryTree(root);

        if (tree.isSuperBalanced()) throw new RuntimeException("should not be super");
    }

    public boolean isSuperBalanced() {
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
