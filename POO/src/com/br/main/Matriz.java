package com.br.main;

public class Matriz {

	public static void main(String[] args) {

		int notas[][] = new int[2][3];

		notas[0][0] = 95;
		notas[0][1] = 80;
		notas[0][2] = 90;

		notas[1][0] = 50;
		notas[1][1] = 80;
		notas[1][2] = 90;

		for (int posLinha = 0; posLinha < notas.length; posLinha++) {
			System.out.println("===================================");
			for (int posColuna = 0; posColuna < notas[posLinha].length; posColuna++) {
				System.out.println("Valor da matriz: " + notas[posLinha][posColuna]);
			}
		}

	}

}
