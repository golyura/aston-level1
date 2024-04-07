package com.gol.collection.util.myArrayList;

public class Starter {
    public static void main(String[] args) {
        Person person1 = new Person(12, "yura");
        Person person2 = new Person(55, "rita");
        Person person3 = new Person(5, "Vika");
        Person person4 = new Person(47, "Stas");
        Person person5 = new Person(95, "Artem");

        Person person6 = new Person(66, "Vika2");
        Person person7 = new Person(99, "Stas2");
        Person person8 = new Person(2, "Artem2");

        MyList<Person> list = new MyArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        MyList<Person> list2 = new MyArrayList<>();
        list2.add(person6);
        list2.add(person7);
        list2.add(person8);

        System.out.println("list.size() = " + list.size());
        Person person = list.get(1);
        System.out.println("person.getName() = " + person.getName());

        list.addAll(list2);
        System.out.println("list.size() = " + list.size());

        Person personRemove = list.remove(5);
        Person personIndex6 = list.get(5);
        System.out.println("person remove = " + personRemove.getName());
        System.out.println("personIndex6.getName() = " + personIndex6.getName());
        System.out.println("list.size() = " + list.size());

        System.out.println("remove " + list.remove(person3));
        var person9 = list.get(2);
        System.out.println("person9.getName() = " + person9.getName());
        System.out.println("list.size() = " + list.size());

        System.out.println(list);

//        list.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.compareTo(o2);
//            }
//        });

//        list.sort();

//        MyCollections.sort(list);

        MyCollections.sort(list, Person::compareTo);

        System.out.println(list);

//        Person person1 = new Person(12, "yura");
//        Person person2 = new Person(55, "rita");
//
//        MyList<Person> list = new MyArrayList<>();
//        list.add(person1);
//        list.add(person2);
//
//        MyList<Person> list2 = new MyArrayList<>(list);
//        System.out.println(list2);

    }
}
