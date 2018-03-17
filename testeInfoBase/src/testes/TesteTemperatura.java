package testes;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TesteTemperatura {

	public static void main(String[] args) {
		List<BigDecimal> listaTemperaturas = new ArrayList<>();
		try{
			FileReader file = new FileReader("/home/lucas/arquivoTemp.txt");
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\||\\n");
			System.out.println("Lista de temperaturas");
			System.out.print("[");
			while (scanner.hasNext()) {
				BigDecimal temperatura = new BigDecimal(scanner.next().replaceAll(",", "."));
				System.out.print(temperatura+",");
				if(listaTemperaturas.size() < 10) {
					listaTemperaturas.add(temperatura);
					Collections.sort(listaTemperaturas);
				}else if(temperatura.compareTo(listaTemperaturas.get(0)) > 0) {
					if(temperatura.compareTo(listaTemperaturas.get(9)) > 0) {
						listaTemperaturas.add(temperatura);
						listaTemperaturas = listaTemperaturas.subList(1, listaTemperaturas.size());
						Collections.sort(listaTemperaturas);
						continue;
					}else {
						for(int i = 0; i <= listaTemperaturas.size(); i++ ) {
							if(temperatura.compareTo(listaTemperaturas.get(i)) == 0) {
								break;
							}else if(temperatura.compareTo(listaTemperaturas.get(i)) > 0) {
								continue;
							}else if(temperatura.compareTo(listaTemperaturas.get(i)) < 0) {
								listaTemperaturas.add(temperatura);
								listaTemperaturas = listaTemperaturas.subList(1, listaTemperaturas.size());
								Collections.sort(listaTemperaturas);
								break;
							}
						}
					}
				}
			}
			System.out.println("]");
			System.out.println("Ordenados");
			System.out.println(Arrays.toString(listaTemperaturas.toArray(new BigDecimal[0])));
			scanner.close();
	      }catch(IOException ioe){
	         ioe.printStackTrace();
	      }
	}

}
