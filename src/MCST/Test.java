package MCST;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RandomGraphGenerator graphGenerator = new RandomGraphGenerator();
		//generate graph with 4 vertex and 4 edge
		RandomGraph graph = graphGenerator.generate(6, 6);
		MCSTGenerator mcstGenerator = new MCSTGenerator(graph);
		mcstGenerator.prim();
//		mcstGenerator.checkCondition();

	}

}
