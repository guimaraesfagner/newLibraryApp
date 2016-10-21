package br.com.fagner.libraryapp.percistencia.entidade;

import java.util.Date;

public class Emprestimo {
	
	private Date dataEmprestimo;
	private Date dataDevolução;
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolução() {
		return dataDevolução;
	}
	public void setDataDevolução(Date dataDevolução) {
		this.dataDevolução = dataDevolução;
	}
	
	
	public void realizarEmprestimo(){
		
	}
	
	public void realizarDevolucao(){
		
	}

}
