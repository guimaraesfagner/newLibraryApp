package br.com.fagner.newLibraryApp;

import br.com.fagner.libraryapp.percistencia.entidade.Autor;
import br.com.fagner.libraryapp.percistencia.entidade.Editora;
import br.com.fagner.libraryapp.percistencia.entidade.Livro;
import br.com.fagner.libraryapp.percistencia.jdbc.LivroDAO;

public class TesteLivroDAO {

	public static void main(String[] args) {
		//testeCadastrar();
		testeBuscaPorId();
	}
	
		private static void testeBuscaPorId() {
			LivroDAO livroDAO = new LivroDAO();
			Livro livro = livroDAO.buscaPorId(17);
			System.out.println(livro);
	}

		public static void testeCadastrar() {
		
		// Criando usuário (com sua editora e autor
		
		Editora editora = new Editora();
		editora.setId(18);
		//editora.setNome("Sextante");
		Autor autor = new Autor();
		autor.setId(18);
		//autor.setNome("Douglas Adams");
		Livro livro  = new Livro();
		livro.setNome("Guia do mochileiro das galáxias");
		livro.setEdicao("2a edição");
		livro.setAdaptacao("");
		livro.setQuantidade(1);
		livro.setSerie("Trilogia de Cinco");
		livro.setEditora(editora);
		livro.setAutor(autor);
		
		//inserindo o usuário no banco
		
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.cadastrar(livro);
		
		System.out.println("Cadastrado com Sucesso");
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
			livro.setId(2);
			livro.setNome("João da silva");
			livro.setAdaptacao("Maria José");
			livro.setEdicao("Quarta Edicao");
			livro.setQuantidade(3);
			livro.setSerie("Trilogia de 5");
			livro.setAutor(autor);
			livro.setEditora(editora);
			
		
			//inserindo o usuário no banco
			
			LivroDAO livroDAO = new LivroDAO();
			livroDAO.alterar(livro);
			
			System.out.println("Cadastrado com Sucesso");

		}	

		
		public static void testeExcluir() {
		
		// Criando usuário com seu id para exclusão
		
		Livro livro  = new Livro();
		livro.setId(1);
		
		//inserindo o usuário no objeto
		
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.excluir(livro);
		
		System.out.println("Excluido com Sucesso!!!");
	}

		public static void testeSalvar() {
			// Alerando usuário (com sua editora e autor
			
			Editora editora = new Editora();
			editora.setId(5);
			editora.setNome("testeNovo");
			Autor autor = new Autor();
			autor.setId(5);
			autor.setNome("Fazedor de Livrossss");
			
			Livro livro  = new Livro();
			//livro.setId(1);
			livro.setNome("João da silvaaaaaaa");
			livro.setAdaptacao("Maria José");
			livro.setEdicao("Quarta Edicao");
			livro.setQuantidade(3);
			livro.setSerie("Trilogia de 5");
			livro.setAutor(autor);
			livro.setEditora(editora);
			
		
			//inserindo o usuário no banco
			
			LivroDAO livroDAO = new LivroDAO();
			livroDAO.salvar(livro);
			
			System.out.println("Salvo com Sucesso");

		}	


}

