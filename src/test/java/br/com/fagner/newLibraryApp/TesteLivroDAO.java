package br.com.fagner.newLibraryApp;

import br.com.fagner.libraryapp.percistencia.entidade.Autor;
import br.com.fagner.libraryapp.percistencia.entidade.Editora;
import br.com.fagner.libraryapp.percistencia.entidade.Livro;
import br.com.fagner.libraryapp.percistencia.jdbc.LivroDAO;

public class TesteLivroDAO {

	public static void main(String[] args) {
		testeAlterar();
	}
	
	public static void testeAlterar() {
		// Alerando usuário (com sua editora e autor
		
		Editora editora = new Editora();
		editora.setId(1);
		editora.setNome("Recordsssss");
		Autor autor = new Autor();
		autor.setId(2);
		autor.setNome("Fazedor de Livrossss");
		
		Livro livro  = new Livro();
		livro.setId(1);
		livro.setNome("João da silva");
		livro.setAdaptacao("Maria José");
		livro.setEdicao("Quarta Edicao");
		editora.setId(1);
		autor.setId(2);
		livro.setQuantidade(3);
		livro.setSerie("Trilogia de 5");
		livro.setAutor(autor);
		livro.setEditora(editora);
		
	
		//inserindo o usuário no banco
		
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.alterar(livro);
		
		System.out.println("Cadastrado com Sucesso");

	}	
	public static void testeInserir() {
		
		// Criando usuário (com sua editora e autor
		
		Editora editora = new Editora();
		editora.setId(1);
		editora.setNome("Recordsssss");
		Autor autor = new Autor();
		autor.setId(2);
		autor.setNome("Fazedor de Livrossss");
		Livro livro  = new Livro();
		livro.setNome("TesteNomesss");
		livro.setEdicao("TerceiraEdicaossss");
		livro.setAdaptacao("Cagueissss");
		livro.setQuantidade(1);
		livro.setSerie("serie");
		livro.setEditora(editora);
		livro.setAutor(autor);
		
		//inserindo o usuário no banco
		
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.cadastrar(livro);
		
		System.out.println("Cadastrado com Sucesso");
	}

}
