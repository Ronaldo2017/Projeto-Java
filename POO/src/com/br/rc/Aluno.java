package com.br.rc;

import java.util.ArrayList;
import java.util.List;

import com.br.constantes.StatusAluno;

public class Aluno extends Pessoa{
	// atributo da classe
	
	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(String nomePadrao, int idadePadrao) {
		nome = nomePadrao;
		idade = idadePadrao;
	}

	// getters e setters
	// set = adiciona o valor para o atributo
	// get = resgata ou obtem o valor do atributo
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	public double getMediaNota() {

		double somaNotas = 0.0;

		for (Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getMediaNotas();
		}

		return somaNotas / disciplinas.size();
	}

	public boolean getAprova() {
		double media = this.getMediaNota();

		if (media >= 70) {
			return true;
		} else {
			return false;
		}
	}

	public String getAlunoAprova() {
		double media = this.getMediaNota();
		if(media >= 50) {
			if(media >= 70) {
				return StatusAluno.APROVADO;
			}else {
				return StatusAluno.RECUPERACAO;
			}
		}else {
			return StatusAluno.REPROVADO;
		}
	}

	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNasc=" + dataNasc + ", rg=" + rg + ", cpf=" + cpf
				+ ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", dataMatricula=" + dataMatricula + ", nomeEscola="
				+ nomeEscola + ", serieMatriculado=" + serieMatriculado + "]";
	}

	/*
	 * public int hashCode() { final int prime = 31; int result = 1; result = prime
	 * * result + ((nome == null) ? 0 : nome.hashCode()); return result; }
	 * 
	 * public boolean equals(Object obj) { if (this == obj) return true; if (obj ==
	 * null) return false; if (getClass() != obj.getClass()) return false; Aluno
	 * other = (Aluno) obj; if (nome == null) { if (other.nome != null) return
	 * false; } else if (!nome.equals(other.nome)) return false; return true; }
	 */
	
	@Override//identifica o método sobreescrita
	public boolean pessoaMaiorIdade() {
		return idade >= 21;
	}
	
	public String msgMaiorIdade() {
		return this.pessoaMaiorIdade() ? "Aluno maioir de idade!" : "Aluno menor de idade";
	}

	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return 15000.00;
	}

}
