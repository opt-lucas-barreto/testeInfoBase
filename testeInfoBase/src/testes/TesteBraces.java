package testes;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteBraces {
	
	public static void main(String[] args) {
		try{
			FileReader file = new FileReader("/home/lucas/arquivoBraces.txt");
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\n");
			while (scanner.hasNext()) {
				String braces = scanner.next();
				System.out.print(braces+" - ");
				System.out.println(verifyBraces(braces));
			}
			scanner.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static boolean verifyBraces(String arg) {
		
		if(arg == null)
			return false;

		char[] openers = {'(', '{', '['};
		char[] closers = {')', '}', ']'};
		char[] braces = arg.toCharArray();
		
		List<Integer> parentOpen = new ArrayList<>();
		List<Integer> chavesOpen = new ArrayList<>();
		List<Integer> colcheOpen = new ArrayList<>();
		
		parentOpen.add(-1);
		chavesOpen.add(-1);
		colcheOpen.add(-1);
		
		if(braces[0] == closers[0] || braces[0] == closers[1] || braces[0] == closers[2])
			return false;
		
		for(int i = 0; i < braces.length; i++ ) {
			if(braces[i] == openers[0]) {
				parentOpen.add(i);
			}else if(braces[i] == openers[1]) {
				chavesOpen.add(i);
			}else if(braces[i] == openers[2]) {
				colcheOpen.add(i);
			}else if(braces[i] == closers[0]) {
				if((chavesOpen.get(chavesOpen.size()-1) > parentOpen.get(parentOpen.size()-1)) 
						|| (colcheOpen.get(colcheOpen.size()-1) > parentOpen.get(parentOpen.size()-1))){
					return false;
				}else {
					parentOpen.remove(parentOpen.size()-1);
				}
			}else if(braces[i] == closers[1]) {
				if((parentOpen.get(parentOpen.size()-1) > chavesOpen.get(chavesOpen.size()-1)) 
						|| (colcheOpen.get(colcheOpen.size()-1) > chavesOpen.get(chavesOpen.size()-1))){
					return false;
				}else {
					chavesOpen.remove(chavesOpen.size()-1);
				}
			}else if(braces[i] == closers[2]) {
				if((chavesOpen.get(chavesOpen.size()-1) > colcheOpen.get(colcheOpen.size()-1)) 
						|| (parentOpen.get(parentOpen.size()-1) > colcheOpen.get(colcheOpen.size()-1))){
					return false;
				}else {
					colcheOpen.remove(colcheOpen.size()-1);
				}
			}
		}
		return true;
	}
}
