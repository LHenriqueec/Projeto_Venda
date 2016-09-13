package entity;

public class Produto {

    private String codigo;
    private String nome;
    private String ncm;
    private String ean;
    private Double custo;
    private Grupo grupo;
    private Marca marca;
    
    public Produto() {
    }

    
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


	public String getNcm() {
		return ncm;
	}


	public void setNcm(String ncm) {
		this.ncm = ncm;
	}


	public String getEan() {
		return ean;
	}


	public void setEan(String ean) {
		this.ean = ean;
	}


	public Double getCusto() {
		return custo;
	}


	public void setCusto(Double custo) {
		this.custo = custo;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	@Override
    public String toString() {
    	StringBuffer buff = new StringBuffer();
    	return buff.append(codigo)
    			.append("\t")
    			.append(nome)
    			.append("\t\t")
    			.append(custo)
    			.append("\t\t").toString();
    }
}
