package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;

import java.util.*;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        lala:{
            if (queue.isEmpty()) {
                break lala;
            }
            int curr = queue.poll();
            reverseQueueUsingRecursion(queue);
            queue.add(curr);
        }
        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        Queue<Integer> ans = new LinkedList<>();
        Deque<Integer> firstQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();
        int n = queue.size();

        for (int i = 1; i <= n; i++) {
            if (i <= k)
                firstQueue.offer(queue.poll());
            else secondQueue.offer(queue.poll());
        }

        n = firstQueue.size();
        for (int i = 1; i <= n; i++)
             ans.offer(firstQueue.pollLast());
        for (int num : secondQueue)
            ans.offer(num);
        return ans;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (!queue.isEmpty())
            arr.add(queue.poll());
        Collections.sort(arr);
        queue.addAll(arr);
        return queue;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < parentheses.length(); i++) {
            if ((parentheses.charAt(i) == '(') || (parentheses.charAt(i) == '[')
                    || (parentheses.charAt(i) == '{')) {

                stack.push(parentheses.charAt(i));

            } else {
                if (stack.empty()) return false;
                if ((parentheses.charAt(i) == ')') && (stack.peek() != '(')) return false;
                if ((parentheses.charAt(i) == ']') && (stack.peek() != '[')) return false;
                if ((parentheses.charAt(i) == '}') && (stack.peek() != '{')) return false;

                stack.pop();
            }
        }

        return stack.empty();
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> prioryQueue = new PriorityQueue<>(new CarComparator());
        prioryQueue.addAll(cars);
        return prioryQueue;
    }

}
