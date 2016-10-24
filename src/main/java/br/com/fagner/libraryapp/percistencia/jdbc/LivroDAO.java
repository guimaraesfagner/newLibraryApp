package br.com.fagner.libraryapp.percistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fagner.libraryapp.percistencia.entidade.Autor;
import br.com.fagner.libraryapp.percistencia.entidade.Editora;
import br.com.fagner.libraryapp.percistencia.entidade.Livro;

public class LivroDAO {
	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Livro livro) {
	
		System.out.println(livro.getId());
		System.out.println(livro.getNome());
		System.out.println(livro.getAdaptacao());
		System.out.println(livro.getEdicao());
		System.out.println(livro.getQuantidade());
		System.out.println(livro.getSerie());
		System.out.println(livro.getAutor().getId());
		System.out.println(livro.getEditora().getId());
		
		
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
	
	
	public void excluir(Livro livro) {
		
		String sql = "delete from livro where livro_id=?";
			
		try (PreparedStatement ps = con.prepareStatement(sql)){
		
		//Criando um Statement
		ps.setInt(1, livro.getId());
		
			//Executa SQL no banco
		ps.execute();
		
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}

public void salvar(Livro livro) {
		
		if (livro.getId()!=null){
			alterar(livro);
			} else {
			cadastrar(livro);
		}
		
			}

/**
 * Busca de um registro no banco de dados pelo numedo do id do livro
 * @param id Inteiro que representa o numero do id do livro a ser buscado
 * @return Objeto Livro quando encontra ou null quando não encontra
 */

public Livro buscaPorId(int id){
	
	String sql ="select * from livro "
			+ "inner join editora on editora.editora_id=livro.editora_id "
			+ "inner join autor on autor.autor_id=livro.autor_id where livro_id=?";
	
	try (PreparedStatement ps = con.prepareStatement(sql)){
		
		ps.setInt(1, id);
		
		//recebendo o registro do banco solicitado pela query.
		ResultSet rs = ps.executeQuery();
		
		//posicionando o cursor no primeiro registro.
		if(rs.next()){
			
			Livro livro = new Livro();
			livro.setId(rs.getInt("livro_id"));
			livro.setNome(rs.getString("livro_nome"));
			livro.setEdicao(rs.getString("livro_edicao"));
			livro.setAdaptacao(rs.getString("livro_adaptacao"));
			livro.setQuantidade(rs.getInt("livro_quantidade"));
			livro.setSerie(rs.getString("livro_serie"));
			
			Editora editora = new Editora();
			editora.setId(rs.getInt("editora_id"));
			editora.setNome(rs.getString("editora_nome"));
			livro.setEditora(editora);
			
			Autor autor = new Autor();
			autor.setId(rs.getInt("autor_id"));
			autor.setNome(rs.getString("editora_nome"));
			livro.setAutor(autor);
			
			
			return livro;
		} else {
			
		};
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	
	}
	
		return null;
	
	}
		
}