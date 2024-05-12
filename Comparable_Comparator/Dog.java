package Comparable_Comparator;

import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    private int size ;
    private String name;

    public Dog(String n,int s){
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog d){
        return size-d.size;
    }

    public String getName(){
        return name;
    }

    private static class nameCompartator implements Comparator<Dog>{
        public int compare(Dog a,Dog b){
            // The compare between strings have been overidden by the java library by
            // implementing the interface Comparable.
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getnameComparator(){
        return new nameCompartator();
    }
}
