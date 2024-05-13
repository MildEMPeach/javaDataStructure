package DisjointSets;

/*并查集*/
public interface DisjointSets {
    void connect(int p,int q);/*To connect p and q of integer*/
    boolean isConnected(int p ,int q); /*To judge if p and q are in the same set*/
}
