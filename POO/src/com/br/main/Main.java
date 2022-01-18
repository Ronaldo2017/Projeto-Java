package com.br.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.br.classesauxiliares.FuncaoAutenticacao;
import com.br.constantes.StatusAluno;
import com.br.excessao.ExecaoProcessarNota;
import com.br.interfaces.PermitirAcesso;
import com.br.rc.Aluno;
import com.br.rc.Diretor;
import com.br.rc.Disciplina;
import com.br.rc.Secretario;

/*
 * INSTÂNCIA = CRIAÇÃO DO OJETO
 * REFERÊNCIA = É A VARIÁVEL CRIADA EX. aluno1
 * ATRIBUTOS = SÃO OS TIPOS DE DADOS DA CLASSE EX. CLASSE ALUNO
 */

public class Main {

	public static void main(String[] args) {

				
		try {
			
			lerArquivo();
			
			String login = JOptionPane.showInputDialog("Login");
			String senha = JOptionPane.showInputDialog("Senha");

			// PermitirAcesso permitirAcesso = new Secretario(login, senha);

			// Secretario secretario = new Secretario();//diretamente com o objeto

			// interface
			// PermitirAcesso secretario = new Secretario();

			/*
			 * secretario.setLogin(login); secretario.setSenha(senha);
			 */

			// new Secretario.autenticar(login, senha)
			// permitirAcesso.autenticar()
			if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()
					|| new Secretario(login, senha).autenticar()) {

				List<Aluno> alunos = new ArrayList<Aluno>();

				// hashmap - carrega dados e recuperar o valor do valor
				// é uma lista, que dentro dela tem uma chave que identifica
				// uma sequencia de valores tambem
				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				/*
				 * List<Aluno> alunosAprovados = new ArrayList<Aluno>(); List<Aluno>
				 * alunosRecuperacao = new ArrayList<Aluno>(); List<Aluno> alunosReprovados =
				 * new ArrayList<Aluno>();
				 */

				for (int qtd = 1; qtd <= 1; qtd++) {

					String nome = JOptionPane.showInputDialog("Qual o nome do aluno?");
					/*
					 * String idade = JOptionPane.showInputDialog("Qual a idade?"); String dataNasc
					 * = JOptionPane.showInputDialog("Qual a data de nascimento?"); String matricula
					 * = JOptionPane.showInputDialog("Data da matricula?"); String rg =
					 * JOptionPane.showInputDialog("Qual o RG?"); String cpf =
					 * JOptionPane.showInputDialog("Qual o CPF?"); String escola =
					 * JOptionPane.showInputDialog("Nome da escola?"); String serie =
					 * JOptionPane.showInputDialog("Qual a série?");
					 */

					// new Aluno() = é uma instancia, criação do objeto
					// aluno1 = referencia ao objeto
					Aluno aluno1 = new Aluno();
					aluno1.setNome(nome);
					/*
					 * aluno1.setIdade(Integer.valueOf(idade)); aluno1.setDataNasc(dataNasc);
					 * aluno1.setDataMatricula(matricula); aluno1.setRg(rg); aluno1.setCpf(cpf);
					 * aluno1.setNomeEscola(escola); aluno1.setSerieMatriculado(serie);
					 */
					// lista dinamica de disciplina
					for (int i = 1; i <= 1; i++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + i);
						String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + i);
						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
						//disciplina.setNota(Double.parseDouble(notaDisciplina));

						aluno1.getDisciplinas().add(disciplina);
					}

					// remover disciplina
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					if (escolha == 0) {
						int remover = 0;
						int posicao = 1;
						while (remover == 0) {
							String removerDisciplina = JOptionPane.showInputDialog("Qual a disciplina - 1, 2, 3, 4 ?");
							aluno1.getDisciplinas().remove(Integer.valueOf(removerDisciplina).intValue() - posicao);
							posicao++;
							remover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
						}

					}

					// cria lista disciplina
					/*
					 * Disciplina disciplinaB = new Disciplina();
					 * disciplinaB.setDisciplina("Banco de dados"); disciplinaB.setNota(85);
					 * 
					 * Disciplina disciplinaJ = new Disciplina(); disciplinaJ.setDisciplina("Java");
					 * disciplinaJ.setNota(85);
					 * 
					 * Disciplina disciplinaJS = new Disciplina();
					 * disciplinaJS.setDisciplina("JavaScript"); disciplinaJS.setNota(78);
					 * 
					 * aluno1.getDisciplinas().add(disciplinaB);
					 * aluno1.getDisciplinas().add(disciplinaJS);
					 * aluno1.getDisciplinas().add(disciplinaJ);
					 */

					/*
					 * System.out.println("O nome é: " + aluno1.getNome());
					 * System.out.println("Idade é: " + aluno1.getIdade());
					 * System.out.println("Rg: " + aluno1.getRg()); System.out.println("CPF: " +
					 * aluno1.getCpf());
					 */

					alunos.add(aluno1);

				}

