package huffmancode;

//import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.PriorityQueue;
//import java.util.Queue;


public class HuffmanEncode {
//	private Node node;
//	private Queue<Node> priorityQueue;
	//---------------------------test-------------------------------
	private huffmancode.PriorityQueue<Node> priorityQueue;
	//---------------------------test-------------------------------
	private String inputString = "";
	private String outputString = "";
	private Map<Character, String> mapTable;
	private Node rootNode;
	
	
	public Node getRootNode() {
		return rootNode;
	}


	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}


	public String getOutputString() {
		return outputString;
	}


	public void setOutputString(String outputString) {
		this.outputString = outputString;
	}


	public String getInputString() {
		return inputString;
	}


	public void setInputString(String inputString) {
		this.inputString = inputString;
	}


//	public Queue<Node> getPriorityQueue() {
//		return priorityQueue;
//	}
//
//
//	public void setPriorityQueue(Queue<Node> priorityQueue) {
//		this.priorityQueue = priorityQueue;
//	}


//	public Node getNode() {
//		return node;
//	}
//
//
//	public void setNode(Node node) {
//		this.node = node;
//	}

	
	/**
	 * This constructor is to compute the frequency of each character and initialize the priorityQueue
	 * @param inputString -input string
	 */
	public HuffmanEncode(String string){

		//replace space
//		String string = inputString.replaceAll(" ", "");
//		System.out.println(string);
		this.inputString = string;
		
		
		HashMap<Character, Integer> strhashMap = new HashMap<Character, Integer>();
		int num = 0;
		int count = 0;
		//pick up a char to compute its frequency
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			int temp = 0;
			for (int j = 0; j < string.length(); j++) {
				num = string.indexOf(c,temp);
				if (num!=-1) {
					count++;
					temp = num +1;
					continue;
				}else {
					strhashMap.put(c,count);
					count = 0;
					break;
				}
			}
		}
		
		Iterator<Character> iteratorKey = strhashMap.keySet().iterator();
		Iterator<Integer> iteratorValue = strhashMap.values().iterator();
		
		
		
		//initliaze the priorityQueue
//		priorityQueue = new PriorityQueue<Node>(strhashMap.size(),orderComparator);
		//---------------------------test-------------------------------
		priorityQueue = new huffmancode.PriorityQueue<Node>();
		//---------------------------test-------------------------------
		while (iteratorKey.hasNext()) {
			Node charOfInput = new Node();
			charOfInput.name = iteratorKey.next();
			charOfInput.frequency = iteratorValue.next();
			priorityQueue.offer(charOfInput);
		}
		
//		while (priorityQueue.size()>0) {
//			System.out.printf("%c",priorityQueue.peek().name);
//			priorityQueue.poll();
//		}
//		System.out.println(priorityQueue.size());
//		Encoding(priorityQueue);
	}
	
//	/**
//	 * This method is redefine the order of priorityQueue
//	 */
//	Comparator<Node> orderComparator = new Comparator<Node>() {
//		public int compare(Node char1 , Node char2){
//			int char1Frequency = char1.frequency;
//			int char2Frequency = char2.frequency;
//			if (char1Frequency > char2Frequency) {
//				return 1;
//			}else if (char1Frequency < char2Frequency) {
//				return -1;
//			}else {
//				return 0;
//			}
//		}
//	};
	
	/**
	 * This method is to encode the inputstring and construct Huffman tree
	 */
	public void Encoding(){
		System.out.println("size is "+priorityQueue.size());
		
		//construct the Huffman tree
		while (priorityQueue.size()>1) {
			Node node = new Node();
			Node x = new Node();
			Node y = new Node();
			node.left = x = priorityQueue.poll();
			node.right = y = priorityQueue.poll();
			node.frequency = x.frequency+y.frequency;
			priorityQueue.offer(node);
		}
		
		//process the Huffman tree
		HuffmanTree huffmanTree = new HuffmanTree();
		rootNode = priorityQueue.poll();
		huffmanTree.setRoot(rootNode);
		huffmanTree.setBinaryTreeArray(rootNode);
		huffmanTree.printTree(rootNode);
		huffmanTree.write();
		
		
		//to output the encoding string
		mapTable = huffmanTree.getNodeTable().getNodeTable();
		for (int i = 0; i < this.inputString.length(); i++) {
			char c = inputString.charAt(i);
			String binaryString = mapTable.get(c);
			this.outputString += binaryString;
		}
		
		System.out.println("This input encode string is :");
		System.out.println(this.outputString);
	}
	
	
	
	
	
	
	
	

}
