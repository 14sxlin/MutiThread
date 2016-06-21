package c4e1;

public class DoBussiness {
	public static void main(String[] args) {
		Storage s = new Storage(10);
		new Thread(new ACompany(s)).start();
		new Thread(new BCompany(s)).start();
		new Thread(new BCompany(s)).start();
		new Thread(new BCompany(s)).start();
	}
}
