package c3e2;

public class OpenSell {
	public static void main(String[] args) {
		Tickets t = new Tickets(1000);
		for(int i=0;i<5;i++)
		{
			Seller s = new Seller(t, i+1);
			new Thread(s).start();
		}
	}
}
