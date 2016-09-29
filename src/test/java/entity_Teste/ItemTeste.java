package entity_Teste;

public class ItemTeste {
	
	private String codigo;
	private String nome;
	private int quantidade;
	private double valorUnitario;
	private double valorTotal;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s	%s		%d	%.2f	%.2f", codigo, nome, quantidade, valorUnitario, valorTotal);
	}
	
}












