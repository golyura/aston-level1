package com.gol.collection.util.myArrayList;

import com.gol.collection.util.MyCollection;

import java.util.Comparator;

public interface MyList<E> extends MyCollection<E> {

    E get(int index);

    E remove(int index);

    void trimToSize();

    void sort(Comparator<? super E> c);

    void sort();

}
