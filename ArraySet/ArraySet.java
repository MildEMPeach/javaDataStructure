package ArraySet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private int size;

    public ArraySet(){
        items = (T[]) new Object[100];
        size=0; // The add position should be items[size];
    }

    public boolean contains(T item){
        for(int i=0 ; i<size;i++){
            if(items[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    public void add(T item){
        if(item==null){
            throw new IllegalArgumentException("You can't add a null to the set");
        }
        if(!contains(item)){
            items[size]=item;
            size+=1;
        }
    }

    public static <G> ArraySet<G> of(G... stuff){
        ArraySet<G> returnSet = new ArraySet<G>();
        for(G x:stuff ){
            // add : change the size ;
            returnSet.add(x);
        }
        return returnSet;
    }

    public int size(){
        return size;
    }
    
    private class ArraySetIterator implements Iterator<T>{
        private int pos; // to record the position of the Iterator

        public ArraySetIterator(){
            pos = 0;
        }

        public boolean hasNext(){
            if(pos < size){
                return true;
            }
            return false;
        }
        public T next(){
            T returnItem = items[pos];
            pos += 1;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    /* 
    @Override
    public String toString(){
        // String returnString = "{";
        // for(T item : this){
        //     returnString += item.toString();
        //     returnString += ", ";
        // }
        // returnString += "}";
        // return returnString;
        StringBuilder returnSB = new StringBuilder("{");
        for(int i=0;i < size -1 ;i+=1){
            returnSB.append(items[i]);
            returnSB.append(",");
        }
        returnSB.append(items[size-1]);
        returnSB.append("}");
        return returnSB.toString();
    }
    */

    // a even better way for toString():
    @Override
    public String toString(){
        List<String> listOfItems = new ArrayList<>();
        for(T x: this){
            listOfItems.add(x.toString());
        }
        return String.join(",", listOfItems);
    }

    @Override
    public boolean equals(Object other){
        if(other == this) {return true;}
        if(other == null){return false;}
        if(other.getClass()!= this.getClass()){return false;}
        ArraySet<T> o = (ArraySet<T>) other;
        if(o.size() != this.size()){
            return false;
        }
        for(T item : o){
            if(!contains(item)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ArraySet<Integer> aset = new ArraySet<>();
        //aset.add(null);
        aset.add(17); 
        aset.add(34);
        aset.add(89);
        System.out.println(aset.contains(2));
        System.out.println(aset.contains(4));
        System.out.println("size = "+aset.size());

        // iterator
        //Iterator<Integer> asetIterator = aset.iterator();
        for(int i:aset){
            System.out.println(i);
        }
        System.out.println(aset);


        ArraySet<Integer> aset2 = new ArraySet<>();
        //aset.add(null);
        aset2.add(17); 
        aset2.add(34);
        aset2.add(89);
        System.out.println(aset.equals(aset2));

        ArraySet<String> asetOfStrings = ArraySet.of("hi","hello","Hi","yes");
        System.out.println(asetOfStrings);
        System.out.println(asetOfStrings.size());
    }
}
