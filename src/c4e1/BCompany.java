package c4e1;

public class BCompany implements Runnable {
	private Storage s;
	public BCompany(Storage s) {
		this.s = s;
	}
	@Override
	public void run() {
		while(!s.finish()) {
			int random = (int)(Math.random()*1000);
			s.putMaterial(""+random);
			s.getProduct();
		}
	}
}
