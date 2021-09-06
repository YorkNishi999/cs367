package prog1;

import java.util.Random;

/**
 * The User class uses DLinkedList to build a price ordered list called 
 * 'machineList' of machines.
 * Machines with higher price fields should come earlier in the list.
 */
public class User {
    //Random number generator, used for generateMachineStock. DO NOT CHANGE
    private static Random randGen = new Random(1234);
    
    private String username;
    private String passwd;
    private double credit;
    private ListADT<Machine> machineList;
    
    /**
     * Constructs a User instance with a name, password, credit and an empty 
     * machineList. 
     * 
     * @param username name of user
     * @param passwd password of user
     * @param credit amount of credit the user had in $ 
     */
    public User(String username, String passwd, double credit) {
    }
    
    /**
     * Checks if login for this user is correct.
     *
     * @param username the name to check
     * @param passwd the password to check
     * @return true if credentials correct, false otherwise
     * @throws IllegalArgumentException if arguments are null 
     */
    public boolean checkLogin(String username, String passwd) {
    }
    
    /**
     * Adds a machine to the user's machineList. 
     * Maintain the order of the machineList from highest priced to lowest 
     * priced machines.
     * @param machine the Machine to add
     * @throws IllegalArgumentException if arguments are null 
     */
    public void addToMachineList(Machine machine) {
    }
    
    /**
     * Removes a machine from the user's machineList. 
     * Do not charge the user for the price of this machine
     * @param machineName the name of the machine to remove
     * @return the machine on success, null if no such machine found
     * @throws IllegalArgumentException if arguments are null
     */
    public Machine removeFromMachineList(String machineName) {
    }
    
    /**
     * Print each machine in the user's machineList in its own line by using
     * the machine's toString function.
     */
    public void printMachineList() {
    }
    
    /**
     * Rents the specified machine in the user's machineList.
     * Charge the user according to the price of the machine by updating the 
     * credit.
     * Remove the machine from the machineList as well.
     * Throws an InsufficientCreditException if the price of the machine is 
     * greater than the credit available. Throw the message as:
     * Insufficient credit for <username>! Available credit is $<credit>.
     * 
     * @param machineName name of the machine
     * @return true if successfully bought, false if machine not found 
     * @throws InsufficientCreditException if price > credit 
     */
    public boolean rent(String machineName) throws InsufficientCreditException{
    }
    
    /** 
     * Returns the credit of the user
     * @return the credit
     */
    public double getCredit() {
    }

    /**
     * This method is already implemented for you. Do not change.
     * Declare the first n machines in the currentUser's machineList to be 
     * available.
     * n is generated randomly between 0 and size of the machineList.
     * 
     * @returns list of machines in stock 
     */
    public ListADT<Machine> generateMachineStock() {
        ListADT<Machine> availableMachines = new DLinkedList<Machine>();

        int size = machineList.size();
        if(size == 0)
            return availableMachines;
       
       //N items in stock where n >= 0 and n < size
        int n = randGen.nextInt(size+1); 

        //pick first n items from machineList
        for(int ndx = 0; ndx < n; ndx++)
            availableMachines.add(machineList.get(ndx));
        
        return availableMachines;
    }

}