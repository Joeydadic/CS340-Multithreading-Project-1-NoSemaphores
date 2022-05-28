import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class TableEmployee implements Runnable {

	private Thread employeeTableThread;
	private ArrayBlockingQueue<Integer> employeeTableSeats;
	public static Boolean tableFull = false;
	static volatile int employeeCount = 0;
	static volatile Boolean threadCreation = false;
	static volatile int tableEmployeeCustomerCount;
	static volatile int globalTableInteger;
	static volatile Boolean eating = false;
	static volatile Boolean seatingWait = true;
	static volatile Boolean customersSeated = false;
	static volatile Boolean customersCanEat = false;
	static volatile Boolean customerLeaving = false;
	static volatile Boolean employeeThreadControl = false;
	static volatile Boolean customerPayOrder = false;
	public TableEmployee(String creator) {
		this.employeeTableThread = new Thread(this);
		this.employeeTableSeats = new ArrayBlockingQueue<Integer>(3);
	}
	
	
	public void start() {
		employeeCount++;
		this.employeeTableThread.setName("Table Employee " + employeeCount);
		this.employeeTableThread.setPriority(employeeCount);
		System.out.println(this.employeeTableThread.getName() + " has arrived to work.");
		this.employeeTableThread.start();
	}
	public void setName(String tableName) {
		this.employeeTableThread.setName(tableName);
	}
	public String getTableEmployeeThreadName() {
		return this.employeeTableThread.getName();
	}
	public void add(int customerAdd) {
		this.employeeTableSeats.add(customerAdd);
	}
	public void tableEmployeeGetCustomerName(Thread x) {
		x.getName();
	}
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			while(Main.restaurantOpen) {
				while(this.employeeTableThread.currentThread().getPriority() !=1 && !employeeThreadControl){
			}
				System.out.println(this.employeeTableThread.getName() + " has made it out.");
				this.employeeTableThread.currentThread().setPriority(8);
			while(this.employeeTableSeats.size() != 3 ) {
				if(!this.employeeTableSeats.contains(globalTableInteger) && globalTableInteger != 0) {
				this.employeeTableSeats.add(globalTableInteger);
				System.out.println(this.employeeTableSeats);
			}
	}
				int a = this.employeeTableSeats.peek();
				this.employeeTableSeats.poll();
				int b = this.employeeTableSeats.peek();
				this.employeeTableSeats.poll();
				int c = this.employeeTableSeats.peek();
				this.employeeTableSeats.poll();
				employeeThreadControl = true;
				globalTableInteger = 0;
				System.out.println(this.employeeTableThread.getName() + " has seated customers " + a + " " + b + " " + c);
				
				
					while(!DinnerCustomer.flag) {
				}
					
					System.out.println("Customer orders " + a + " " + b +  " " + c + " have been taken.");
					this.employeeTableThread.currentThread().sleep(3000);
					System.out.println("Customer's " + a + " " + b + " " + c + " have received their orders.");
					customersCanEat = true;
					DinnerCustomer.flag = false;
					while(!DinnerCustomer.readyToPay) {
					if(DinnerCustomer.payCount == 1) {
						System.out.println(this.employeeTableThread.getName() + " has given the customer their bill.");
						customerLeaving = true;
						DinnerCustomer.payCount--;
						
				}
					}
					this.employeeTableThread.setPriority(2);
					System.out.println(this.employeeTableThread.getName() + " is finished with their table.");
					employeeThreadControl = false;
			}
					
			
			
		
	
		
		}catch(InterruptedException e) {
			
		}
		
	} 
	
}
