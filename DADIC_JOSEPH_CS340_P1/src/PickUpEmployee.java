import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class PickUpEmployee implements Runnable {
	
	private Thread pickupthread;
	private ArrayBlockingQueue<Integer> pickupqueue;
	static volatile int customerOrderInt;
	static volatile boolean pickupavailable = true;
	static volatile boolean orderready = false;
	static volatile boolean workingonorder = false;
	static volatile int orderRotation;
	static volatile boolean busyWait = false;
	static volatile boolean isBusy = false;

	
	
	public PickUpEmployee(ArrayBlockingQueue<Integer> pickupqueue, int x) {
		this.pickupqueue = new ArrayBlockingQueue<Integer>(x);
		this.pickupthread = new Thread(this);
	}
	
	public void start() {
	pickupthread.start();
}
	public int peek() {
		return this.pickupqueue.peek();
	}
	
	public void remove() {
		this.pickupqueue.remove();
	}
	public void iterator(int x) {
		for(int i = 0; i < 18; i++) {
			this.pickupqueue.add(x);
		}
	}
	public void queueAdd(int x) {
		this.pickupqueue.add(x);
	}
	
		
	public void appendThreadQueue(int y) {
		this.pickupqueue.add(y);
	}
	public boolean contains(Object o) {
		if(this.pickupqueue.contains(o)) {
			return true;
		}else {
			return false;
		}
	}
	public void iteration() {
		for(int i = 0 ; i < this.pickupqueue.size(); i++) {
			this.pickupqueue.add(i);
		}
	}
	public void join() {
		try {
		this.pickupthread.join();
	} catch(InterruptedException e) {
	}
	}
	
	@Override
	public void run() {
		try {
		while(Main.restaurantOpen) {
			Thread.sleep(1000);
			if(!this.pickupqueue.isEmpty() && pickupavailable == true) {
				System.out.println("Pick-up Employee taking " + this.pickupqueue.peek() + "'s order.");
				orderRotation = this.pickupqueue.peek();
				if(orderRotation != 0) {
				workingonorder = false;
				pickupavailable = false;
				orderready = false;
				isBusy = true;
				busyWait = true;
				Main.falseFlag = false;
				}
		}		while(isBusy) {
				try {
				busyWait = true;
				Random rng = new Random();
				int minTime = 1000;
				int maxTime = 5000;
				int workingOnOrder = minTime + rng.nextInt(maxTime);
				workingonorder = true;
				pickupavailable = false;
				orderready = false;
				Thread.sleep(workingOnOrder);
				System.out.println("Pick-up employee finished with Customer " + this.pickupqueue.peek() + "'s order.");
				DinnerCustomer.currentThread = orderRotation;
				busyWait = false;
				DinnerCustomer.permission = true;
				orderready = true;
				this.pickupqueue.poll();
				Main.falseFlag = true;
				workingonorder = false;
				pickupavailable = true;
				isBusy = false;
				}catch(InterruptedException e) {
					
				}
		}
				}
			
		}
	 catch(InterruptedException e) {
	 }
	}
}



		

		



