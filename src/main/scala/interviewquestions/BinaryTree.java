package interviewquestions;

public class BinaryTree {

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
        BinaryTree tree = new BinaryTree();
        BinaryTreeNode node1 = new BinaryTreeNode(1);

        node1.insertLeft(2);
        node1.insertRight(3);

        node1.left.insertLeft(4);
        node1.left.left.insertRight(5);

        System.out.println("isSuperBalanced: " + tree.isSuperBalanced(node1));
    }

    public boolean isSuperBalanced(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode.left == null && binaryTreeNode.right != null && (binaryTreeNode.right.right != null || binaryTreeNode.right.left != null)) {
            return false;
        }
        if (binaryTreeNode.right == null && binaryTreeNode.left != null && (binaryTreeNode.left.right != null || binaryTreeNode.left.left != null)) {
            return false;
        }
        if (binaryTreeNode.left != null) return isSuperBalanced(binaryTreeNode.left);
        if (binaryTreeNode.right != null) return isSuperBalanced(binaryTreeNode.right);

        return true;
    }
}
