package iveso.teste;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.ConnectionFactory;
import entity.Produto;
import service.ProdutoService;
import service.ServiceException;


public class Teste {
	
	private ProdutoService service;

	@Before
	public void init() {
		service = ProdutoService.getService();
		ConnectionFactory.initSetup();
	}
	
	@Test
	public void teste() throws ServiceException {
		List<Produto> produtos = service.getProdutos();
		
		produtos.forEach(System.out::println);
	}
}
