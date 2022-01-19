package com.br.thread;

import java.awt.Dimension;

import javax.swing.JDialog;

public class TelaTimeThread extends JDialog {
	
	//EXECUTA O QUE TIVER DENTRO NO MOMENTO DA EXECUÇÃO
	public TelaTimeThread() {
		//configurações iniciais da tela
		setTitle("Tela de time com Thread");
		setSize(new Dimension(340, 340));
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		//sempre o último a ser executado
		//tela fica visivel ao usuario
		setVisible(true);
	}

}
