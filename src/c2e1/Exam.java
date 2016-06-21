package c2e1;

public class Exam {
	public static void main(String[] args) {
		for(int i = 0;i<5;i++)
		{
			Student s = new Student(i+1);
			Thread t = new Thread(s);
			t.start();
		}
	}
}
