package MCST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;



public class MCSTGenerator {
	public RandomGraph graph;
	public final static int max = 100000;
	public Queue<Vertex> priorityQueue;
	public Map<Integer, Vertex> vertexMap;
	public List<Vertex> vertexOrder = new ArrayList<Vertex>();
	
	public MCSTGenerator(RandomGraph graph){
		this.graph = graph;
		graph.printGraph();
	}
	
	
	/**
	 * This method is implement prim algorithm to compute the minimum cost spanning tree
	 */
	public void prim(){
		this.vertexMap = new HashMap<Integer, Vertex>();
		priorityQueue = new PriorityQueue<Vertex>(this.graph.vertexList.size(),orderComparator);
		
		for (Vertex vertex : this.graph.vertexList) {
			vertex.key = 100;
			vertex.parent = null;
			this.vertexMap.put(vertex.name, vertex);
//			this.priorityQueue.offer(vertex);
		}
		this.graph.vertexList.get(0).key = 0;
		priorityQueue.addAll(this.graph.vertexList);
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("\nThe minimum cost spanning tree is \n");
		while (priorityQueue.size()>0) {
			Vertex u = priorityQueue.poll();
			this.vertexOrder.add(u);
			//print the minimum spanning tree and check the condition
			if (u.parent != null) {
				//-------------------------test----------------------
				Vertex seconde = priorityQueue.peek();
				//-------------------------test----------------------
				
				
				
				int conditionCheck;
				//to process the last vertex
				if (seconde == null) {
					PriorityQueue<Integer> lastPriorityQueue = new PriorityQueue<Integer>();
					for (Vertex v : this.adjVertex(u)){
//						PriorityQueue<Integer> lastPriorityQueue = new PriorityQueue<Integer>();
						lastPriorityQueue.offer(this.graph.adjMatrix[v.name][u.name]);
					}
					if (lastPriorityQueue.size() == 1) {
						conditionCheck = lastPriorityQueue.poll();
					}else {
						lastPriorityQueue.poll();
						conditionCheck = lastPriorityQueue.poll();
					}
					
					System.out.print(u.parent.name + " -- >"+u.name + " Weight:"+u.key+" and small than "+ conditionCheck+" will not change the MSCT"+ "\n");
				}else {
					System.out.print(u.parent.name + " -- >"+u.name + " Weight:"+u.key+" and small than "+ seconde.key+" will not change the MSCT"+ "\n");
				}

				
				
			}
			//update the priority queue dynamically
			for (Vertex v : this.adjVertex(u)) {
				if (priorityQueue.contains(v) && this.graph.adjMatrix[u.name][v.name] < v.key) {
					v.parent = u;
					v.key = this.graph.adjMatrix[u.name][v.name];
//					System.out.println(v.key);
					//update the priority queue dynamically
					Vertex vertex = priorityQueue.poll();
					priorityQueue.add(vertex);
					
					//-------------------------------------test-----------------------------
//					for (int i = 0; i < this.priorityQueue.size(); i++) {
//						if (v.key != 100 && v.key != 0) {
//							
//						}
//					}
					
				}
			}
			
			
			
		}
		
	}
	
//	/**
//	 * This method is to check the condition 
//	 */
//	public void checkCondition(){
//		System.out.println("------------------------------------------------------------------");
//		System.out.println("\nEvery edge's condition is below:\n");
//		for (int i = 1; i < this.vertexOrder.size(); i++) {
//			Vertex currentVertex = this.vertexOrder.get(i);
//			Vertex currentParent = currentVertex.parent;
//			for (Vertex v:this.adjVertex(currentParent)) {
//				System.out.println("Edge "+currentParent.name+" -->"+v.name + " cost greater than "+this.graph.adjMatrix[currentParent.name][currentVertex.name]+" will not change the MCST.");
//			}
//		}
//	}
	
	
	/**
	 * This method is to find vertex which is adjacent to v
	 * @param v - vertex v
	 * @return -List which store the vertex adjacent to v
	 */
	private List<Vertex> adjVertex(Vertex v){
		int i = v.name;
		List<Vertex> list = new ArrayList<Vertex>();
		for (int j = 0; j < this.graph.vertexList.size(); j++) {
			if (this.graph.adjMatrix[i][j]>0) {
//				System.out.println(j);
				Vertex u = vertexMap.get(j);
				list.add(u);
			}
		}
		return list;
	}
	
	
	
	Comparator<Vertex> orderComparator = new Comparator<Vertex>() {
		public int compare(Vertex char1 , Vertex char2){
			int char1key = char1.key;
			int char2key = char2.key;
			if (char1key > char2key) {
				return 1;
			}else if (char1key < char2key) {
				return -1;
			}else {
				return 0;
			}
		}
	};
	

}
