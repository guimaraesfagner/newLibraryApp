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
			
		try (PreparedStatement preparador = con.prepareStatement(sql)){
		
		//Criando um Statement
		preparador.setString(1, livro.getNome());
		preparador.setString(2, livro.getEdicao());
		preparador.setString(3, livro.getAdaptacao());
		preparador.setInt(4, livro.getQuantidade());
		preparador.setString(5, livro.getSerie());
		preparador.setInt(6, livro.getEditora().getId());
		preparador.setInt(7, livro.getAutor().getId());
		
			//Executa SQL no banco
		preparador.execute();
		
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}

	public void alterar(Livro livro) {
		
		
		String sql = "update livro set livro_nome='?', livro_edicao='?', "
				+ "livro_adaptacao='?', livro_quantidade=?, "
				+ "livro_serie='?', editora_id=?, autor_id=? where livro_id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			//Criando um Statement
		
		preparador.setString(1, livro.getNome());
		preparador.setString(2, livro.getEdicao());
		preparador.setString(3, livro.getAdaptacao());
		preparador.setInt(4, livro.getQuantidade());
    	preparador.setString(5, livro.getSerie());
		preparador.setInt(6, livro.getEditora().getId());
		preparador.setInt(7, livro.getAutor().getId());
		preparador.setInt(8, livro.getId());
		
		//Executa SQL no banco
		preparador.executeUpdate();
		
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
