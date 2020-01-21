package br.com.sistema.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends Conexao {
	private Cliente cliente;	
	public DAOCliente(Cliente c){
		this.cliente = c;
	}
	
	public DAOCliente(){
		
	}
	
	public void cadastrar() throws SQLException{
		String sql = "INSERT INTO cliente VALUES(DEFAULT,?,?,?,?);";
			ps = getConectar().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2,  cliente.getCpf());
			ps.setString(3,  cliente.getEndereco());
			ps.setString(4,  cliente.getTelefone());
			ps.execute();
	}
	
	
	public List<Cliente> getClientes() throws SQLException{
		
			String sql = "SELECT * FROM cliente";
			ps = getConectar().prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Cliente> lista = new ArrayList<Cliente>();
			while(rs.next()){
				Cliente c = new Cliente();
				c.setId(rs.getLong(1));
				c.setNomeCliente(rs.getString(2));
				c.setCpf(rs.getString(3));
				c.setEndereco(rs.getString(4));
				c.setTelefone(rs.getString(5));
				lista.add(c);
			}
			
			return lista;
		}
	
	public Cliente visualizar(long id) throws SQLException{
		
		String sql ="SELECT * FROM cliente WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		
		rs = ps.executeQuery();
		Cliente c = new Cliente();
		
		while(rs.next()){
			c.setId(rs.getLong(1));
			c.setNomeCliente(rs.getString(2));
			c.setCpf(rs.getString(3));
			c.setEndereco(rs.getString(4));
			c.setTelefone(rs.getString(5));
		}
		return c;
	}
	
	public void atualizar() throws SQLException{
		String sql ="UPDATE cliente SET nome_cliente = ?, cpf = ?, endereco = ?, telefone = ? WHERE id =?";
		ps = getConectar().prepareStatement(sql);
		ps.setString(1, cliente.getNomeCliente());
		ps.setString(2,  cliente.getCpf());
		ps.setString(3,  cliente.getEndereco());
		ps.setString(4,  cliente.getTelefone());
		ps.setLong(5,  cliente.getId());
		ps.execute();
	}
	
	public void excluir(long id) throws SQLException{
		String sql = "DELETE from cliente WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		
	}
}
