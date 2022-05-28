import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class DinnerCustomer implements Runnable {

	private Thread customerThread;
	static volatile int output;
	static volatile boolean decision = true;
	static AtomicInteger customerCount = new AtomicInteger(0);
	static volatile boolean customerpaid = false;
	static volatile boolean interruptMe = false;
	static volatile long saveCustomerThreadID = 0;
	static volatile boolean permission = false;
	static volatile int currentThread;
	static volatile boolean customerChoicePath;
	static volatile int borrowNumber = 0;
	static volatile boolean flag = false;
	static volatile int customerTableOrderCount = 0;
	static volatile int customerGroupOrder = 0;
	static volatile int customerPay = 0;
	static volatile int setsOfThree = 0;
	static volatile Boolean readyToPay = false;
	static volatile int payCount = 0;
	static volatile int allCustomersFinishedEating = 0;
	public DinnerCustomer(String customerNumber) {
	this.customerThread = new Thread(this);
	}
	
	public void start() {
		try {
		Random rng = new Random();
		int minimum = 1000;
		int maximum = 10000;
		int sleepyTime = minimum + rng.nextInt(maximum);
		Thread.sleep(sleepyTime);
		customerThread.start();
		
	} catch (InterruptedException e) {
		
	}
	}
	public int returnCustomerID(int x) {
		return x;
	}
	public void interrupt() {
		this.customerThread.interrupt();
	}
	public Boolean isInterrupted() {
		if(customerThread.isInterrupted()) {
			return true;
		} else {
			return false;
		}
	}
	public int returnCustomer(int x) {
		return x;
	}
	public void getState() {
		customerThread.getState();
	}
	
	public int getOutput() {
			return output;
		}
	public Boolean isAlive() {
		if(customerThread.isAlive()) {
			return true;
		} else {
			return false;
		}
	}
	public int getCustomerNumber() {
		return output;
	}
	
	public void setPriority(int x) {
		customerThread.setPriority(x);
	}
	public void wakeUp() {
		customerThread.interrupt();
	}
	public void getCustomerThreadInterrupt() {
		this.customerThread.interrupt();
	}
	public void interruptMeNow() {
		if(interruptMe == true) {
			this.customerThread.interrupt();
		}
	}
	public void getName() {
		this.customerThread.getName();
	}
	public void isSleeping() {
		this.customerThread.getState();
	}
	public void getID() {
		this.customerThread.getId();
	}
	public long getCustomerID() {
		return saveCustomerThreadID;
	}
	public String getMainName() {
		return this.customerThread.getName();
	}
	public int numberSplit(Thread x) {
		String y = this.customerThread.getName();
		String splitNumber = y.replaceAll("[^0-9]","");
		return Integer.parseInt(splitNumber);
	}
	public int currentThread() {
		return this.customerThread.getPriority();
	}
		
	public void run() {
		try {
			customerCount.getAndIncrement();
			Random pickupordinein = new Random();
			int minPickup = 1;
			int maxDinein = 10;
			int customerChoice = minPickup + pickupordinein.nextInt(maxDinein);
			if(customerChoice > 2) {   //Decision for customer
				
				System.out.println("Customer " + customerCount.get() + " is dining in."); //Just for output clarification
				this.customerThread.setName("" +  customerCount.get()); //Set name for customer thread based off their entry.
				TableEmployee.globalTableInteger = numberSplit(this.customerThread); //self made function to get int value from thread name.
				TableEmployee.tableEmployeeCustomerCount = customerCount.get(); //Give customer numeric value to tableemployee queue.
				Main.tableOneBusyWaitCount++;                               //First busy wait helper.
				while(Main.tableOneBusyWaitCount != 3) { //Busy wait
				}
				
				setsOfThree++; //second busy wait helper
				
				while(setsOfThree != 3) {  //busy wait
			}
				Main.tableOneBusyWaitCount=0;
				
				
				System.out.println(this.customerThread.getName() + " is placing their order at their table.");
				Random takeOrder = new Random();
				int anotherMin = 1000;
				int anotherMax = 5000;
				int makeOrder = anotherMin + takeOrder.nextInt(anotherMax);
				this.customerThread.setPriority(10);
				Thread.sleep(makeOrder);
			    this.customerThread.setPriority(5);
			    customerTableOrderCount++;
			  
			    while(customerTableOrderCount != 3) {
			 }
			    setsOfThree = 0;
			    System.out.println("Customer " + this.customerThread.getName() + " has given their order in.");
			    customerGroupOrder++;
			    while(customerGroupOrder != 3) {
			  }
			    flag = true;
			    
			    while(!TableEmployee.customersCanEat) {
			 }
			    customerTableOrderCount = 0;
			    
			  
			    System.out.println("Customer " + this.customerThread.getName() + " is eating their food");
			  
			 
			   	Thread.sleep(makeOrder);
			    Thread.yield();
			    Thread.yield();
			    
			    System.out.println("Customer " + this.customerThread.getName() + " is finished eating and looking to pay.");
			    //readyToPay = true;
			    payCount++;
			    
			    while(!TableEmployee.customerLeaving) {
			 }
			    customerGroupOrder = 0;
			    System.out.println("Customer " + this.customerThread.getName() + " has paid their bill.");
			    allCustomersFinishedEating++;
			    if(allCustomersFinishedEating == 3) {
			    	readyToPay = true;
			    }
			    System.out.println("Customer " + this.customerThread.getName() + " is leaving.");
		
				//TableEmployee.globalTableInteger = numberSplit(this.customerThread);
				//System.out.println(TableEmployee.globalTableInteger);
				//Main.tableOneFull = true;
				
				
			}
				
				
				else  {
					
				
				Main.pickupTransfer = customerCount.get(); // If 3 is dining in, pickupTransfer now is == 3;
				this.customerThread.setName("Customer " + customerCount.get());
				System.out.println(this.customerThread.getName() + " is picking up.");
				
				
				while(Main.pickupTransfer != PickUpEmployee.orderRotation && PickUpEmployee.pickupavailable) { // The second the order is taken, this will be broken.
				}
				System.out.println(this.customerThread.getName() + " is " + " waiting for their order.");
				currentThread = PickUpEmployee.orderRotation;
				while(PickUpEmployee.busyWait && Main.helpMe == PickUpEmployee.orderRotation && Main.globalFlag == customerCount.get()) {
				
				}
				System.out.println(this.customerThread.getName() + " is waiting to pay for their order.");
				
				while(permission || PickUpEmployee.orderRotation == currentThread) {
					Random paybill = new Random();
					int minwait = 5000;
					int maxwait = 15000;
					int customerbillpay = minwait + paybill.nextInt(maxwait);
					Thread.sleep(customerbillpay);
					System.out.println(this.customerThread.getName() + " has paid their bill.");
					PickUpEmployee.isBusy = false;
					permission  = false;
					System.out.println(this.customerThread.getName() + " has taken off with their food.");
					break;
				}
				
		  }	   
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
	}
  }
}



		





