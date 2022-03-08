package by.it.katsal.jd01_11;

import java.util.*;


public class ListB<E> implements List<E> {

    private E[] elements = (E[]) new Object[16];
    private int size = 0;



    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }

        }
        else {

            for (int i = 0; i < size; i++) {
                if (elements[i] == o) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        }
        else {

            for (int i = 0; i < size; i++) {
                if (elements[i] == o) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void add(int index, E element) {
        System.arraycopy(elements, 0, elements, 0, index);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean add(E e) {
        if (elements.length == size) {
            int newLength = elements.length + elements.length / 2 + 1;
            elements = Arrays.copyOf(elements, newLength);
        }
        elements[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        if (elements.length + c.size() > size) {
            int newLength = elements.length + c.size() + 1;
            elements = Arrays.copyOf(elements, newLength);
            System.arraycopy(c.toArray(), 0, elements, size, c.size());
            size += c.size();
            return true;
        }
        System.arraycopy(c.toArray(), 0, elements, size, c.size());
        return true;
    }

    @Override
    public E set(int index, E element) {
        E returnValue = elements[index];
        elements[index] = element;
        return returnValue;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E remove(int index) {
        E returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
        elements[size--] = null;
        return returnValue;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
            if (i + 1 < size) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }

    @Override
    public boolean remove(Object o) {

        if (! this.contains(o)) {
            return false;
        }

        if (o == null) {
            while (this.contains(null)) {
                for (int i = 0; i < size; i++) {
                    if (elements[i] == null) {
                        this.remove(i);
                    }
                }
            }
        }
        else {

            while (this.contains(o)) {
                for (int i = 0; i < size; i++) {
                    if (elements[i] == o) {
                        this.remove(i);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}





