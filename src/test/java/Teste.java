
import java.time.Month;

import org.junit.BeforeClass;
import org.junit.Test;

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


















