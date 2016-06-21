package c3e2;

public class Tickets {
	private int num;
	private int total;
	public Tickets(int num) {
		this.num = num;
		this.total = num;
	}
	
	public synchronized void sell(int id) {
		if(num>0)
		{
			System.out.println("售票窗口"+id+"   卖出第"+(total-num+1)+"张票 ");
			num--;
		}
	}
	
	public boolean sellOut() {
		return num<=0;
	}
}
