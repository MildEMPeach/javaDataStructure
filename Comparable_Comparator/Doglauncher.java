package Comparable_Comparator;
import java.util.Comparator;

public class Doglauncher {
    public static void main(String[] args){
        Dog[] dogs = new Dog[]{new Dog("dkl",1),new Dog("ykt",2),new Dog("ytwx",3)};
        String Maxsizename =((Dog)Maximizer.max(dogs)).getName();
        Comparator<Dog> nc = Dog.getnameComparator();
        Dog d3 = new Dog("ViniciousJr", 123);
        Dog d4 = new Dog("Bellingham",456);
        if(nc.compare(d3, d4) > 0){
            // which means the d3 comes after d4
            System.out.println(d3.getName());
        }else{
            System.out.println(d4.getName());
        }
        System.out.println(Maxsizename);
    }
}
