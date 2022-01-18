package com.br.excessao;

public class ExecaoProcessarNota extends Exception {
	
	
	public ExecaoProcessarNota(String erro) {
		super("Erro ao processar o arquivo de notas do aluno." + erro);
	}

}
