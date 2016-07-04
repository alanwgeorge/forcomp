package interviewquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Function;

public class BinarySearchTree {
    private Node root = null;

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

    public class Node {
        public Node(int value) {
            this.value = value;
        }

        int value;
        Node left, right;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.put(80);
        binarySearchTree.put(20);
        binarySearchTree.put(30);
        binarySearchTree.put(60);
        binarySearchTree.put(10);

        binarySearchTree.foreach(i -> {
            System.out.println("foreach: " + i);
            return null;
        });
    }
}
