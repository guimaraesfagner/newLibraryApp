package br.com.fagner.libraryapp.modelo;

public class Administrador extends Funcionario {
	private Funcionario funcionario;
	private Aluno aluno;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	public Funcionario manterFuncionario(){
		
		return funcionario;
		
	}
	
	public Aluno manterAluno(){
		return aluno;
	}
}
