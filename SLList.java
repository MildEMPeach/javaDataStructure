public class SLList{

	private class IntNode{
		/*
		why private?

		In other classes(except for SLList and IntNode),hard
		to imagine when to access this class.    

		why static?
		class InNode never looks outwards.(It don't need to 
		access variables or methods of SLList.)

		*/
		public int item;
		public IntNode next;
		
		public IntNode(int i,IntNode n){
			item = i;
			next =n ;
		}
	}

	private IntNode first;

	public SLList(int x){
		/*create*/
		first = new IntNode(x,null);
	}

	public void addfirst(int x){
		first = new IntNode(x,first);
	}

	public int getfirst(){
		return first.item;
	}


	public static void main(String[] args){
		SLList L = new SLList(10);
		L.addfirst(5);
		L.addfirst(15);
		System.out.println(L.getfirst());
	}
}