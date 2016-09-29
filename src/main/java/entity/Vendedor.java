package entity;

import java.util.Set;

public class Vendedor {

	private Integer id;
	private String nome;
	private Set<Cliente> clientes;
	
	public Vendedor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(nome);
		
		return buff.toString();
	}
}
