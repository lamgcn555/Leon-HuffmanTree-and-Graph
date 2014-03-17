package huffmancode;

import java.util.HashMap;
import java.util.Map;

public class NodeTable {
	private Map<Character, String> nodeTable = new HashMap<Character, String>();
	
	
	public Map<Character, String> getNodeTable() {
		return nodeTable;
	}


	public void setNodeTable(Map<Character, String> nodeTable) {
		this.nodeTable = nodeTable;
	}

	
	public void put(Character character,String string){
		this.nodeTable.put(character, string);
	}

}
