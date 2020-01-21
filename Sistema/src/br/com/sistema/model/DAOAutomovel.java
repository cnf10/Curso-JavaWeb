package br.com.sistema.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOAutomovel extends Conexao {
	
	private Automovel automovel;	
	public DAOAutomovel(Automovel a){
		this.automovel = a;
	}
	
	public DAOAutomovel(){
		
	}
	
	public void cadastrar() throws SQLException{
		String sql = "INSERT INTO automovel VALUES(DEFAULT,?,?,?,?);";
			ps = getConectar().prepareStatement(sql);
			ps.setString(1, automovel.getModelo());
			ps.setString(2,  automovel.getAno());
			ps.setString(3,  automovel.getPlaca());
			ps.setDouble(4,  automovel.getValor());
			ps.execute();
	}
	
	
	public List<Automovel> getAutomovels() throws SQLException{
		
			String sql = "SELECT * FROM automovel";
			ps = getConectar().prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Automovel> lista = new ArrayList<Automovel>();
			while(rs.next()){
				Automovel a = new Automovel();
				a.setId(rs.getLong(1));
				a.setModelo(rs.getString(2));
				a.setAno(rs.getString(3));
				a.setPlaca(rs.getString(4));
				a.setValor(rs.getDouble(5));
				lista.add(a);
			}
			
			return lista;
		}
	
	public Automovel visualizar(long id) throws SQLException{
		
		String sql ="SELECT * FROM automovel WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		
		rs = ps.executeQuery();
		Automovel a = new Automovel();
		
		while(rs.next()){
			a.setId(rs.getLong(1));
			a.setModelo(rs.getString(2));
			a.setAno(rs.getString(3));
			a.setPlaca(rs.getString(4));
			a.setValor(rs.getDouble(5));
		}
		return a;
	}
	
	public void atualizar() throws SQLException{
		String sql ="UPDATE alunos SET modelo = ?, ano = ?, placa = ?, valor = ? WHERE id =?";
		ps = getConectar().prepareStatement(sql);
		ps.setString(1, automovel.getModelo());
		ps.setString(2,  automovel.getAno());
		ps.setString(3,  automovel.getPlaca());
		ps.setDouble(4,  automovel.getValor());
		ps.setLong(5,  automovel.getId());
		ps.execute();
	}
	
	public void excluir(long id) throws SQLException{
		String sql = "DELETE from automovel WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		
	}

}
