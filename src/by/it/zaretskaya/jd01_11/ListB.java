package by.it.zaretskaya.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {
    private E[] elements = (E[]) new Object[]{};

    private int size = 0;

    @Override
    public boolean add(E e) {
        if (elements.length == size) {
            int newCapacity = elements.length + (elements.length / 2) + 1;
            elements = Arrays.copyOf(elements, newCapacity);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size--] = null;
        return returnValue;
    }

    @Override
    public E set(int index, E element) {
        E oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                joiner.add("null");
            } else {
                joiner.add(elements[i].toString());
            }
        }
        return joiner.toString();
    }

    @Override
    public void add(int index, E element) {
        if (elements.length == size) {
            int newCapacity = elements.length + (elements.length / 2) + 1;
            elements = Arrays.copyOf(elements, newCapacity);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] newList = c.toArray();
        int length = newList.length;
        if (length == 0) {
            return false;
        }
        final int tempSize = size;
        if (length > elements.length - tempSize) {
            int newCapacity = elements.length + (elements.length / 2) + 1;
            elements = Arrays.copyOf(elements, newCapacity);
        }
        System.arraycopy(newList, 0, elements, tempSize, length);
        size = tempSize + length;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                return elements[position++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        final Object[] es = elements;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object obj : c) {
            if (this.contains(obj)) {
                this.remove(obj);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.elements = (E[]) new Object[]{};
        this.size = 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
