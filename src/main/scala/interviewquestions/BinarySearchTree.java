package interviewquestions;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class BinarySearchTree {
    private Node root = null;

    @SuppressWarnings("WeakerAccess")
    public BinarySearchTree() {
    }

    @SuppressWarnings("WeakerAccess")
    public BinarySearchTree(Node root) {
        this.root = root;
    }

    @SuppressWarnings("WeakerAccess")
    public void put(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node node = root;

            while (true) {
                if (node.value == value) return;
                if (value < node.value) {
                    if (node.left == null) {
                        node.left = new Node(value);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new Node(value);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }
        }
    }

    @SuppressWarnings("WeakerAccess")
    public List<Object> foreach(Function<Integer, Object> f) {
        List<Object> results = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.empty()) {
            node = stack.pop();
            results.add(f.apply(node.value));

            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return results;
    }

    @SuppressWarnings("WeakerAccess")
    public int max() {
        if (root == null) throw new IllegalStateException("root is null");

        Node node = root;
        int max;

        while (true) {
            max = node.value;
            if (node.right != null) {
                node = node.right;
            } else {
                break;
            }
        }
        return max;
    }

    @SuppressWarnings("WeakerAccess")
    public int secodHighestMax() {
        if (root == null) throw new IllegalStateException("root is null");

        Node node = root;
        int max;

        while (true) {
            max = node.value;
            if (node.right != null) {
                node = node.right;
            } else {
                if (node.left != null) {
                    BinarySearchTree leftTree = new BinarySearchTree(node.left);
                    max = leftTree.max();
                }
                break;
            }
        }
        return max;
    }

    @SuppressWarnings("WeakerAccess")
    public int min() {
        if (root == null) throw new IllegalStateException("root is null");

        Node node = root;
        int min;

        while (true) {
            min = node.value;
            if (node.left != null) {
                node = node.left;
            } else {
                break;
            }
        }
        return min;
    }

    private class Node {
        Node(int value) {
            this.value = value;
        }

        int value;
        Node left, right;
    }

    public static void main(String[] args) {
        final int numberOfNodes = 30;
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < numberOfNodes; i++) {
            binarySearchTree.put(random.nextInt());
        }

        binarySearchTree.foreach(i -> {
            System.out.printf("value: %d\n", i);
            return null;
        });

        System.out.println("max: " + binarySearchTree.max());
        System.out.println("min: " + binarySearchTree.min());
        System.out.println("secondHighestMax: " + binarySearchTree.secodHighestMax());
    }
}
