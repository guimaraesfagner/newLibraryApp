package br.com.fagner.libraryapp.percistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/libraryapp", "postgres", "pgres6667");
		} catch (SQLException e) {
			//Relançando a exception
			throw new RuntimeException(e);
		}
	}
	
	
}
