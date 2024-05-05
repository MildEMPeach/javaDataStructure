public class Alist<Item> implements List<Item>{
    // Array based list
    private Item[] items;
    private int size;

    public Alist(){
        items = (Item[]) new Object[100];
        size = 0;
    }

    /*resize the Alist */
    private void resize(int capacity){
        Item[] a =(Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addlast(Item x){
        /*resize array when items is full */
        if(size == items.length){
            //resize(size+1);
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    public Item getlast(){
        return items[size-1];
    }

    public Item get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public Item removeLast(){
        //don't need to change the value of the last item.
        Item x = getlast();
        size--;
        return x;
    }
    
    // public static void main(String[] args) {
    //     Alist<Integer> a = new Alist<Integer>();
    //     a.addLast(10);
    //     a.addLast(15);
    //     a.addLast(78);
    //     System.out.println(a.get(1));
    // }
}