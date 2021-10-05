package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.Iterator;

/**
 * <p>Creation Time: 2021-10-09 09:17:53</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_05 {

    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {

        Integer nextElement;
        Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            nextElement = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer next = nextElement;
            nextElement = iterator.hasNext() ? iterator.next() : null;
            return next;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }


}
