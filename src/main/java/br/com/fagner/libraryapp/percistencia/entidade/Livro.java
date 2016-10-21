package br.com.fagner.libraryapp.percistencia.entidade;

public class Livro {
	private int id;
	private String nome;
	private String edicao;
	private String adaptacao;
	private int quantidade;
	private Editora editora;
	private Autor autor;
	private String serie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getAdaptacao() {
		return adaptacao;
	}
	public void setAdaptacao(String adaptacao) {
		this.adaptacao = adaptacao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
			
	
	
		}
	

