package huffmancode;

public class HuffmanTree {
	private Node root;
	private String output = "";
	private NodeTable nodeTable = new NodeTable();
	
	

	public NodeTable getNodeTable() {
		return nodeTable;
	}

	public void setNodeTable(NodeTable nodeTable) {
		this.nodeTable = nodeTable;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * This method is to print the node from the root element
	 */
	public void printTree(Node node){
		if (node.left != null && node.right != null) {
			printTree(node.left);
			printTree(node.right);
		}else {
			nodeTable.put(node.name, node.binary);
			output += node.name +" = "+ node.binary + " , ";
		}
	}
	
	/**
	 * This method is to setBinary of Huffman tree
	 * @param node huffman node
	 */
	public void setBinaryTreeArray(Node node){
		if (node.left != null) {
			Node nodeLeft = node.left;
			nodeLeft.binaryDigit(node.binary+"0");
			setBinaryTreeArray(nodeLeft);
		}
		if (node.right != null) {
			Node nodeRight = node.right;
			nodeRight.binaryDigit(node.binary+"1");
			setBinaryTreeArray(nodeRight);
		}
	}
	/**
	 * This method is output the encoding result 
	 */
	public void write(){
		System.out.println("The Huffman tree is ");
		System.out.println(output);
	}
}
