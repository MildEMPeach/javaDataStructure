public class IntList{
	public int first;
	public IntList rest;

	public IntList(int f,IntList r){
		first = f;
		rest = r;
	}

	public int get(int i){
		if(i==0){
			return first;
		}
		return rest.get(i-1);
	}

	// public int get(int i){
	// 	return get(i,0,this);
	// }

	// private int get(int i,int current,IntList p){
	// 	if(i==current){
	// 		return p.first;
	// 	}
	// 	return get(i,current+1,p.rest);
	// }

	public static void main(String[] args){
		IntList L = new IntList(15,null);
		L = new IntList(10,L);
		L = new IntList(5,L);
		System.out.println(L.get(1));
	}
}