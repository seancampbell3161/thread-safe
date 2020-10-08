
import java.util.logging.Level;
import java.util.logging.Logger;


public class Person implements Runnable {
    
    // class variables
    private String firstName;
    
    private String lastName;
    
    //constructor
    public Person (String firstName, String lastName) {
        
        this.firstName = firstName;
        
        this.lastName = lastName;
        
    }
    
    @Override
    //runnable thread method
    public void run () {
        
        //printing start/end of jobs and putting thread to sleep for 5 seconds
        try {
            System.out.println(firstName + " " + lastName + " has started working");
            
            Thread.sleep(5000);
            
            System.out.println(firstName + " " + lastName + " has finished their job");
        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } //end method run
    
} //end class
