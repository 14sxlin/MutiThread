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
			System.out.println("��Ʊ����"+id+"   ������"+(total-num+1)+"��Ʊ ");
			num--;
		}
	}
	
	public boolean sellOut() {
		return num<=0;
	}
}
