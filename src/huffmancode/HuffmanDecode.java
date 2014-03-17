package huffmancode;

public class HuffmanDecode {
	private String huffmanString = "";
	private String originalString = "";
	private Node root;

	public String getHuffmanString() {
		return huffmanString;
	}

	public void setHuffmanString(String huffmanString) {
		this.huffmanString = huffmanString;
	}
	
	public HuffmanDecode(String string,Node root){
		this.huffmanString = string;
		this.root = root;
	}
	
	public void decoding(){
		Node currentNode = this.root;
		for (int i = 0; i < this.huffmanString.length(); i++) {
			char c = this.huffmanString.charAt(i);
			
            //find the leaf
			if (c == '0') {
				currentNode = currentNode.left;
			}else {
				currentNode = currentNode.right;
			}
			
			//decoding if currentNode is not leaf we will continue loop
			if(currentNode.left != null && currentNode.right != null) {
				
				continue;
				
			}else {
				this.originalString += currentNode.name;
				currentNode = this.root;
			}
			
		}
		
		this.printOriginalString();
	}
	
	private void printOriginalString(){
		System.out.println("This original string is :");
		System.out.println(this.originalString);
	}
}
