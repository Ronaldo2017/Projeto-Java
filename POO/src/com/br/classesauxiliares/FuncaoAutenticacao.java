package com.br.classesauxiliares;

import com.br.interfaces.PermitirAcesso;

//receber alguem que tenha o contrato da interface de PermitirAcesso
//e chamar o autenticar
public class FuncaoAutenticacao {
	
	private PermitirAcesso permitirAcesso;
	
	//nos paramentros, insere a interface
	/*public boolean autenticarCursoJava(PermitirAcesso acesso) {
		return acesso.autenticar();
	}*/
	
	public boolean autenticar() {
		return permitirAcesso.autenticar();
	}
	
	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}

}
