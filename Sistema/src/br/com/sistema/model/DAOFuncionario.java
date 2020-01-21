package br.com.sistema.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionario extends Conexao{
	private Funcionario funcionario;	
	public DAOFuncionario(Funcionario f){
		this.funcionario = f;
	}
	
	public DAOFuncionario(){
		
	}
	
	
	/*public void cadastra(long id, String nomeFuncionario, String matricula, String cargo, String endereco, String telefone)
	{
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		param.addValue("nomeFuncionario", nomeFuncionario);
		param.addValue("matricula", matricula);
		param.addValue("cargo", cargo);
		param.addValue("endereco", endereco);
		param.addValue("telefone", telefone);
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO funcionario VALUES(").append(id);
		sql.append(",").append(nomeFuncionario);
		sql.append(",").append(matricula);
		sql.append(",").append(cargo);
		sql.append(",").append(endereco);
		sql.append(",").append(telefone);
		sql.append(");");
		
		
	}*/
	
public void cadastrar() throws SQLException{
		
			String sql = "INSERT INTO funcionario VALUES(DEFAULT,?,?,?,?,?);";
		
			ps = getConectar().prepareStatement(sql);
			ps.setString(1, funcionario.getNomeFuncionario());
			ps.setString(2,  funcionario.getMatricula());
			ps.setString(3,  funcionario.getCargo());
			ps.setString(4,  funcionario.getEndereco());
			ps.setString(5,  funcionario.getTelefone());
			ps.execute();
	}
	
	public List<Funcionario> getFuncionarios() throws SQLException{
		
			String sql = "SELECT * FROM funcionario";
			ps = getConectar().prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<Funcionario> lista = new ArrayList<Funcionario>();
			while(rs.next()){
				Funcionario f = new Funcionario();
				f.setId(rs.getLong(1));
				f.setNomeFuncionario(rs.getString(2));
				f.setMatricula(rs.getString(3));
				f.setEndereco(rs.getString(4));
				f.setCargo(rs.getString(5));
				f.setTelefone(rs.getString(6));
				lista.add(f);
			}
			
			return lista;
		}
	
	public Funcionario visualizar(long id) throws SQLException{
		
		String sql ="SELECT * FROM funcionario WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		
		rs = ps.executeQuery();
		Funcionario f = new Funcionario();
		
		while(rs.next()){
			f.setId(rs.getLong(1));
			f.setNomeFuncionario(rs.getString(2));
			f.setMatricula(rs.getString(3));
			f.setEndereco(rs.getString(4));
			f.setCargo(rs.getString(5));
			f.setTelefone(rs.getString(6));
		}
		return f;
	}
	
	public void atualizar() throws SQLException{
		String sql ="UPDATE funcionario SET nome_funcionario = ?, matricula = ?, endereco = ?, cargo = ?,telefone = ? WHERE id =?";
		ps = getConectar().prepareStatement(sql);
		ps.setString(1, funcionario.getNomeFuncionario());
		ps.setString(2,  funcionario.getMatricula());
		ps.setString(3,  funcionario.getEndereco());
		ps.setString(4,  funcionario.getCargo());
		ps.setString(5,  funcionario.getTelefone());
		ps.setLong(6,  funcionario.getId());
		ps.execute();
	}
	
	public void excluir(long id) throws SQLException{
		String sql = "DELETE from funcionario WHERE id = ?";
		ps = getConectar().prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
		
	}

}
