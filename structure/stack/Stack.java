package Algorithm.structure.stack;

import java.util.ArrayList;

public class Stack {
    ArrayList<String> stackList = new ArrayList<>();
    int idx = -1;

    public void push(String item) {
        stackList.add(item);
        idx++;
    }

    public int size() {
       return stackList.size();
    }

    public void clear() {
        stackList.clear();
    }

    public String peek() {
        if (isEmpty()) return "";

        return stackList.get(idx);
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("");
            return;
        }

        for (String s : stackList) {
            System.out.println(s);
        }
    }

    public String pop() {
        if (isEmpty()) return "";
        String tmp = stackList.get(idx);
        stackList.remove(idx);
        idx--;
        return tmp;
    }

    public boolean isEmpty() {
        return stackList.size() == -1;
    }
}
