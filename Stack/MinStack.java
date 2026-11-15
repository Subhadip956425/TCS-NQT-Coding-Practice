/// /////////////////////////////////////////

package Stack;// LeetCode: https://leetcode.com/problems/min-stack/

import java.util.Stack;

class MinStack {

    Stack<Long> stack;
    long minvalue;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            minvalue = val;
        } else {
            stack.push((long) val - minvalue);
            if (val < minvalue) {
                minvalue = val;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long diff = stack.pop();
        if (diff < 0) {
            minvalue = minvalue - diff;
        }
    }

    public int top() {
        long diff = stack.peek();
        if (diff >= 0) {
            return (int) (minvalue + diff);
        } else {
            return (int) minvalue;
        }
    }

    public int getMin() {
        return (int) minvalue;
    }

    // main method for testing
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top());    // 0
        System.out.println(minStack.getMin()); // -2
    }
}
