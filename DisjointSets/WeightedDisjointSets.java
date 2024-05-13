package DisjointSets;

public class WeightedDisjointSets implements DisjointSets{
    /*to use the sum of minus numbers represent the weight*/
    /*either way is to create a seperate int[] to track the weight*/
    private int[] parent;

    public WeightedDisjointSets(int size){
        parent = new int[size];
        /*all the elements are minus one at first*/
        for(int i=0;i<size;i++){
            parent[i]= -1;
        }
    }

    public int find(int x){
        /* very very very important,find the root of x*/        
        /* use recursion with path compression */
        if(parent[x] < 0) { return x;}
        int returnposition = find(parent[x]);
        parent[x] = returnposition;
        return returnposition;
    }


    @Override
    /* Maybe improved in the future */
    public void connect(int p,int q){
        /*O(logN) */
        /* to connect p and q */
        /* new rule in weightedDisjointSets: to link the root with smaller weight
        to the large one.
        */
        int rootp = find(p);
        int rootq = find(q);
        int smallroot = -1;
        int bigroot = -1;
        if(parent[rootp] <= parent[rootq]){
            /*parent[root]<0,so the smaller has the larger weight*/
            smallroot = rootq;
            bigroot = rootp;
        }else{
            smallroot = rootp;
            bigroot = rootq;
        }
        /*update the weight of the bigroot */
        /*Need to do before the change of the smallroot */
        parent[bigroot] += parent[smallroot];
        /*change the smallroot*/
        parent[smallroot] = bigroot ;
    }

    @Override
    public boolean isConnected(int p,int q){ 
        /*O(logN) */
        /*to compare int , == has the same function as equals*/
        return find(p)==find(q);        
    }

    public void testWeightedDisjointSets(){
        /*To test the WeightedDisjointSets*/
        for(int i=0;i<parent.length;i++){
            System.out.println(i+":"+parent[i]);
        }
    }

    public static void main(String[] args) {
        WeightedDisjointSets testSets = new WeightedDisjointSets(8);
        testSets.connect(0, 1);
        testSets.connect(2, 3);
        testSets.connect(0, 3);
        testSets.connect(4, 5);
        testSets.connect(6, 7);
        testSets.connect(4, 7);
        testSets.testWeightedDisjointSets();
        testSets.connect(3, 7);
        //System.out.println(testSets.isConnected(3, 1));
        testSets.testWeightedDisjointSets();
    }
}
