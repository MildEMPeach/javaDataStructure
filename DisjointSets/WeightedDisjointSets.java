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
        /*find the root of x*/
        while(parent[x] >= 0){
            x = parent[x];
        }
        return x;
    }

    @Override
    public void connect(int p,int q){
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
        /*to compare int , == has the same function as equals*/
        return find(p)==find(q);        
    }

    public void testWeightedDisjointSets(){
        for(int i=0;i<parent.length;i++){
            System.out.println(i+":"+parent[i]);
        }
    }

    public static void main(String[] args) {
        WeightedDisjointSets testSets = new WeightedDisjointSets(7);
        testSets.connect(0, 1);
        //testSets.testWeightedDisjointSets(); ok
        testSets.connect(1, 2);
        //testSets.testWeightedDisjointSets(); ok
        testSets.connect(1, 4);
        //testSets.testWeightedDisjointSets();
        testSets.connect(3, 5);
        testSets.testWeightedDisjointSets();
        System.out.println(testSets.isConnected(3, 6));
        testSets.connect(5, 6);
        System.out.println(testSets.isConnected(3, 6));
    }

}
