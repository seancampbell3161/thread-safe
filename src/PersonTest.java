
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class PersonTest {
    
    public static void main(String[] args) {
        
        //executor for fixed threads with pool of 3
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        //iterating through 4 threads
        for (int i=1; i<5; i++) {
            
            executor.submit(new Person("firstname", "lastname"));
            
        }
        
        executor.shutdown();
        
        System.out.println("All tasks submitted");
        
        //await termination so as not to wait past the time
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(PersonTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        System.out.println("All tasks are finished");
       
    } //end main
    
} //end class
