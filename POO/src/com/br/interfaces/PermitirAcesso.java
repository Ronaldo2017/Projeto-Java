package com.br.interfaces;

//essa interface sera o nosso contrato de autentica��o
public interface PermitirAcesso {

	//somente declara��o do metodo
	public boolean autenticar(String login, String senha);
	
	public boolean autenticar();
}
