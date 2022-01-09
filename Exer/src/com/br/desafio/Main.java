package com.br.desafio;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int par = 0;
		int impar = 0;
		int positivo = 0;
		int negativo = 0;

		// continue a solução
		for (int i = 1; i <= 5; i++) {

			int a = leitor.nextInt();

			if (a != 0) {

				if (a < 0)
					negativo += 1;
				else
					positivo += 1;

				if (a % 2 == 0)
					par += 1;
				else
					impar += 1;

			} else
				par += 1; // o zero só é registado como par

		}

		// insira suas variaveis corretamente
		System.out.println(par + " par(es)");
		System.out.println(impar + " impar(es)");
		System.out.println(positivo + " positivo(s)");
		System.out.println(negativo + " negativo(s)");
	}

}
