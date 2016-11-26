package iveso.teste;

import entity.Produto;

public class TesteReferencia {
	
	private static Produto p;
	
	public TesteReferencia() {
		if (p == null) {
			p = new Produto();
		}
	}
	
	public Produto getProduto() {
		return p;
	}
}
