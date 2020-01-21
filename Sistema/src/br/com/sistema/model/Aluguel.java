package br.com.sistema.model;

public class Aluguel {

	private long id;
	private long idAutomovel;
	private long idCliente;
	private long idFuncionario;
	private double valor;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdAutomovel() {
		return idAutomovel;
	}
	public void setIdAutomovel(long idAutomovel) {
		this.idAutomovel = idAutomovel;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
