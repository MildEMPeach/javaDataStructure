package BST;

public class BST {
    /*Binary Search Tree(int value)*/
    public int value;
    public BST left;
    public BST right;

    public BST(int v){
        value = v;
        left = null;
        right = null;
    }

    public static BST find(BST T,int key){
        /*to find the key in the BST*/
        if(T == null){
            return null;
        }
        if(key > T.value ){
            return find(T.right,key);
        }else if(key < T.value){
            return find(T.left,key);
        }else{
            return T;
        }
    }
    
    public static BST insert(BST T,int key){
        /* if find the key , do nothing but return the node */
        /* if not , create a new BST node and insert it into the tree */
        if(T == null){
            return new BST(key);
        }
        if(key > T.value){
            T.right = insert(T.right, key);
        }else if(key < T.value){
            T.left = insert(T.left,key);
        }
        return T;
    }

    public static BST remove(BST T, int key){
        /* remove the value key in the BST T*/
        /* 
         * Find the key , and then 
         * 3 cases:
         * 1. with no children
         * 2. with one children
         * 3. with two children
         * 
         */
        if(T == null ){
            return null;
        }
        if(key > T.value){
            T.right=remove(T.right,key);
        }else if(key < T.value){
            T.left=remove(T.left,key);
        }
        /* Find the key == T.value */
        else if(T.left == null){
            return T.right;
        }else if(T.right== null){
            return T.left;
        }else{
                /* case 3 */
            T.right = swapSmallest(T.right,T);
        }
        return T;
    }

    private static BST swapSmallest(BST T,BST R){
        /*
         * R refers to the node to be deleted;
         * T refers to the right child of R;
         * This function find the swap node and reconstruct the tree.
         */
        if(T.left == null){
            /* This is the node to be swapped */
            R.value = T.value;
            /* Then delete T but the right child of T need to be dealt with */
            return T.right;/* null or not null */
        }else{
            /* T.left != null */
            T.left = swapSmallest(T.left, R);
            return T;
        }
    }

    public static void travel(BST T){
        if(T == null ){
            return ;
        }
        travel(T.left);
        System.out.println(T.value);
        travel(T.right);
    }


    public static void main(String[] args){
        BST root = new BST(1);
        BST.insert(root,2);
        BST.insert(root, 0);
        BST.insert(root,3);
        System.out.println(BST.find(root, 3).value);
        BST.travel(root);
    }
}
