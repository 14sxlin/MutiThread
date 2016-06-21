package c2e1;

public class Student implements Runnable {
	private int id;
	public Student(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		int rand = (int)(Math.random()*1000);
		System.out.println("学生 "+id+" 开始考试");
		try {
			Thread.sleep(rand);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("学生 "+id+" 完成考试,用时"+rand+"ms");
	}

}
