package br.com.fagner.libraryapp.percistencia.entidade;

public class Funcionario extends Pessoa {
	private String funcao;
	private Livro livro;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Livro manterLivros(){
	return livro;
	}
	
}
