package br.com.fagner.libraryapp.percistencia.entidade;

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
