package c3e1;

public class BeginWork {

	public static void main(String[] args) {
		Parts p = new Parts(100);
		Worker w1 = new Worker(p, "¼×");
		Worker w2 = new Worker(p, "ÒÒ");
		new Thread(w1).start();
		new Thread(w2).start();

	}

}
