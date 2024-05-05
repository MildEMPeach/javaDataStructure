public interface List<Item>{
    public void addlast(Item x);
    public Item getlast();
    public int size();
    public Item get(int i);
    default public void print(){
        for(int i=0;i <size(); i+= 1){
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }
}