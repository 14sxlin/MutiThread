package c2e3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BeginWork {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Worker w1 = new Worker("ԭ����", "�и�");
		FutureTask<String> ft = new FutureTask<>(w1);
		new Thread(ft).start();
		Worker w2 = new Worker(ft.get(), "��ĥ");
		ft = new FutureTask<>(w2);
		new Thread(ft).start();
		Worker w3 = new Worker(ft.get(), "���");
		ft = new FutureTask<>(w3);
		new Thread(ft).start();
		System.out.println(ft.get());
		
	}

}
