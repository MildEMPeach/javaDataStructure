# javaDataStructure

## SLList
SLList:singly linked list;

### Why Restrict Access?
Hide implementation details from users of your class.
1. Less for user of class to understand.
2. Safe for you to change private methods(implementation).
### Why Nested Classes?
Nested Classes are useful when a class doesn't stand on its own and is obviously
subordinate to another class.
Make the nested class **private** if other classes should never use the nested class.
###  Why Static Nested Classes?
If the nested class never uses any instance variables or methods of the outer class,declare it static.
1. Static classes cannot access outer class's instance variables or methods.
2. Results in a minor savings for memory.
```java
// the ultimate version of SLList
public class SLList{

	private class IntNode{
		public int item;
		public IntNode next;
		public IntNode(int i,IntNode n){
			item = i;
			next =n ;
		}
	}

	private IntNode sentinel;
	private int size;

	public SLList(){
        /*create a empty list*/
		size=0;
		sentinel = new IntNode(-1,null); // item can be casual
	}

	public SLList(int x){
		/*create*/
		size=0;
		sentinel = new IntNode(-1,new IntNode(x,null));
	}

	public void addfirst(int x){
		size+=1;
		sentinel.next = new IntNode(x,sentinel.next);
	}

	public void addlast(int x){
		size+=1;
		IntNode p = sentinel;
		while(p.next!=null){
			p=p.next;
		}
		p.next=new IntNode(x,null);
	}

	public int getfirst(){
		return sentinel.next.item;
	}

	public int size(){
		return this.size;
	}

	public static void main(String[] args){
		SLList L = new SLList();
		L.addlast(1314);
		System.out.println("The size is "+ L.size());
		System.out.println("The last is "+L.getlast());
		System.out.println("The first is "+L.getfirst());
	}
}
```

## DLList
DLList : doubly linked list


## Generic Lists
```java
