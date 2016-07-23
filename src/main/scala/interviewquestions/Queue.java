package interviewquestions;

import java.util.Stack;

public class Queue<T> {
    private Stack<T> stack = new Stack<T>();
    private Stack<T> temp = new Stack<T>();

    public void enqueue(T t) {
        stack.push(t);
    }

    public T dequeue() {
        T value = null;

        while (stack.size() > 1) {
            temp.push(stack.pop());
        }

        value = stack.pop();

        while (temp.size() > 0) {
            stack.push(temp.pop());
        }

        return value;
    }

    public static void main(String[] args) {
        Queue<Integer> iQueue = new Queue<>();

        iQueue.enqueue(1);
        iQueue.enqueue(2);
        iQueue.enqueue(3);
        iQueue.enqueue(4);
        iQueue.enqueue(5);
        iQueue.enqueue(6);
        iQueue.enqueue(7);
        iQueue.enqueue(8);

        Integer dequeued = iQueue.dequeue();
        assert  dequeued != null && dequeued.intValue() == 1;

        for (int i = 0; i < 7; i++) {
            dequeued = iQueue.dequeue();
        }

        assert  dequeued.intValue() == 8;
    }
}
