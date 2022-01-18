package com.br.main;


import java.util.Arrays;
import java.util.List;

public class SplitArray {
	
	public static void main(String[] args) {
		/*
		 * para fazer o split na string, o texto deve ter o mesmo padrão
		 * se for , tem que ser em todo o texto
		 */
		String text = "Ronaldo, curso Java, 80, 90, 75, 85";
		
		String[] valoresArray = text.split(",");
		
		System.out.println("Nome: "  + valoresArray[0]);
		System.out.println("Nota1: " + valoresArray[1]);
		System.out.println("Nota2: " + valoresArray[2]);
		System.out.println("Nota3: " + valoresArray[3]);
		System.out.println("Nota4: " + valoresArray[4]);
		System.out.println("Nota5: " + valoresArray[5]);
		
		System.out.println("***********************************************");
		/*
		 * converter o array em lista
		 */
		
		List<String> list = Arrays.asList(valoresArray);
		
		for (String valorString : valoresArray) {
			System.out.println(valorString);
		}
		
		/*Converter uma lista para array*/
		String[] conversaoArray = list.toArray(new String[6]);
		
		for(int pos = 0; pos < conversaoArray.length; pos++) {
			System.out.println(conversaoArray[pos]);
		}
	}

}
