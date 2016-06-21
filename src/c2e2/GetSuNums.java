package c2e2;

public class GetSuNums {

	public static void main(String[] args) throws InterruptedException {
		//多个线程执行并没有单个线程执行快
		long time1 = System.currentTimeMillis();
		SuNum t1  = new SuNum(1, 300000);
		SuNum t2  = new SuNum(300001, 600000);
		SuNum t3  = new SuNum(600001, 1000000);
		Thread th1 =new Thread(t1);th1.start();
		Thread th2 =new Thread(t2);th2.start();
		Thread th3 = new Thread(t3);th3.start();
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("用时:"+(System.currentTimeMillis()-time1));
	    time1 = System.currentTimeMillis();
		Thread th4 = new Thread(new SuNum(1, 1000000));th4.start();
		th4.join();
		System.out.println("用时:"+(System.currentTimeMillis()-time1));
	}

}
