package leetcode.array;

import java.util.*;

public class leetcode_1700 {
    public static void main(String[] args) {
        leetcode_1700 lc = new leetcode_1700();
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(lc.countStudents(students, sandwiches));
    }

    // Solution - Array[2]
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        int n = students.length, j;
        for (int i : students)
            count[i]++;
        for (j = 0; j < n && count[sandwiches[j]] > 0; j++)
            count[sandwiches[j]]--;
        return n - j;
    }

    // Solution - Stack & Queue
    public int countStudentsStackNQueue(int[] students, int[] sandwiches) {
        Stack<Integer> sandwichStack = new Stack<>();
        Queue<Integer> studentQueue = new LinkedList<>();

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }

        for (int i : students) {
            studentQueue.add(i);
        }

        int failCount = 0;

        while (!studentQueue.isEmpty() && !sandwichStack.isEmpty()) {
            if (studentQueue.peek().equals(sandwichStack.peek())) {
                studentQueue.remove();
                sandwichStack.pop();
                failCount = 0;
            } else {
                studentQueue.add(studentQueue.poll());
                if (failCount++ == studentQueue.size()) {
                    break;
                }
            }
        }

        return studentQueue.size();
    }
}
