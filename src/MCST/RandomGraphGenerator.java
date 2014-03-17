package MCST;

import java.util.ArrayList;
import java.util.List;

public class RandomGraphGenerator {
	public List<Vertex> vertexList = new ArrayList<Vertex>();
	public RandomGraph randomGraph;
	
	public RandomGraphGenerator(){
		
	}
	
	/**
	 * This method is to generate random graph according to number of vertex and number of edge 
	 * @param numOfVertex -number of vertex
	 * @param numOfEdge -number of edge
	 * @return -RandomGraph
	 */
	public RandomGraph generate(int numOfVertex,int numOfEdge){
		if (numOfEdge < numOfVertex-1 || numOfEdge> (numOfVertex*(numOfVertex-1))/2) {
			System.out.println("The number of edge cannot construct a connected graph ");
			return null;
		}
		for (int i = 0; i < numOfVertex; i++) {
			Vertex vertex = new Vertex(i);
//			System.out.println(vertex.name);
			this.vertexList.add(vertex);
		}
		randomGraph = new RandomGraph(this.vertexList);
		
		
		//Generate a random graph with uniform distribution of edges
		int count = 0;
		for (int i = 0; i < 100000; i++) {
			if (count == numOfEdge) {
				break;
			}
			if (randomGraph.insertEdge((int)(Math.random()*numOfVertex), (int)(Math.random()*numOfVertex), (int)(Math.random()*10)+1)) {
				randomGraph.insertEdge((int)(Math.random()*numOfVertex), (int)(Math.random()*numOfVertex), (int)(Math.random()*10)+1);
				count++;
			}
		}
		return this.randomGraph;
//		randomGraph.printGraph();
	}

}
