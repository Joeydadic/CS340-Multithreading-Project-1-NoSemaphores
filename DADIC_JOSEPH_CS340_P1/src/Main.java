import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicIntegerArray;

//Name: Joseph Dadic
//Class : CS 340 Project 1

//Notes: I had an EXTREMELY difficult time with this project and it truly gave me a run for my money.
// I had to use up to the final day of turn in and barely had time to comment out the code. I appreciate the
// difficulty as I learned a lot, but I also have a lot more to learn as I have come to realized I am extremely
// poor at managing multiple threads of code at once. Thank you for the challenge!


public class Main {
	private static DinnerCustomer[] customer;
	private static PickUpEmployee PickupEmployee;
	private static TableEmployee[] tableEmployeeThread;
    public static volatile int pickupTransfer = 0;
	public static volatile int tableTransfer = 0;
	public static volatile boolean falseFlag = false;
	public static volatile int helpMe;
	public static volatile int globalFlag = 0;
	public static volatile boolean tableOneFull = false;
	public static volatile boolean tableTwoFull = false;
	public static volatile boolean tableOneFlag = true;
	public static volatile int tableCount = 3;
	public static volatile int tableOneBusyWaitCount = 0;
	public static boolean restaurantOpen = true;
	public static AtomicIntegerArray globalArray;
	
	
	public static void main(String[] args) {
		
		customer = new DinnerCustomer[18];
		ArrayBlockingQueue<Integer> pickupqueue = new ArrayBlockingQueue<Integer>(18); 
		
		
		PickupEmployee = new PickUpEmployee(pickupqueue, 18);
		PickupEmployee.start();
		tableEmployeeThread = new TableEmployee[2];
		
		for(int i = 0; i < 2; i++)  {
		tableEmployeeThread[i] = new TableEmployee(Integer.toString(i));
	}
		
		for(int i = 0; i < 2; i++) {
			TableEmployee.threadCreation = true;
			tableEmployeeThread[i].start();
		}
		
		
		for (int i = 1; i < 18; i++) {
			customer[i] = new DinnerCustomer(Integer.toString(i));
		}
		
	
		for (int i = 1; i < 18; i++) {
			customer[i].start();
	
			
		
			
			if(pickupTransfer !=0 && !pickupqueue.contains(pickupTransfer)) {
				pickupqueue.add(pickupTransfer);
				
			if(PickUpEmployee.pickupavailable) {
				PickupEmployee.queueAdd(pickupTransfer);
			}
			
	  }
	}
  }
}

		

	

