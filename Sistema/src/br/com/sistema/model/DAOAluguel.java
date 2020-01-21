package br.com.sistema.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOAluguel extends Conexao {
	
	private Aluguel aluguel;	
	public DAOAluguel(Aluguel a){
		this.aluguel = a;
	}
	
	public DAOAluguel(){
		
	}
	
	public void cadastrar() throws SQLException{
		String sql = "INSERT INTO aluguel VALUES(DEFAULT,?,?,?,?);";
			ps = getConectar().prepareStatement(sql);
			ps.setLong(1,  aluguel.getIdAutomovel());
			ps.setLong(2,  aluguel.getIdCliente());
			ps.setLong(3,  aluguel.getIdFuncionario());
			ps.setDouble(4,  aluguel.getValor());
			ps.execute();
	}
	
	
	public List<Aluguel> getAluguels() throws SQLException{
		
			String sql = "SELECT * FROM aluguel";
			ps = getConectar().prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Aluguel> lista = new ArrayList<Aluguel>();
			while(rs.next()){
				Aluguel a = new Aluguel();
				a.setId(rs.getLong(1));
				a.setIdAutomovel(rs.getLong(2));
				a.setIdCliente(rs.getLong(3));
				a.setIdFuncionario(rs.getLong(4));
				a.setValor(rs.getDouble(5));
				lista.add(a);
			}
			
			return lista;
		}
	
	public Aluguel visualizar(long id) throws SQLException{
		
		String sql ="SELECT * FROM aluguel WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		
		rs = ps.executeQuery();
		Aluguel a = new Aluguel();
		
		while(rs.next()){
			a.setId(rs.getLong(1));
			a.setIdAutomovel(rs.getLong(2));
			a.setIdCliente(rs.getLong(3));
			a.setIdFuncionario(rs.getLong(4));
			a.setValor(rs.getDouble(5));
		}
		return a;
	}
	
	public void atualizar() throws SQLException{
		String sql ="UPDATE aluguel SET idAutomovel = ?, idCliente = ?, idFuncionario = ?, Valor = ? WHERE id =?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1,  aluguel.getIdAutomovel());
		ps.setLong(2,  aluguel.getIdCliente());
		ps.setLong(3,  aluguel.getIdFuncionario());
		ps.setDouble(4,  aluguel.getValor());
		ps.setLong(5,  aluguel.getId());
		ps.execute();
	}
	
	public void excluir(long id) throws SQLException{
		String sql = "DELETE from aluguel WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		
	}

}
