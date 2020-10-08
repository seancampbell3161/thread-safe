
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccountSavings {
    
    //initialize variables
    public double annualInterestRate = 0.053;
    
    private double savingsBalance = 10;
    
    private double interest = 0;
    
    
    //method for compound interest
    public synchronized void compoundInterest () {
        
        interest = savingsBalance * Math.pow( 1 + (annualInterestRate / 12),12 ) - savingsBalance;
        
        savingsBalance += interest;
    }
    
    //method for running threads
    public void runThreads () {
        
        //create new thread
        Thread t1 = new Thread (
        
        new Runnable () {
            
            @Override
            public void run () {
                
                //run compound interest method 4800 times
                try {
                    for (int i=0; i<4800; i++) {
                        
                        compoundInterest();
                        
                    }
                    
                    //sleep for 5 seconds
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        ); //anonymous inner class
        
        //create new thread
        Thread t2 = new Thread (
        
        new Runnable () {
            
            @Override
            public void run () {
                
                //run compound interest method 1200 times
                for (int i=0; i<1200; i++) {
                    
                    compoundInterest();
                    
                }
                
            }
        }
        
        ); //anonymous inner class 
        
        //initialize threads
        t1.start();
        t2.start();
        
        try {
            //join method - main thread to wait

            t1.join();
            t2.join();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //print balance and interest rate
        System.out.println("savings balance is " + savingsBalance +
                " and annual intereste rate is " + (annualInterestRate *100) + 
                "%");
         
        
    }

    
    public static void main(String[] args) {
       
        //create runnable object from class accountsavings
       AccountSavings t1 = new AccountSavings();
       
       
      
           //execute runthreads method
           t1.runThreads();
             
    }
    
}
