package entity;

import java.util.LinkedHashSet;
import java.util.Set;

public class Pedido {

	private Integer id;
	private Cliente cliente;
	private Set<Item> vendas;

	public Pedido() {
		vendas = new LinkedHashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Set<Item> getVendas() {
		return vendas;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setVendas(Set<Item> vendas) {
		this.vendas = vendas;
	}
}
