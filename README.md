# CS340-Multithreading-Project-1-NoSemaphores
This project was done for my CS 340 Operating Systems Principles course at CUNY Queens College. Dr. Simina Fluture gave us an arbitrary scenario in which each student individually was required to implement using Multithreading in Java WITHOUT the usage of Semaphores.

Below is the description of the arbitrary scenario.

The project must be done individually - no exceptions. Plagiarism is not accepted. Changing 
the name of variables and the methods around will not make the project yours. Receiving 
and/or giving answers and code from/to other students enrolled in this or a previous 
semester, or a third-party source including the Internet is academic dishonesty subject to 
standard University policies. 


The objective of this project is to familiarize you with the creation and execution of threads 
using the Thread class methods. You should use, when necessary, the following methods to 
synchronize all threads: run(), start(), currentThread(), getName(), join(), yield(), 
sleep(time), isAlive(), getPriority(), setPriority(), interrupt(), isInterrupted().
The use of semaphores to synchronize threads is strictly DISALLOWED. Additionally, you are 
NOT PERMITTED to use any of the following: wait(), notify(), notifyAll(), the synchronized 
keyword (for methods or blocks), and any synchronized collections or synchronization tools that 
were not discussed in class or mentioned here.

You CAN, however, use the modifier volatile and the AtomicInteger and AtomicBoolean
classes if you choose to.

Directions: Synchronize the customer, pickup_order_employee, table_employee threads in 
the context of the problem described below. The number of customers can be entered as a 
command line argument. Please refer to and read carefully the project notes, tips and 
guidelines before starting the project.


                                        Dining out or just Pick up
Finally, the work day has ended. It is time to eat. Some are dining out, some will just pick up their 
order.
Customers commute to the dinner in different ways (simulated by sleep of random time). Once they 
get to the restaurant, they decide if they will pick up the order or dine in (by generating a random 
number between 1 and 10; if the number is greater than 2 – dine in, else just pick up). 

If the customer decided to pick up, (s)he will get in the pickup line and busy wait to place the order. 
At the pickup line there is only one employee, let’s name it pickup_order_employee. He will attend to 
customers in FCFS order, and take their order. Next, he will work on the order (simulated by sleep of 
random time) while now the customer will wait (simulated by sleep of long time) for him to be done. 
The pickup_order_employee will let the customer know when the order and the bill are ready by 
interrupting the customer (use interrupt() and isInterrupted( ); please assure that the customer has a 
println inside the catch block so you can check the interrupt). Next the customer will pay (simulated by 
sleep of random time) and leave (terminate). The pickup_order_employee should have a while loop in 
its code. It will be able to terminate when the restaurant closes.

If the customer decided to dine in, it will busy wait to be seated. The restaurant is very popular so 
every table needs to be in use before another table can be used. There are numTables tables. Each 
table has numSeats seats. The table_employee will create groups of customers based on the order 
they arrive and numSeats. When a table becomes available and there is a complete group of 
customers busy waiting, he will invite that group of customers to the table. Note: There is the 
possibility for the very last group/table to not be complete, make sure you consider this situation as 
well. 

Note: once a table is occupied, if there is more than one table available, the table_employee will seat 
the next available group if one was created.

Once seated, the customer will check the menu and rush to place the order (simulate this by 
increasing their priority. Use getPriority(), setPriority(), and sleep(random time). After the customer 
has increased its priority, (s)he will sleep a random time and as soon as (s)he wakes up make sure 
you reset his/her priority back to the normal value). The table_employee who seated the customers, 
will busy wait until all the orders are in place. While customers might be able to decide (sleep of 
random time) concurrently, they will place the order one by one.

Note: after taking the orders, if the table_employee already seated customers at another table, (s)he 
will go and get the orders from that table as well. 

The same table_employee, who took the order, will bring in the food. Customers will enjoy their food 
without rushing (simulate this by sleep of random time followed by yield() twice). Once done they will 
try to get the attention of the same employee that served them. Each customer might finish at a 
different time. The customer will busy wait until they will be able to pay. After paying they will leave.
Note: you need to have the table_employee frequently check if there is a customer who needs to get 
the check and leave.

Once the table becomes empty another group will be allowed to be seated.
The restaurant closes after all customer threads have been served (one way or another). This will be 
done in a specific order (use isAlive() and join() to enforce this order). 
The pickup_order_employee will leave first. Next, table_employee(s) will leave, in decreasing order of 
the number of attended tables. 


Note: you need to keep track of how many tables each table_employee served.
----------------------------------------------------------------------------------------------------------------------------------------
Default values
numCustomers = 17
numTables = 3
numSeats = 3
num_table_employee = 2
