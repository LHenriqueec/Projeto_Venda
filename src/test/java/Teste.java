

import java.time.Month;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.ConnectionFactory;
import dao.DaoFactory;
import entity.Produto;
import entity.UnidadeMedida;
import util.FaturamentoUtils;

public class Teste {


	@BeforeClass
	public static void setup() {
	}

	@Test
	public void teste() throws Exception {
		System.out.println(FaturamentoUtils.readTotal(Month.AUGUST));
	}

}


















