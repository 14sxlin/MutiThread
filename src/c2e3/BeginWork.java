package c2e3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BeginWork {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Worker w1 = new Worker("原材料", "切割");
		FutureTask<String> ft = new FutureTask<>(w1);
		new Thread(ft).start();
		Worker w2 = new Worker(ft.get(), "打磨");
		ft = new FutureTask<>(w2);
		new Thread(ft).start();
		Worker w3 = new Worker(ft.get(), "电镀");
		ft = new FutureTask<>(w3);
		new Thread(ft).start();
		System.out.println(ft.get());
		
	}

}
