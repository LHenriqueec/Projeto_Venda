package util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObserverUtil implements Runnable {

	private static ObserverUtil instance;
	private static boolean cellSelected;
	private static Lock lock;
	private static Condition cond;
	
	private ObserverUtil () {
		lock = new ReentrantLock();
		cond = lock.newCondition();
	}
	
	public static ObserverUtil instance() {
		if (instance == null) {
			instance = new ObserverUtil();
		}
		
		return instance;
	}

	@Override
	public void run() {
		while (true) {
			lock.lock();
			try {
				
				if (cellSelected) {
					System.out.println(cellSelected);
				} else {
					
					System.out.println(cellSelected);
					cond.await();
						
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			
		}
	}
	
	public static void setCellSelected(boolean cellSelected) {
		lock.lock();
		try {
			if (cellSelected) {
				cond.signalAll();
			}
			ObserverUtil.cellSelected = cellSelected;
			
		} finally {
			lock.unlock();
		}
	}
}
