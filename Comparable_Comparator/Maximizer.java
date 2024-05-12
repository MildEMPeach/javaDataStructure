package Comparable_Comparator;

public class Maximizer {
    public static Comparable max(Comparable[] items){
        int maxindex = 0;
        for(int i=0;i<items.length;i++){
            int cmp = items[i].compareTo(items[maxindex]);
            if(cmp > 0){
                maxindex = i;
            }
        }
        return items[maxindex]; 
    }
}
