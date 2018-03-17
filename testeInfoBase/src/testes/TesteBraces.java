package testes;

import java.io.FileReader;
import java.util.Scanner;

public class TesteBraces {
	
	public static void main(String[] args) {
		try{
			FileReader file = new FileReader("/home/lucas/arquivoBraces.txt");
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\n");
			while (scanner.hasNext()) {
				System.out.println(verifyBraces(scanner.next()));
			}
			scanner.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean verifyBraces(String arg) {
		
		return false;
	}
}
