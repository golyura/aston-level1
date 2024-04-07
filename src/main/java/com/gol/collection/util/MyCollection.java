package com.gol.collection.util;

public interface MyCollection<E> {

   int size();

   boolean isEmpty();

   boolean add(E e);

   boolean remove(Object e);

   boolean addAll(MyCollection<? extends E> c);

   Object[] toArray();
}
