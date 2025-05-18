package code360;

import java.util.Stack;

/**
 *
 * You will be given ‘Q’ queries. You need to implement a queue using two stacks according to those queries. Each query will belong to one of these three types:
 *
 * <p>1 ‘X’: Enqueue element ‘X’  into the end of the nth queue. Returns true after the element is enqueued.
 *
 * <p>2: Dequeue the element at the front of the nth queue. Returns -1 if the queue is empty, otherwise, returns the dequeued element.
 * Note:
 * Enqueue means adding an element to the end of the queue, while Dequeue means removing the element from the front of the queue.
 */

public class ConstructQueueUsingStack {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
class Queue {
    // Stacks to be used in the operations.
    Stack<Integer> stk1, stk2;

    public Queue() {
        // Initialise here.
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    // Enqueues 'X' into the queue. Returns true after enqueuing.
    public boolean enqueue(int x) {
        // Write your code here.
        stk1.push(x);
        return true;
    }
    /*
       Dequeues top element from queue. Returns -1 if the queue is empty,
       otherwise returns the popped element.
    */
    public int dequeue() {
        int result = -1;
        stk2.removeAllElements();
        if(!stk1.isEmpty()){
            while(stk1.size() != 1){
                stk2.push(stk1.pop());
            }
            result = stk1.pop();
            while(!stk2.isEmpty()){
                enqueue(stk2.pop());
            }
        }
        return result;
    }

    public int dequeueEfficient() {
        if (stk2.isEmpty()) {
            if (stk1.isEmpty()) {
                return -1; // Queue is empty
            }
            // Transfer elements from stack1 to stack2
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        stk1.forEach(e -> {
            result.append(e);
            result.append(" ");
        });
        return result.toString();
    }
};
