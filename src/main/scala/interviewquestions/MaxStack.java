package interviewquestions;


import java.util.Arrays;
import java.util.Stack;

public class MaxStack extends Stack<Integer> {
    private Integer max = null;

    @Override
    public Integer push(Integer item) {
        if (max == null || item > max) {
            max = item;
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        Integer popped = super.pop();
        if (max != null && popped.intValue() == max.intValue()) {
            max = null;
        }
        return popped;
    }

    public Integer max() {
        if (max == null) findMax();
        return max;
    }

    private void findMax() {
        Stack<Integer> temp = new Stack<>();

        while (!empty()) {
            Integer current = pop();
            if (max == null || current > max) {
                max = current;
            }
            temp.push(current);
        }

        while (!temp.empty()) {
            push(temp.pop());
        }
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();

        maxStack.push(1);
        maxStack.push(10);
        maxStack.push(2);
        maxStack.push(100);
        maxStack.push(3);

        System.out.println(maxStack.max());
        System.out.println(Arrays.toString(maxStack.toArray()));

        System.out.println("pop:" + maxStack.pop());
        System.out.println("pop:" + maxStack.pop());
        System.out.println(Arrays.toString(maxStack.toArray()));

        System.out.println(maxStack.max());

        maxStack.push(110);

        System.out.println(Arrays.toString(maxStack.toArray()));
        System.out.println(maxStack.max());
    }
}
