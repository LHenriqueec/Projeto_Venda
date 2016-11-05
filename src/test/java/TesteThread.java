import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import util.ObserverUtil;
import util.ThreadUtils;

public class TesteThread {

	private ExecutorService service = Executors.newSingleThreadExecutor();
	private boolean b;
	
	@Test
	public void teste() throws InterruptedException {
		service.execute(ObserverUtil.instance());
		
		while (true) {
			
			ObserverUtil.setCellSelected(b);
			b = !b;
			Thread.sleep(1000);
			
		}
	}
}
