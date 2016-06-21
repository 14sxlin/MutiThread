package c3e1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parts {
	private int amount;
	private Lock lock;
	public Parts(int amount) {
		lock = new ReentrantLock();
	   this.amount = amount;
	}
	public void countDown()
	{
		amount--;
	}
	public synchronized boolean finish()
	{
		if(amount<=0)
			return true;
		else return false;
	}
	public synchronized int getRemain() {
		return amount;
	}
	
	public void produce(String name)
	{
		try {
			lock.lock();
			if(!finish())
			{
				System.out.print(name+"正在处理零件"+getRemain());
				countDown();
				System.out.println( "    剩余 "+getRemain());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
