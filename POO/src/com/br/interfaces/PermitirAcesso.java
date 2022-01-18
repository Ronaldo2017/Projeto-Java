package com.br.interfaces;

//essa interface sera o nosso contrato de autenticação
public interface PermitirAcesso {

	//somente declaração do metodo
	public boolean autenticar(String login, String senha);
	
	public boolean autenticar();
}
