package br.com.sistema.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
	
	final private static String usuario = "root";
	final private static String senha	= "";
	final private static String driver	=
			"jdbc:mysql://localhost:3306/sistema";
	private static Connection conexao = null;
	private static String status = "Não conectado";
	protected static ResultSet rs;
	protected static PreparedStatement ps;
	
	public static Connection getConectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(driver,usuario,senha);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conexao;
	}

	
}