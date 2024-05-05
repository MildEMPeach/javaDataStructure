public class SLList<Item>{

	private class ItemNode{
		/*
		why private?

		In other classes(except for SLList and IntNode),hard
		to imagine when to access this class.    

		why static?
		class InNode never looks outwards.(It doesn't need to 
		access variables or methods of SLList.)

		*/
		public Item item;
		public ItemNode next;
		
		public ItemNode(Item i,ItemNode n){
			item = i;
			next =n ;
		}
	}

	//private IntNode first;
	private ItemNode sentinel;
	private int size;

	/*create a empty list*/
	public SLList(){
		size=0;
		//first = null;
		sentinel = new ItemNode(null,null); // item can be casual
	}

	public SLList(Item x){
		/*create*/
		size=0;
		//first = new IntNode(x,null);
		/*
		sentinel = new IntNode(-1,null);
		sentinel.next = new IntNode(x,null);
		*/
		sentinel = new ItemNode(null,new ItemNode(x,null));
	}

	public void addfirst(Item x){
		size+=1;
		//first = new IntNode(x,first);
		sentinel.next = new ItemNode(x,sentinel.next);
	}

	public void addlast(Item x){
		/*insert one node into the end of the SLList,written by gh*/ 
		size+=1;
		//to fix this problem , you can import invariant like 
		// sentinel node
		// if(first==null){
		// 	first = new IntNode(x,null);
		// 	return ;
		// }
		//IntNode p = first ;
		ItemNode p = sentinel;
		while(p.next!=null){
			p=p.next;
		}
		p.next=new ItemNode(x,null);
	}

	public Item getlast(){
		//IntNode p =first;
		ItemNode p = sentinel;
		while(p.next!=null){
			p=p.next;
		}
		return p.item;
	}

	public Item getfirst(){
		//return first.item;
		return sentinel.next.item;
	}
/*return the size of SLList ,written by gh*/
/*	public int size(){
		
		IntNode p=first;
		int size=0;
		while(p!=null){
			size += 1;
			p=p.next;
		}
		return size;
	} 
*/

/*Another way ,use recursion */
	/*
	private static int size(IntNode p){
		if(p.next==null){
			return 1;
		}
		return 1+size(p.next);
	}

	public int size(){
		
		return size(first);
	}
	*/

/*third way , regard size as a member of the class*/
/*private int size;*/
/*public int size(){return size;}*/

	public int size(){
		return this.size;
	}

	public static void main(String[] args){
		//SLList L = new SLList(10);
		SLList<Integer> L = new SLList<Integer>();
		// L.addfirst(5);
		// L.addfirst(15);
		//L.addlast(20);
		L.addlast(1314);
		System.out.println("The size is "+ L.size());
		System.out.println("The last is "+L.getlast());
		System.out.println("The first is "+L.getfirst());

		SLList<String> T = new SLList<>();
		T.addfirst("HELLO");
		T.addfirst("WORLD");
		T.addlast("yes");
		System.out.println(T.getlast());
	}
}