package c3e1;

public class Worker implements Runnable {
	private Parts parts;
	private String name;
	public Worker(Parts parts,String name) {
		this.parts = parts;
		this.name = name;
	}
	@Override
	public void run() {
		while(!parts.finish())
		{
			parts.produce(name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
