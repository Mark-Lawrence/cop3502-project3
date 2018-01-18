import java.util.Scanner;
public class TestAddCustomer {

	public static void main (String[] args){
		Scanner s = new Scanner(System.in);
		TattooCustomer[][] waitlist = new TattooCustomer[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
		int loopControl =0;

		//Infinite loop until the special name "Print Waitlist is entered"
		while (loopControl==0){
			System.out.println("Please enter your name:");
			String name=s.nextLine();

			//breaks loop if Print Waitlist is entered
			if(name.equals("Print Waitlist")){
				break;}

			//Asks for user input
			System.out.println("Please enter what type of tattoo you would like:");
			String tattoo=s.nextLine();
			System.out.println("Which technician would you like? (Enter an integer 0-"+(Integer.parseInt(args[0])-1) +", or hit the enter key for no preference)");
			String technician =s.nextLine();
			System.out.println("How long will this tatoo take? Enter an integer in minutes.");
			int time = s.nextInt();
			String blank = s.nextLine();
			//Saves customer data to class TattooCustomer
			TattooCustomer customer = new TattooCustomer(name,tattoo,time);

			//If the customer does not choose a technician, they will be assigned one
			if(technician.equals("")){
				boolean valid =addCustomer(waitlist,customer);
				if (valid==false)
					System.out.println("ERROR: All technicians are full");
			}
			//Check to see if they can be added to the technician they chose 
			else{
				boolean valid =addCustomer(waitlist,customer,Integer.parseInt(technician));
				if (valid==false)
					System.out.println("ERROR: Technician "+technician+" is full");
			}
		}
		printWaitlist(waitlist);

	}

	/**
	 * Computes how many minutes of work the specified tattoo artist has.
	 * @param TattooCustomer [][] a: The array of customers for one particular tattoo artist
	 * @return All the minutes added up of the one tattoo artist (not including the current customer being added)
	 */
	public static int computeMinutesOfWork(TattooCustomer [] a) {
		int countMins=0;
		//Loops through a technicians array and adds up how many minutes that technician has
		for(int i=0; i<a.length;i++){
			//Does not add if the time is null
			if (a[i]!=null)
				countMins += a[i].getMinutes();
		}

		return countMins; 
	}
	/**
	 * Adds customer to the wait list for a specific artist.
	 * If the artist is at capacity (in terms of number of customers or minutes)
	 * Then the customer is not added and the method returns false
	 * If the customer is successfully added the method returns true
	 * @param TattooCustomer [][] a: A 2D array of all the technicians and their current customers 
	 * @param TattooCustomer c: The TattooCustomer current customer to be added to the wait list array
	 * @param int artistNum: The technician number selected by the user
	 * @return true if the customer was added to the wait list, false otherwise (if the chosen artists were full)
	 */
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c, int artistNum) {
		int lastSpot=0;
		int i=0;

		//finds out which spot in the array to place the next avalible customer
		for(i=0; i<a[artistNum].length;i++){
			if (a[artistNum][i]==null){
				lastSpot=i+1;
				break;
			}
		}
		//Adds the customer to the location in list if the technician isn't full (because he has too 
		//many people already on his list or his customers already or if that technician has 8 hours of work
		//already)
		if ((computeMinutesOfWork(a[artistNum])+c.getMinutes()<480) && lastSpot!=0){
			a[artistNum][lastSpot-1]=c;
			return true;
		}

		else
			return false;
	}
	/**
	 * Adds customer to the shortest wait list in terms of minutes. If some artists have equal length wait lists
	 * then the customer is added to the lowest numbered artist. If no artist has space then the method does not 
	 * add the customer, and returns false.
	 * @param TattooCustomer [][] a: A 2D array of all the technicians and their current customers 
	 * @param TattooCustomer c: The TattooCustomer current customer to be added to the wait list array
	 * @return true if the customer was added to the wait list, false otherwise (if all artists were full) */
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c) {
		int shortest = 480;
		int artistWithShort=-1;
		//Find technician with shortest wait, Saves that tecnician's number to artistWithShort 
		for (int i=0;i<a.length;i++){
			//First checks to see if that artist is full or not
			for(int j=0; j<a[i].length;j++){
				if (a[i][j]==null){
					//If that artist is empty, checks to see if it is the shortest (in terms of minutes)
					if(computeMinutesOfWork(a[i])<shortest){
						shortest=computeMinutesOfWork(a[i]);
						artistWithShort=i;
					}

				}
			}
		}
		//if they are all full or too long, return false
		if (artistWithShort==-1){
			return false;}
		else{
			return addCustomer(a,c,artistWithShort);}
	}

	//Code from other method to place the person from other method
	

	/** 
	 * Takes in the array and formats a string to print all of the technicians, each of their customers, each 
	 * customer's design, and the estimated time of each design 
	 * @param TattooCustomer [][] list: The 2D array with all the technicians and TattooCustomer customers
	 */

	public static void printWaitlist(TattooCustomer[][] list){
		String stringToPrint ="\n";
		//Loops through array for each technician
		for (int i = 0; i < list.length; i++) {
			stringToPrint+="Technician "+i+":\n";
			//Adds the customers names, design, and time to the string 
			for (int j = 0; j < list[0].length; j++){
				//Doesn't add anything to string if customers name is not added (null)
				if (list[i][j]==null)
					stringToPrint+="";
				else
					stringToPrint+=(j+1)+".  "+list[i][j].getName()+" \tDesign: "+list[i][j].getTattoo()+"\tEstimated time: "+list[i][j].getMinutes()+" minutes\n";
			}
			stringToPrint+="\n";
		}
		System.out.println(stringToPrint);
	}

}
