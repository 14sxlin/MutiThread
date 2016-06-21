package c3e2;

public class Seller implements Runnable {
	private int id;
	private Tickets t;
	public Seller(Tickets t,int id) {
		this.t = t;
		this.id = id;
	}
	@Override
	public void run() {
		while(!t.sellOut())
		{
			t.sell(id);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}

	}

}
