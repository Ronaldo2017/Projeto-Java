package com.br.thread;

import java.awt.Dimension;

import javax.swing.JDialog;

public class TelaTimeThread extends JDialog {
	
	//EXECUTA O QUE TIVER DENTRO NO MOMENTO DA EXECU��O
	public TelaTimeThread() {
		//configura��es iniciais da tela
		setTitle("Tela de time com Thread");
		setSize(new Dimension(340, 340));
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		//sempre o �ltimo a ser executado
		//tela fica visivel ao usuario
		setVisible(true);
	}

}
