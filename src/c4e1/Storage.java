package c4e1;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
	private ArrayList<String> material;
	private ArrayList<String> product;
	private int demand;
	private Lock lock;
	private Condition mFull;
	private Condition mEmpty;
	private Condition pFull;
	private Condition pEmpty;
	private final  int storeNum = 5;
	public Storage(int demand) {
		this.demand = demand;
		material = new ArrayList<>();
		product = new ArrayList<>();
		lock = new ReentrantLock();
		mFull = lock.newCondition();
		mEmpty = lock.newCondition();
		pFull = lock.newCondition();
		pEmpty = lock.newCondition();
	}
	
	public synchronized boolean finish() {
		if(this.demand<=0)
		{
//			mFull.signalAll();
//			mEmpty.signalAll();
//			pFull.signalAll();
//			pEmpty.signalAll();
			return true;
		}
		return false;
	}
	
	public void putMaterial(String material) {
		try {
			lock.lock();
			while(this.material.size()>=storeNum) {
				mFull.await();
			}
			if(!finish())
			{	this.material.add(material);
				System.out.println("������ԭ����  "+material);
				mEmpty.signal();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public String getMetiral() {
		String temp ="";
		try {
			lock.lock();
			while(this.material.size()<=0) {
				mEmpty.await();
			}
			if(!finish())
			{	temp = this.material.get(this.material.size()-1);
				this.material.remove(this.material.size()-1);
				System.out.println("\t\t��  "+temp+"   ���мӹ�");
				mFull.signal();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return  temp;
	}
	
	public void putProduct(String product) {
		try {
			lock.lock();
			while(this.product.size()>=storeNum) {
				pFull.await();
			}
			if(!finish())
			{	this.product.add(product);
				System.out.println("\t\t\t�ռӹ��˲�Ʒ  "+product);
				Thread.sleep(1000);
				pEmpty.signal();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public String getProduct() {
		String temp ="";
		try {
			lock.lock();
			while(this.product.size()<=0) {
				pEmpty.await();
			}
			if(!finish())
			{	temp = this.product.get(this.product.size()-1);
				this.product.remove(this.product.size()-1);
				System.out.print("\t\t\t\t��Ʒ"+temp+"���䵽���۴�");
				Thread.sleep(1000);
				this.demand--;
				System.out.println("\t\t\t\t����  "+this.demand+"  ������");
				pFull.signal();
			}else {
				System.out.println("�����Ŀ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return  temp;
	}
	
}
