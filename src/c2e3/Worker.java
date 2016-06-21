package c2e3;

import java.util.concurrent.Callable;

public class Worker implements Callable<String> {
	private String product;
	private String deal;
	public Worker(String product,String deal) {
		this.product = product;
		this.deal = deal;
	}
	@Override
	public String call() throws Exception {
		int time = (int)(Math.random()*1000);
		Thread.sleep(time);
		return product+"  “—"+deal+" ”√ ±: "+time+"\n";
	}
}
