package leetcode.design;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class leetcode_284 {
    public static void main(String[] args) {
        List<Object> peekingList = Arrays.asList(1, 2, 3);
        PeekingIterator peekingIterator = new PeekingIterator(peekingList.iterator());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }

    static class PeekingIterator implements Iterator<Object> {

        Iterator<Object> iterator;
        Object next;

        public PeekingIterator(Iterator<Object> iterator) {
            this.iterator = iterator;
            if (iterator.hasNext())
                this.next = iterator.next();
        }

        public Object peek() {
            return next;
        }

        @Override
        public Object next() {
            Object tmp = next;

            if (iterator.hasNext()) {
                next = iterator.next();
            } else {
                next = null;
            }

            return tmp;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
