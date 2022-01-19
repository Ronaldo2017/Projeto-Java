package com.br.thread;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {
		// thread processando em paralelo
		Thread threadEmail = new Thread(tEmail);
		threadEmail.start();// liga a thread, que fica processando paralelamente por trás dos panos

	
		// thread processando em paralelo envio de nota fiscal
		Thread threadNotaFiscal = new Thread(tNotaFiscal);
		threadNotaFiscal.start();// liga a thread, que fica processando paralelamente por trás dos panos

		
		
		// rotina do sistema do usuario continua o fluxo de trabalho	
		// fluxo do sistema
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário.");

	}

	private static Runnable tNotaFiscal = new Runnable() {
		
		public void run() {
			//codigo da rotina
			//rotina para executar em paralelo
			for(int pos = 0; pos < 10; pos++) {
				
				//ex. de envio de email com thread
				//executar o envio com tempo de parada, ou tempo determinado
				System.out.println("Rotina envio de nota fiscal: " );
				
				try {//tempo de envio da rotina
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("********************");
			System.out.println("CHEGOU AO FIM DO CÓDIGO DE TESTE DA THREAD");
		}
			
		};

	private static Runnable tEmail =new Runnable(){

		public void run(){
		// codigo da rotina
		// rotina para executar em paralelo
		for(int pos=0;pos<10;pos++){
	
		// ex. de envio de email com thread
		// executar o envio com tempo de parada, ou tempo determinado
		System.out.println("Rotina envio de email: ");
	
		try{// tempo de envio da rotina
		Thread.sleep(1000);}catch(InterruptedException e){
		e.printStackTrace();}}System.out.println("********************");}

	};

}
