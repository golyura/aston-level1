package com.gol.collection.util.myArrayList;

import java.util.Comparator;

public class MyCollections {

    private MyCollections() {
    }

    public static <T extends Comparable<? super T>> void sort(MyList<T> list) {
        list.sort();
    }

    public static <T> void sort(MyList<T> list, Comparator<? super T> c) {
        list.sort(c);
    }


}
