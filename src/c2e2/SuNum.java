package c2e2;

public class SuNum implements Runnable {

	private int begin,end;
	public SuNum(int begin,int end) {
		this.begin = begin;
		this.end = end;
	}
	@Override
	public void run() {
		boolean is = true;
		for(int i=begin;i<=end;i++)
		{
			is = true;
			if(i==1) continue;
			if(i==2)	 { System.out.println(2+" "); continue;}
			for(int j =2;j<=(int)Math.sqrt(i);j++)
			{
				if(i%j==0) 
				{
					is = false;
					break;
				}
			}
			if(is) System.out.println(i+" ");
		}
		System.out.println();
	}

}