				// HASHMAP, INICIA A LISTA com a chave e o valor
				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

				// lista de alunos
				for (Aluno aluno : alunos) {

					if (aluno.getAlunoAprova().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
					} else if (aluno.getAlunoAprova().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					} else {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}
				}

				System.out.println("------------Lista dos Aprovados---------------");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println("Aluno: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprova()
							+ " com média de: " + aluno.getMediaNota());
				}

				System.out.println("------------Lista de Recuperação---------------");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println("Aluno: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprova()
							+ " com média de: " + aluno.getMediaNota());
				}

				System.out.println("------------Lista dos Reprovados---------------");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println("Aluno: " + aluno.getNome() + " Resultado: " + aluno.getAlunoAprova()
							+ " com média de: " + aluno.getMediaNota());
				}

			} else {
				JOptionPane.showMessageDialog(null, "Acesso não permitido!");
			}

			// percorrer a lista pela posição
			/*
			 * for(int pos = 0; pos < alunos.size(); pos++) { Aluno aluno = alunos.get(pos);
			 * 
			 * if(aluno.getNome().equalsIgnoreCase("juca")) { Aluno trocar = new Aluno();
			 * trocar.setNome("Aluno foi trocado");
			 * 
			 * Disciplina disciplina = new Disciplina();
			 * disciplina.setDisciplina("Matematica"); disciplina.setNota(95);
			 * 
			 * trocar.getDisciplinas().add(disciplina);
			 * 
			 * alunos.set(pos, trocar); aluno = alunos.get(pos); }
			 * 
			 * System.out.println(aluno.getNome());
			 * 
			 * for (Disciplina disc : aluno.getDisciplinas()) {
			 * System.out.println(aluno.getDisciplinas()); } }
			 */

			/*
			 * for (Aluno aluno : alunos) {
			 * 
			 * if (aluno.getNome().equalsIgnoreCase("juca")) {
			 * 
			 * alunos.remove(aluno); break; }else { System.out.println(aluno);
			 * System.out.println("Disciplinas: " + aluno.getDisciplinas());
			 * System.out.println("Média das notas: " + aluno.getMediaNota());
			 * System.out.println("Resultado: " + (aluno.getAprova() ? "Aprovado!" :
			 * "Reprovado!")); System.out.println(
			 * "-----------------------------------------------------------------"); } }
			 * 
			 * for (Aluno aluno : alunos) {
			 * System.out.println("Aluno que sobraram na lista");
			 * System.out.println(aluno.getNome()); System.out.println("Suas materias são");
			 * for(Disciplina disciplina : aluno.getDisciplinas()) {
			 * System.out.println(disciplina.getDisciplina()); } }
			 */

			/*
			 * Equals e hascode (diferenciar e comparar objetos)
			 */

			/*
			 * Aluno aluno1 = new Aluno(); aluno1.setNome("Juca");
			 * 
			 * Aluno aluno2 = new Aluno(); aluno2.setNome("Juca");
			 * 
			 * if(aluno1.equals(aluno2)) { System.out.println("Alunos são iguais"); }else {
			 * System.out.println("Alunos não são iguais"); }
			 */
		} catch (NumberFormatException e) {

			StringBuilder saida = new StringBuilder();
			e.printStackTrace();

			for (int i = 0; i < e.getStackTrace().length; i++) {
				System.out.println("Classe de erro: " + e.getStackTrace()[i].getClassName());
				System.out.println("Classe de erro: " + e.getStackTrace()[i].getMethodName());
				System.out.println("Classe de erro: " + e.getStackTrace()[i].getLineNumber());
			}

			JOptionPane.showMessageDialog(null, "Erro inesperado, " + "entre em contato com o suporte!");
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Erro inesperado, " + "entre em contato com o suporte!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro da exeção customizada");
		} finally {// sempre é executado ocorrendo erros ou não
			JOptionPane.showMessageDialog(null, "Aprendendo JAVA!!!");
		}

	}

	public static void lerArquivo() throws  FileNotFoundException {
		///try {ExecaoProcessarNota,
			File fil = new File("lines.txt");
			Scanner scan = new Scanner(fil);
		//} catch (FileNotFoundException e) {
			//throw new ExecaoProcessarNota(e.getMessage());
		//}
	}

}
