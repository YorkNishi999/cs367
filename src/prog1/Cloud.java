package prog1;
import java.util.Scanner;

/**
 * Main class which simulates the cloud environment.
 */
public class Cloud {

    //Store record of users and machines
    private static ListADT<Machine> machines = new DLinkedList<Machine>();
    private static ListADT<User> users = new DLinkedList<User>();
    private static User currentUser = null;//current user logged in

    //scanner for console input
    public static final Scanner stdin = new Scanner(System.in);

    //main method
    public static void main(String args[]) {

        //Populate the two lists using the input files: Machines.txt User1.txt 
        //User2.txt ... UserN.txt
        if (args.length < 2) {
            System.out.println("Usage: java Cloud [MACHINE_FILE] [USER1_FILE] [USER2_FILE] ...");
            System.exit(0);
        }

        //load store machines
        loadMachines(args[0]);

        //load users one file at a time
        for(int i = 1; i< args.length; i++) {
            loadUser(args[i]);
        }

        //User Input for login
        boolean done = false;
        while (!done) 
        {
            System.out.print("Enter username : ");
            String username = stdin.nextLine();
            System.out.print("Enter password : ");
            String passwd = stdin.nextLine();

            if(login(username, passwd) != null)
            {
                //generate random items in stock based on this user's machine 
                //list
                ListADT<Machine> inStock = currentUser.generateMachineStock();
                //show user menu
                userMenu(inStock);
            }
            else
                System.out.println("Incorrect username or password");

            System.out.println("Enter 'exit' to exit program or anything else to go back to login");
            if(stdin.nextLine().equals("exit"))
                done = true;
        }

    }

    /**
     * Tries to login for the given credentials. Updates the currentUser if 
     * successful login
     * 
     * @param username name of user
     * @param passwd password of user
     * @returns the currentUser 
     */
    public static User login(String username, String passwd) {
        return null;
    }

    /**
     * Reads the specified file to create and load machines into the cloud. 
     * Every line in the file has the format: 
     * <MACHINE NAME>#<NUMBER OF CPUs>#<MEMORY SIZE>#<DISK SIZE>#<PRICE> 
     * Create new machines based on the attributes specified in each line and insert 
     * them into the machines list.
     * Order of machines list should be the same as the machines in the file.
     * For any problem in reading the file print: 'Error: Cannot access file'
     * 
     * @param fileName name of the file to read
     */
    public static void loadMachines(String fileName) {
    }

    /**
     * Reads the specified file to create and load a user into the cloud. 
     * The first line in the file has the format:<NAME>#<PASSWORD>#<CREDIT> 
     * Every other line after that is the same format as the machines file:
     * <MACHINE NAME>#<NUMBER OF CPUs>#<MEMORY SIZE>#<DISK SIZE>#<PRICE> 
     * For any problem in reading the file print: 'Error: Cannot access file'
     * 
     * @param fileName name of the file to read
     */
    public static void loadUser(String fileName) {
    }

    /**
     * The order of the machines should be the same as in input machines file. 
     * The output format should be the consolidated String format mentioned in 
     * Machine class.
     */

    public static void printMachines() {
    }

    
    /**
     * Interacts with the user by processing commands
     * 
     * @param inStock list of machines that are available to rent
     */
    public static void userMenu(ListADT<Machine> inStock) {

        boolean done = false;
        while (!done) 
        {
            System.out.print("Enter option : ");
            String input = stdin.nextLine();

            //only do something if the user enters at least one character
            if (input.length() > 0) 
            {
                String[] commands = input.split(":");//split on colon, because 
                                                     //names have spaces in them
                if(commands[0].length()>1)
                {
                    System.out.println("Invalid Command");
                    continue;
                }
                switch(commands[0].charAt(0)) {
                case 'v':
                    break;

                case 's':
                    break;

                case 'a':
                    break;

                case 'r':
                    break;

                case 'b':
                    break;

                case 'c':
                    break;

                case 'l':
                    done = true;
                    System.out.println("Logged Out");
                    break;

                default:  //a command with no argument
                    System.out.println("Invalid Command");
                    break;
                }
            }
        }
    }

}