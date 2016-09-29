package entity;

import java.util.LinkedHashSet;
import java.util.Set;

public class UnidadeMedida {

	private String unidade;
	private Integer quantidade;
	private Set<Produto> produtos;
	
	public UnidadeMedida() {
		produtos = new LinkedHashSet<>();
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Set<Produto> getProdutos() {
		return produtos;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
}
