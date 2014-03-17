package MCST;

import java.util.ArrayList;
import java.util.List;

public class RandomGraph {
	public Vertex vertex;
	public int[][] adjMatrix;
	public List<Vertex> vertexList = new ArrayList<Vertex>();
	
	public RandomGraph(){
		
	}
	
	/**
	 * This method is to initialize an graph according to vertexList
	 * @param vertexList -the list which store the vertex
	 */
	public RandomGraph(List<Vertex>vertexList){
		this.vertexList = vertexList;
		adjMatrix = new int[this.vertexList.size()][this.vertexList.size()];
		for (int i = 0; i < vertexList.size(); i++) {
			for (int j = 0; j < vertexList.size(); j++) {
				this.adjMatrix[i][j] = 0;
			}
		}
	}
	
	/**
	 * This method is to insert an edge into graph
	 * @param i -start vertex
	 * @param j -end vertex
	 * @param w -weight
	 * @return -true if success,false if not
	 */
	public boolean insertEdge(int i,int j,int w){
		if (i != j && this.adjMatrix[i][j] == 0&& this.adjMatrix[j][i] == 0) {
			this.adjMatrix[i][j] = w;
			this.adjMatrix[j][i] = w;
			return true;
		}else {
			return false;
		}
		
	}
	
	public void printGraph(){
		for (int i = 0; i < vertexList.size(); i++) {
			for (int j = 0; j < vertexList.size(); j++) {
				System.out.print(this.adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
		

}
