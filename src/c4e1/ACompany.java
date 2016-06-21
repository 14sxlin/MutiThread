package c4e1;

public class ACompany implements Runnable {

	private Storage s;
	public ACompany(Storage s) {
		this.s = s;
	}
	@Override
	public void run() {
		while(!s.finish()) {
			String mate = s.getMetiral();
			s.putProduct(mate + "(ÒÑ¼Ó¹¤)");
		}

	}

}
