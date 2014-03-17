package huffmancode;

public class Node {
	public int frequency;
	public char name;
	public Node left;
	public Node right;
	public String binary = "";
	
	
	/**
	 * update the binary
	 * @param binary
	 */
	public void binaryDigit(String binary) {
		this.binary += binary;
	}
	
	
}
