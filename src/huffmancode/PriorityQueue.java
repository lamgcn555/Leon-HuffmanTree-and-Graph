package huffmancode;
import java.util.ArrayList;
import java.util.List;


public class PriorityQueue<T>{
	private List<Node> list;
//	private int heapSize;
	
	public PriorityQueue(){
		this.list = new ArrayList<Node>();
		//we do not want to use the first place
		Node placeHolder = new Node();
		
		
		//---------------------------test-------------------------------
//		Node node1 = new Node();
//		node1.frequency =1;
//		node1.name = 'a';
//		Node node2 = new Node();
//		node2.frequency = 3;
//		node2.name = 'c';
//		Node node3 = new Node();
//		node3.frequency = 2;
//		node3.name = 'b';
		//---------------------------test-------------------------------
		
		
		
		
		
		this.list.add(placeHolder);
		
		
		
		
		
		//---------------------------test-------------------------------
//		this.list.add(node1);
//		this.list.add(node2);
//		this.list.add(node3);
		//---------------------------test-------------------------------
	}
	
	/**
	 * This method is to build min-heap
	 * @param list store the node
	 */
	private void buildMinHeap(List<Node> list){
//		this.heapSize = this.list.size();
		for (int i = (int)(Math.floor(list.size()/2)); i>=1; i--) {
			this.minHeapify(list, i);
		}
	}
	
	/**
	 * This method is to maintain the min-heap property
	 * @param list store the node
	 * @param i the index of node which violate the min-heap property
	 */
	private void minHeapify(List<Node> list,int i){
		int smallest = 0;
		int l = left(i);
		int r = right(i);
		//find the minimum element
		if (l<= this.list.size()-1 && this.list.get(l).frequency<this.list.get(i).frequency) {
			smallest = l;
		}else {
			smallest = i;
		}
		if (r<=this.list.size()-1 && this.list.get(r).frequency<this.list.get(smallest).frequency) {
			smallest = r;
		}
		//exchange the i and smallest
		if (smallest != i) {
			Node temp = new Node();
			temp = this.list.get(i);
			this.list.set(i, this.list.get(smallest));
			this.list.set(smallest, temp);
			this.minHeapify(list, smallest);
		}
		
	}
	
//	private int parent(int i){
//		return (int)(Math.floor(i));
//	}
	private int left(int i){
		return 2*i;
	}
	private int right(int i){
		return 2*i+1;
	}
	
	/**
	 * This method is to get the minimum node in the priorityQueue
	 * @return the minimum node
	 */
	public Node poll(){
		Node minNode = new Node();
		if (list.size()<=1) {
			System.out.println("The priority is empty!");
			return minNode;
 		}
		minNode = this.list.get(1);
		this.list.set(1, this.list.get(this.list.size()-1));
		this.list.remove(this.list.size()-1);
		this.minHeapify(this.list, 1);
		return minNode;
	}
	
	/**
	 * This method is to add a node into priorityQueue 
	 * @param node -the node you want to add in
	 * @return -true if success  -false not success
	 */
	public boolean offer(Node node){
		this.list.add(node);
		this.buildMinHeap(this.list);
		return true;
	}
	
	public int size(){
		return this.list.size()-1;
	}
	
	
	
	
	
}