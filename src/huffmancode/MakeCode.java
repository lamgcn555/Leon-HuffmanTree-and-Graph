package huffmancode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;

public class MakeCode {
	public static void main(String[] args){
		String content = null;
		try {
			
			
			//--------------------test----------------------------
			File huffmanFile = new File("C:\\Users\\Administrator\\temp\\Huffman.txt");
			String encodString = "GBK";
			if (huffmanFile.isFile()&&huffmanFile.exists()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(huffmanFile),encodString);
				BufferedReader bufferedReader = new BufferedReader(reader);
				while ((content = bufferedReader.readLine())!=null) {
					System.out.println(content);
					
					//encode
					HuffmanEncode huffmanEncode = new HuffmanEncode(content);
					huffmanEncode.Encoding();
					
					//decode
					HuffmanDecode huffmanDecode = new HuffmanDecode(huffmanEncode.getOutputString(),huffmanEncode.getRootNode());
					huffmanDecode.decoding();
				}
			}
			//--------------------test----------------------------
			
			
			
			
			
			
//			System.out.println("please input here: ");
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//			String string = bufferedReader.readLine();
//			
//			//encode
//			HuffmanEncode huffmanEncode = new HuffmanEncode(string);
//			huffmanEncode.Encoding();
//			
//			//decode
//			HuffmanDecode huffmanDecode = new HuffmanDecode(huffmanEncode.getOutputString(),huffmanEncode.getRootNode());
//			huffmanDecode.decoding();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
