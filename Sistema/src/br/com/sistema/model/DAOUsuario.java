package br.com.sistema.model;

import java.sql.SQLException;

public class DAOUsuario extends Conexao {
	
	private Usuario usuario;
	
	private DAOUsuario(){}
	public DAOUsuario(Usuario u){
		this.usuario=u;
	}
	
	public Usuario logar() throws SQLException{
		Usuario u = new Usuario();
		String sql = "SELECT * FROM usuario WHERE usuario= ? AND senha=?";
		ps =getConectar().prepareStatement(sql);
		ps.setString(1, usuario.getUsuario());
		ps.setString(2, usuario.getSenha());
		rs = ps.executeQuery();
		
		while(rs.next()){
			u.setId(rs.getLong(1));
			u.setNome(rs.getString(2));
			u.setUsuario(rs.getString(3));
		
	}
		return u;
	}
		
}

