package br.com.fagner.libraryapp.percistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.fagner.libraryapp.percistencia.entidade.Livro;

public class LivroDAO {
	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Livro livro) {
	
		String sql = "insert into livro (livro_nome, livro_edicao, livro_adaptacao, livro_quantidade, livro_serie) values (?,?,?,?,?); "
				   + "insert into editora (editora_nome) values (?); "
				   + "insert into autor (autor_nome) values (?)";
			
		try (PreparedStatement ps = con.prepareStatement(sql)){
		
		//Criando um Statement
		ps.setString(1, livro.getNome());
		ps.setString(2, livro.getEdicao());
		ps.setString(3, livro.getAdaptacao());
		ps.setInt(4, livro.getQuantidade());
		ps.setString(5, livro.getSerie());
		ps.setInt(6, livro.getEditora().getId());
		ps.setInt(7, livro.getAutor().getId());
		
			//Executa SQL no banco
		ps.execute();
		
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}

	public void alterar(Livro livro) {
		
		System.out.println(livro.getId());
		System.out.println(livro.getNome());
		System.out.println(livro.getAdaptacao());
		System.out.println(livro.getEdicao());
		System.out.println(livro.getQuantidade());
		System.out.println(livro.getSerie());
		System.out.println(livro.getAutor().getId());
		System.out.println(livro.getEditora().getId());
		
		
		String sql = "update livro set livro_nome=?, livro_edicao=?, "
				+ "livro_adaptacao=?, livro_quantidade=?, "
				+ "livro_serie=?, editora_id=?, autor_id=? where livro_id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//Criando um Statement
		
		ps.setString(1, livro.getNome());
		ps.setString(2, livro.getEdicao());
		ps.setString(3, livro.getAdaptacao());
		ps.setInt(4, livro.getQuantidade());
    	ps.setString(5, livro.getSerie());
		ps.setInt(6, livro.getEditora().getId());
		ps.setInt(7, livro.getAutor().getId());
		ps.setInt(8, livro.getId());
		
		//Executa SQL no banco
		ps.execute();
		ps.close();
		
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
