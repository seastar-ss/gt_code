package com.shawn.ss.lib.tools.structure;

import java.io.Serializable;
import java.util.*;

public class FIFOList<E> implements List<E>, Queue<E>, Serializable {

    public static class NotImplementedException extends RuntimeException {

        public NotImplementedException() {
        }
    }

    private final class FIFOIterator implements ListIterator<E> {

        private Node cur;
        private int index;
        private boolean visited;

        private FIFOIterator(final Node cur) {
            this.cur = cur;
            this.index = 0;
            visited = false;
        }

        @Override
        public boolean hasNext() {
            return cur != head || !visited;
        }

        @Override
        public E next() {
            E ret = cur.value;
            if (cur == head) {
                visited = true;
            }
            cur = cur.next;
            index = (index + 1) % capacity;
            return ret;
        }

        @Override
        public boolean hasPrevious() {
            return cur != head;
        }

        @Override
        public E previous() {
            cur = cur.previous;
            index = (index - 1 + capacity) % capacity;
            return cur.value;
        }

        @Override
        public int nextIndex() {
            return (index + 1) % capacity;
        }

        @Override
        public int previousIndex() {
            return (index - 1 + capacity) % capacity;
        }

        @Override
        public void set(E e) {
            cur.value = e;
        }

        @Override
        public void add(E e) {
            throw new NotImplementedException();
        }

        @Override
        public void remove() {
            throw new NotImplementedException();
        }
    }

    final class Node implements Serializable {

        E value;
        Node next;
        Node previous;
    }

    final Node root;
    final int capacity;
    private int size;
    private Node current;
    private Node head;
    boolean unique;

    public FIFOList() {
        this(32, false);
    }

    public FIFOList(int size) {
        this(size, false);
    }

    public FIFOList(int size, boolean unique) {
        if (size < 2) {
            size = 2;
        }
        this.capacity = size;
        root = new Node();
        build();
        clear();
        this.unique = unique;
    }

    private void build() {
        Node node = root;
        for (int i = 1; i < capacity; ++i) {
            node.next = new Node();
            node.next.previous = node;
            node = node.next;
        }
        node.next = root;
        root.previous = node;
    }

    @Override
    public int size() {
        return size > capacity ? capacity : size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (Node n = head; n.next != head; n = n.next) {
            if (n.value != null && n.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        final Node cur = head;
        return new FIFOIterator(cur);
    }

    @Override
    public Object[] toArray() {
        Object[] ret = new Object[size];
        int i = 0;
        for (Node n = head; n.next != head; n = n.next) {
            ret[i++] = n.value;
        }
        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        int i = 0;

        for (Node n = head; n.next != head; n = n.next) {
            a[i++] = (T) n.value;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        ++size;
        if (size > capacity) {
            head = head.next;
            onFull();
        }
        if (!unique || !checkDuplicated(e)) {
            current.value = e;
            current = current.next;
        }
        return true;
    }

    private boolean checkDuplicated(E e) {
        if (unique) {
            return this.contains(e);
        } else {
            return false;
        }
    }

    protected void onFull() {

    }

    protected void onDuplicated() {

    }

    @Override
    public boolean remove(Object o) {
        // int i = 0;+
        for (Node n = head; n.next != head; n = n.next) {
            if (n.value.equals(o)) {
                n.value = null;
                return true;
            }
            // ++i;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // int n = c.size(), m = 0;
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
        // return n == m;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            this.add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return this.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public final void clear() {
        head = current = root;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node n = this.getPos(index);
        return n == null ? null : n.value;
    }

    @Override
    public E set(int index, E element) {
        Node n = this.getPos(index);
        E ret = n.value;
        n.value = element;
        return ret;
    }

    @Override
    public void add(int index, E element) {
        throw new NotImplementedException();
    }

    @Override
    public E remove(int index) {
        Node n = this.getPos(index);
        E ret = n.value;
        n.value = null;
        return ret;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for (Node n = head; n.next != head; n = n.next) {
            if (n.value != null && n.value.equals(o)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = capacity - 1;
        for (Node n = current; n != head; n = n.previous) {
            if (n.value != null && n.value.equals(o)) {
                return i;
            }
            --i;
        }
        return head.value.equals(o) ? 0 : -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        final Node cur = head;
        return new FIFOIterator(cur);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        final Node cur = this.getPos(index);
        return new FIFOIterator(cur);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        int s = toIndex - fromIndex;
        if (s > 7 && s <= capacity) {
            FIFOList<E> sub = new FIFOList<E>(toIndex - fromIndex);
            // int i=0;
            Node cur = this.getPos(fromIndex);
            for (int i = 0; i < s; ++i) {
                sub.add(cur.value);
                cur = cur.next;
            }
            return sub;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean offer(E e) {
        return this.add(e);
    }

    @Override
    public E remove() {
        throw new NotImplementedException();
    }

    @Override
    public E poll() {
        throw new NotImplementedException();
    }

    @Override
    public E element() {
        throw new NotImplementedException();
    }

    @Override
    public E peek() {
        return current.value;
    }

    public E peekFirst() {
        return head.value;
    }

    private Node getPos(int index) {
        if (index > this.capacity) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        boolean vst = false;
        for (Node n = head; n != head || !vst; n = n.next) {
            if (n == head) {
                vst = true;
            }
            if (i == index) {
                return n;
            } else {
                ++i;
            }
        }
        return null;
    }

}
