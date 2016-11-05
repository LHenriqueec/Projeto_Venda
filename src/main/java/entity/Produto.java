package entity;

import java.util.Set;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {

    private StringProperty codigo;
    private StringProperty nome;
    private StringProperty ncm;
    private StringProperty ean;
    private DoubleProperty custo;
    private DoubleProperty peso;
    private Set<UnidadeMedida> unMedida;
    private Grupo grupo;
    private Marca marca;
    
    public Produto() {
    	codigo = new SimpleStringProperty();
    	nome = new SimpleStringProperty();
    	ncm = new SimpleStringProperty();
    	ean = new SimpleStringProperty();
    	custo = new SimpleDoubleProperty();
    	peso = new SimpleDoubleProperty();
    }
    
    public String getCodigo() {
		return codigo.get();
	}


	public void setCodigo(String codigo) {
		this.codigo.set(codigo);;
	}
	
	public StringProperty codigoProperty() {
		return codigo;
	}


	public String getNome() {
		return nome.get();
	}


	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public StringProperty nomeProperty() {
		return nome;
	}


	public String getNcm() {
		return ncm.get();
	}


	public void setNcm(String ncm) {
		this.ncm.set(ncm);
	}
	
	public StringProperty ncmProperty() {
		return ncm;
	}


	public String getEan() {
		return ean.get();
	}


	public void setEan(String ean) {
		this.ean.set(ean);
	}
	
	public StringProperty eanProperty() {
		return ean;
	}


	public Double getCusto() {
		return custo.get();
	}


	public void setCusto(Double custo) {
		this.custo.set(custo);
	}
	
	public DoubleProperty custoProperty() {
		return custo;
	}
	
	public Double getPeso() {
		return peso.get();
	}
	
	public void setPeso(Double peso) {
		this.peso.set(peso);
	}
	
	public DoubleProperty pesoProperty() {
		return peso;
	}
	
	public Set<UnidadeMedida> getUnMedida() {
		return unMedida;
	}
	
	public void setUnMedida(Set<UnidadeMedida> unMedida) {
		this.unMedida = unMedida;
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
