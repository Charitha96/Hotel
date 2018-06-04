/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class main {
    
    //declaring variables
	static int rooms = 11;
        //creating static array to use in all places of the class
	static Room[] hotel= new Room[rooms];
	static String Customer;
	static int roomNumber = 0;
	//static String Customername;
	
	public static void main(String [] args){
		String Customer = null;
                //creating hotel array giving rooms
		//hotel = new Room[rooms];
                
                //initilise the rooms for customers
		create(hotel);
                
                //calling the menu for the hotel. When every time a method is done executing it will recall the menu for the user.
		menu();
	}
        //menu of the program
	private static void menu() {
		System.out.println("");
		System.out.println("                                                 Hotel Room Service");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Menu");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Press A to add a customer to a room");
		System.out.println("Press V to View all the rooms.");
		System.out.println("Press E to Display Empty rooms.");
		System.out.println("Press D to Delete customer from room.");
		System.out.println("Press F to Find room using customer name.");
		System.out.println("Press S to Store programme data in to file.");
		System.out.println("Press L to Load program data from file.");
		System.out.println("Press O to View rooms Orderes alphabetically by name.");
		System.out.println("Press Q to Exit");
		System.out.println("");
		System.out.println("Enter a key to proceed : ");
		System.out.println("");
		
		Scanner sc = new Scanner(System.in);
		
		//get the input from the user to what to do next
		String input = sc.next();
		
		//Validating the user inputs a Letter not an Integer
		if (!input.matches("[a-zA-Z_]+")) {
		    System.out.println("Invalid Input.Type a letter to continue.");
		    menu();
		}
                
		
		System.out.println("");
		    
                    //add customers to hotel array
		    if(input.equalsIgnoreCase("A")){
                        add(hotel);						
		    }
                    //view customers
		    if(input.equalsIgnoreCase("V")){
		    	view(hotel);
		    }
                    //delete customers
		    if(input.equalsIgnoreCase("D")){
                        delete(hotel);
		    }
		    if(input.equalsIgnoreCase("E")){
		    	empty(hotel);
		    }
                    //find customers from name
		    if(input.equalsIgnoreCase("F")){
		    	find(hotel);
		    }
                    //save in the computer
		    if(input.equalsIgnoreCase("S")){
		    	save(hotel);
		    }
                    //order names to alphabetical order
		    if(input.equalsIgnoreCase("O")){
		    	orderAlphabetically(hotel);
		    }
                    //load a program from the computer
		    if(input.equalsIgnoreCase("L")){
		    	load(hotel);
		    }
                    //Using this the program will terminate.
		    if(input.equalsIgnoreCase("Q")){
		    	System.exit(0);
		    } 
	}
        
        //create the hotel array by setting the rooms in to empty
	private static void create(Room[] hotel1) {
            
		for (int i = 0; i <rooms; i++ ){ 
                    //set the rooms in to empty
			hotel[i] = new Room();
			hotel[i].setName("empty");
			//hotel[i].setRoomNum(i);
			hotel[i].setRegNo(i);
                       //System.out.println(hotel[i]);
		}
	}
        
	//Add a customer to the room and set the name 
        private static void add(Room[] hotel) {
            Scanner input = new Scanner(System.in);
            //declaring variables to hold values for the customer
                int regNo = 0;
                String Name;
                String lName;
                
                //getting inputs
                System.out.println("Enter Customer Name for the Room : ");
                Name = input.next();  
                System.out.print("Enter Surname of the Customer : ");
                lName = input.next(); 
                System.out.println("Enter room number :");
                int roomNumber = input.nextInt();
                
                
                //setting the customer name and the register number in toRoom class's setter
                hotel[roomNumber].setRegNo(regNo);
                hotel[roomNumber].setName(Name);
                System.out.println("Customer Data successfully added to the hotel system.");
                System.out.println("");
                
        //calling back the menu to display
	menu();	
	}
        
        //View the all rooms with names of the customers
	private static void view(Room[] hotel) {
            //showing the rooms
		for(int i=1; i<rooms; i++){
			if(hotel[i].getName().equals("empty")){
                            System.out.println("The Room No "+i+ " is Empty");
				
			}else{
                            System.out.println("The Room No "+i+" is already booked by "+ hotel[i].getName());
                        }
		}
                System.out.println("");
        menu();
	}
        
        //Delete method
	private static void delete(Room[] hotel) {
            Scanner sc = new Scanner(System.in);
            //asking for the room number to delete the customer
            System.out.println("Enter the Room Number you want to delete the Customer from : ");
                int input = sc.nextInt();
                    hotel[input]=new Room();
                    
                    //removing the customer and set the customer name in to empty using setters
                    hotel[input].setRegNo(input);
                    hotel[input].setName("empty");
                    
                    System.out.println("The Customer has been succesfully removed from the No "+ hotel[input].getRegNo()+" room.");
                    
                    //showing the rooms which are empty and booked.
                    for(int i = 1; i<11; i++){
			if (hotel[i].getName().equals("empty")){
				System.out.println("The Room "+i+ " is empty");
			}else{
				System.out.println("The Room "+i+" is been booked by "+ hotel[i]);
			}
                    }
                    System.out.println("");
        menu();
	}
        
	//Find the name of the users in rooms
        private static void find(Room[] hotel) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name you want to find : ");
		String Name=sc.next();
		for(int i = 1; i<11; i++){
                    //comparing whether the names of the customers are equal to the input name
			if(hotel[i].getName().equals(Name)){
                            System.out.println("Room " + i + " is occupied by "+hotel[i].getName());
                        }else{
                            System.out.println("In Room No " + i +" There is no Customer by the Name you have entered.");
                        }
		}
                
                System.out.println("");
        menu();
	}
        
        
	//save data of the hotel 
	private static void save(Room[] hotel) {
		System.out.println("Output filename for the Data : ");
                Scanner sc = new Scanner(System.in);
		      String savedfile = sc.next();
                //used print writer to save data in the computer
		PrintWriter outputFile;
		try {
			outputFile = new PrintWriter(savedfile);
			//setting outputs for the saved file.
			for(int i=1; i < 11; i++){
                                if(hotel[i] != null){
					outputFile.println(hotel[i].getName()+" "+ i);
                                        
				}else{
                                    //closing the printwriter
                                    outputFile.close();
				}
			}
                        outputFile.close();
			System.out.println("File Succesfully Saved.");
			//System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
                System.out.println("");
        menu();
	}
        
        
        //load data from te previous saved files
        private static void load(Room[] hotel) {
            
		System.out.println("Enter file name to load data");
                        Scanner sc = new Scanner(System.in);

			String inputname = sc.next();
			File inputfile =new File(inputname);
			//calling the initialise method to clear previous entries
			
			create(hotel);

			try {
                            Scanner infromfile = new Scanner(inputfile);
                                while(infromfile.hasNext()){
                                    String roomName = infromfile.next();
                                    int roomnum = infromfile.nextInt();
                                    hotel[roomnum].setRegNo(roomnum);
                                    hotel[roomnum].setName(roomName);
                                    
                                }
				//Scanner closed
				infromfile.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("");
			menu();	
		}
        
        //Show the empty rooms of the hotel
	private static void empty(Room[] hotel) {
		
                for (int i = 1; i < rooms; i++ ){			
                    //check wheter the name is equals to empty and if it is yes it will show the room number
                    if (hotel[i].getName().equals("empty")){
                        System.out.println("The Room " + i + " is empty");
                    //}else{
                        //System.out.println(" The Room " + i + " occupied by " + hotel[i].getName());
                    }   
		}
                System.out.println("");
        menu();
        }
        
        //Order the names using Alphebet
	private static void orderAlphabetically(Room[] hotel) {
		Arrays.sort(hotel,Comparator);
                   
                for (int i=0; i<rooms; i++){
                   //getting the customer name to sort alperbetically
                   //using arrays.sort we compare hotel array using comparator
                   System.out.println(hotel[i].getName());
                   
                }
                System.out.println("");
        menu();
        }
        
        //Ordering done in here using the comparator
        public static Comparator<Room> Comparator = new Comparator<Room>() {
            //comparing the names of the room object.
            //Check the 1st name of the 1st room object and compare it with the 2nd room object.
		public int compare(Room obj1, Room obj2){
			
			return obj1.getName().compareTo(obj2.getName());
			}
	};
}