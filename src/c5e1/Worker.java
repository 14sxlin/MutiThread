package c5e1;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker extends Thread {
	int arr[];
	CyclicBarrier barrier;
	public Worker(int arr[],CyclicBarrier barrier) {
		this.arr = arr;
		this.barrier  = barrier;
	}
	@Override
	public void run() {
		Arrays.sort(arr);
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
