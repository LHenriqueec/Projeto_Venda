package entity;

import java.util.Set;

public class Cliente {

	private String cnpj;
	private String inscEstadual;
	private String razao;
    private String fantasia;
    private Set<Pedido> pedidos;
    private Vendedor vendedor;
    
    public Cliente() {
    }

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getInscEstadual() {
		return inscEstadual;
	}
	
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	
	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}
	
	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String nome) {
		this.fantasia = nome;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append(cnpj).append("\t")
			.append(inscEstadual).append("\t")
			.append(razao).append("\t")
			.append(fantasia).append("\t")
			.append(vendedor);
		
		return buff.toString();
	}
	
}






