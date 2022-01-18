package com.br.main;

import com.br.rc.Aluno;
import com.br.rc.Diretor;
import com.br.rc.Pessoa;
import com.br.rc.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Ronaldo");
		aluno.setIdade(16);
		
		Diretor diretor = new Diretor();
		diretor.setRg("4342354");
		diretor.setIdade(50);
		
		Secretario secretario = new Secretario();
		secretario.setCpf("23453458340985");
		secretario.setIdade(18);
		
		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);
		
		System.out.println(aluno.pessoaMaiorIdade() + " " + aluno.msgMaiorIdade() + aluno.salario());
		System.out.println(diretor.pessoaMaiorIdade() + " " + diretor.salario());
		System.out.println(secretario.pessoaMaiorIdade() + " " + secretario.salario());
		
		teste(aluno);
		teste(diretor);
		teste(secretario);
		
	}
	
	//por causa do polimorfismo
	public static void teste(Pessoa pessoa) {
		System.out.println("Esse cara é demais = " + pessoa.getNome() + " " + pessoa.salario());
	}
	
}
