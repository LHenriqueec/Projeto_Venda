package entity;

public class Item {
	
	private String id;
    private Produto produto;
    private Integer quantidade;
    private Double cmv;
    private Double valor;
    private Double total;

    public String getId() {
		return id;
	}
    
    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getCmv() {
        return cmv;
    }

    public Double getValor() {
        return valor;
    }

    public Double getTotal() {
        return total;
    }
    
    public void setId(String id) {
		this.id = id;
	}
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        setCmv(quantidade * produto.getCusto());
        this.quantidade = quantidade;
    }

    private void setCmv(Double cmv) {
        this.cmv = cmv;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
