package c5e1;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BeginWork {

	public static void main(String[] args) {
		int N = 5000000;
		int thread = 2;
		int []arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = (int)(Math.random()*N);
		}
		System.out.println("数据初始化完毕");
		int[] data = new int[thread+1];
		int slice = N/thread;
		for(int i =0; i<=thread;i++) {
			data[i] = slice*i;
			if(data[i]>N)
				data[i] = N;
		}
		int [][] subarr = new int[thread][slice];
		for(int i=0;i<thread;i++) {
			subarr[i] = Arrays.copyOfRange(arr, data[i],data[i+1]);
		}
		System.out.println("数据划分完成");
		Thread[] t = new Thread[thread];
		CyclicBarrier barrier = new CyclicBarrier(thread+1);
		for(int i=0;i<thread;i++)
		{
			t[i] = new Worker(subarr[i], barrier);
			t[i].start();
		}
		System.out.println(thread+" 个线程已经启动了");
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arr = converge(subarr[0], subarr[1]);
		if(check(arr))
			System.out.println("排序成功");
		else System.out.println("排序失败");

	}
	
	private static int[] converge(int[] arr1,int []arr2) {
		int arr[] = new int[arr1.length+arr2.length];
		int i1=0, i2=0, i = 0;
		while(i1<arr1.length&&i2<arr2.length) {
			if(arr1[i1]<arr2[i2]) {
				arr[i] = arr1[i1];
				i++;
				i1++;
			}else {
				arr[i++] = arr2[i2++];
			}
		}
		while(i1<arr1.length) {
			arr[i] = arr1[i1];
			i++;
			i1++;
		}
		while(i1<arr1.length) {
			arr[i] = arr2[i2];
			i++;
			i2++;
		}
		return arr;
	}

	private static boolean check(int[] arr) {
		int length = arr.length;
		for(int i=0;i<length-1;i++) {
			if(arr[i]>arr[i+1])
				return false;
		}
		return true;
	}
}
