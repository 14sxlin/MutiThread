package c2e1;

public class Student implements Runnable {
	private int id;
	public Student(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		int rand = (int)(Math.random()*1000);
		System.out.println("ѧ�� "+id+" ��ʼ����");
		try {
			Thread.sleep(rand);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ѧ�� "+id+" ��ɿ���,��ʱ"+rand+"ms");
	}

}
