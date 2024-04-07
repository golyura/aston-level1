package com.gol.collection.util.myArrayList;

import com.gol.collection.util.MyCollection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<E extends Comparable<E>> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements = new Object[DEFAULT_CAPACITY];

    private int size;

    private boolean isSorted;

    public MyArrayList() {
    }

    public MyArrayList(MyCollection<? extends E> c) {
        size = c.size();
        elements = c.toArray();
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        add(e, elements, size);
        isSorted = false;
        return true;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elements;

        E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    @Override
    public boolean addAll(MyCollection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elements;
        final int s;
        if (numNew > (elements = this.elements).length - (s = size))
            elements = grow();
        System.arraycopy(a, 0, elements, s, numNew);
        size = s + numNew;
        isSorted = false;
        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elements[index];

    }

    @Override
    public void sort(Comparator<? super E> c) {
        trimToSize();
        Arrays.sort(elements, ((Comparator) c));
    }

    @Override
    public void sort() {
        if (!isSorted) {
            bubbleSort();
        }
    }

    private void bubbleSort() {
        for (int out = size - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (((Comparable) elements[in]).compareTo(elements[in + 1]) > 0)
                    toSwap(in, in + 1);
            }
        }
    }

    private void toSwap(int first, int second) {
        Object dummy = elements[first];
        elements[first] = elements[second];
        elements[second] = dummy;
    }


    public void trimToSize() {
        if (size < elements.length) {
            elements = (size == 0)
                    ? elements
                    : Arrays.copyOf(elements, size);
        }
    }

    private void add(E e, Object[] elements, int sizeList) {
        if (sizeList == elements.length) {
            elements = grow();
        }
        elements[sizeList] = e;
        size = sizeList + 1;
    }

    private Object[] grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * 2;
        return elements = Arrays.copyOf(elements, newCapacity);
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
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


    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
