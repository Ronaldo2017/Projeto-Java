package com.br.main;

import javax.swing.JOptionPane;

import com.br.rc.Aluno;
import com.br.rc.Disciplina;

public class ArrayVetor {
	public static void main(String[] args) {
		
		
		/*String posicoes = JOptionPane.showInputDialog("Informe as posições do array");
		
		//sempre deve ter a quantidade de poições definidas
		double[] notas = new double[Integer.parseInt(posicoes)];
		
		for(int pos = 0; pos < notas.length; pos++) {
			String valor = JOptionPane.showInputDialog("Informe o valor da posição " + (pos + 1));
			notas[pos] = Double.parseDouble(valor);
		}
		
		for(int pos = 0; pos < notas.length; pos++) {
			System.out.println("Nota " + (pos + 1) + " = " + notas[pos]);
		}*/
		
		//outra forma de declarar o array
		//double[] valores = {9.5,8.9,8.5};
		
		//varios tipos de dados
		//String[] valores = new String[4];
		/*String[] valores = {"Ronaldo","90","Java","contato@contato.com.br"};
		
		valores[0] = "Ronaldo";
		valores[1] = "";
		valores[2] = "";
		valores[3] = "";
		
		for(int pos = 0; pos < valores.length; pos++) {
			System.out.println("O valor na posição: " + (pos + 1) + " = " + valores[pos]);
		}*/
		
		double[] notas = {7.7,9.0,8.5,9.5};
		double[] notasBD = {6.7,9.0,8.8,9.8};
		
		Aluno aluno = new Aluno();
		aluno.setNome("Ronaldo");
		aluno.setNomeEscola("JDEV TREINAMENTOS");
		
		//criando a disciplina
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplina("Curso de Java");
		disciplina.setNota(notas);
		
		aluno.getDisciplinas().add(disciplina);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Banco de dados");
		disciplina2.setNota(notasBD);		
		
		aluno.getDisciplinas().add(disciplina2);
		
		
		//criando array de alunos
		Aluno[] arrayAlunos = new Aluno[1];
		
		arrayAlunos[0] = aluno;
		
		for(int pos = 0; pos < arrayAlunos.length; pos++) {
			System.out.println("Nome do aluno: " + arrayAlunos[pos].getNome());
			
			
			//loop de disciplinas
			for (Disciplina d : arrayAlunos[pos].getDisciplinas()) {
				System.out.println("Nome da disciplina: " + d.getDisciplina());
				
				//loop de notas
				for(int posNota = 0; posNota < d.getNota().length; posNota++) {
					System.out.println("Nota número: " + (posNota + 1) + " = " + d.getNota()[posNota]);
				}
			}
			
			
		}
		
		
		
		
		
		
		//varendo o objeto, nao sendo do tipo lista
		//pegando uma lista de disciplina
		/*System.out.println("Nome do aluno: " + aluno.getNome() + " curso: " + 
		aluno.getNomeEscola());
		System.out.println("---------Disciplina do aluno-----------");
		for(Disciplina disci: aluno.getDisciplinas()) {
						
			System.out.println("Disciplina: " + disci.getDisciplina());
			
			double notaMax = 0;
			
			for(int pos = 0; pos < disci.getNota().length;pos++) {
				System.out.println("Notas: " + (pos + 1) + " = " + disci.getNota()[pos]);
				
				if(pos == 0) {
					notaMax = disci.getNota()[pos];
				}else if(disci.getNota()[pos] < notaMax) {
					notaMax = disci.getNota()[pos];
				} 
			}
			System.out.println("Maior nota: " + disci.getDisciplina() + " " + notaMax); 
		}*/
		
	}

}
