public class VengefulSLList<Item> extends SLList<Item> {

    public void printLostItems(){
        
    }

    public static void main(String[] args) {
        
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        vs1.addlast(1);
        vs1.addlast(5);
        vs1.addlast(10);
        vs1.addlast(13);

        vs1.removelast();
        vs1.removelast();

        System.out.println("The fallen are:");
        vs1.printLostItems();
    }
}
