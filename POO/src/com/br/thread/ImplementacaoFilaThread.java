package com.br.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("Fila rodando");

		while (true) {
			Iterator iteracao = pilha_fila.iterator();
			// bloquear o acesso a lista por outros processos
			synchronized (iteracao) {

				// enquanto conter dados na lista processa
				while (iteracao.hasNext()) {
					// pega o objeto atual
					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();

					System.out.println("---------------------------------");
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());

					iteracao.remove();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
