import java.util.ArrayList;
import java.util.Scanner;

public class Driver{

	public static void printString(String string){
		System.out.print(string);
	}

	public static void ln(){
		System.out.println("");
	}

	public static void hotelManage(ArrayList<Hotel> hotelList){
		Scanner scan = new Scanner(System.in);
		int choiceInput;
		String buffer;
		boolean quit = false;
		String confirmation;
		Management.out();
		do{
			printString("------------------------------");
			ln();
			printString("Select Choice: ");
			ln();
			printString("0: Quit");
			ln();
			printString("1: Add Hotel");
			ln();
			printString("2: View Hotel");
			ln();
			printString("3: Manage Hotel");
			ln();
			printString("4: Simulate Booking");
			ln();
			
			System.out.print("\nInput number of choice: ");
			
			choiceInput = scan.nextInt();
			switch (choiceInput){
				case 0:
					quit = true;
					/*
					System.out.print("\033[H\033[2J");  
					System.out.flush();  
					*/
					Management.out();
					System.out.println("Application closed");
					break;
				case 1:
					// adds a hotel
					Management.out();
					String stringInput;
					/*
					do
					{
					*/
						int intInput;
						float floatInput;
						System.out.println("|Hotel creation|\n");
						boolean taken = true;
						buffer= scan.nextLine();
						do{
							taken = false;
						System.out.print("Input Hotel Name: ");
						stringInput = scan.nextLine();
						for(int i = 0; i < hotelList.size(); i++){
							if(stringInput.equals(hotelList.get(i).getHotelName())){
								taken = true;
							}

							if(taken == true){
								System.out.println("Hotel name taken");
								System.out.println("-press any key to continue-");
								buffer = scan.nextLine();
							}
						}
						}while(taken == true);

						if(stringInput.equals("EXIT")){
							break;
						}

						do{
							System.out.println("");
							System.out.print("Input number of rooms: ");
							intInput = scan.nextInt();
							if(intInput<1 || intInput>50){
								printString("Room input is invalid, please try again.");
								ln();
							}
						} while(intInput<1 || intInput>50);

						do{
							System.out.println("");
							System.out.print("Input pricing per night (input 0 for default): ");
							floatInput = scan.nextFloat();
							if(floatInput == 0)
								floatInput = 1299.00f;
							if(floatInput < 100){
								printString("Invalid input, minimum is 100, please try again.");
								ln();
							}
						}while(floatInput<100);

						if(hotelList.add(new Hotel(stringInput, intInput, floatInput)))// arrayList will return 1 if successfully changed.
							Management.out();
							System.out.println("Hotel added!");
						System.out.println("");

						//System.out.println("--------------------");
						/*
					}while(!stringInput.equals("EXIT"));
					*/
					break;

				case 2: // view hotel
					/*In this feature, the user can view the current information found in a selected hotel. This would
					include high-level information of the hotel and low-level information based on what the user would
					like to see. See the following for more information:
					a. High-level hotel information should include the name of the hotel, total number of rooms,
					estimate earnings for the month (i.e. sum of total price across all reservations)
					b. Available low-level information should include the following:
					i. Total number of available and booked rooms for a selected date
					ii. Information about a selected room, such as the room’s name, price per night, and
					availability across the entire month
					iii. Information about a selected reservation, such as the guest information, room
					information, check-in and -out dates, the total price for the booking, and the
					breakdown of the price per night*/
					Management.out();
					if(hotelList.size() != 0) {
					
					int hotelIndex;
					String hotelSearch;
					int levelChoice;

					ln();
					printString("------------------------");
					ln();
					// show a list of all hotels
					for(int i = 0; i<hotelList.size(); i++){
						System.out.println((i + 1) + "." + " " + hotelList.get(i).getHotelName());
						ln();
					}

					do{
						ln();
						printString("Input the hotel's name: ");
						//buffer = scan.nextLine();
						hotelSearch = scan.nextLine();
						hotelIndex = Management.getHotelIndex(hotelSearch, hotelList);
					}while(hotelIndex == -1);


					//Total number of rooms
					boolean exit = false;
					
					do {
						Management.out();
					System.out.println("|Hotel "+ hotelList.get(hotelIndex).getHotelName() + "|");
					printString("Would you like to view : \n(1) High Level info\n(2) Low Level info\n(0) Exit");
					ln();
					
					printString("\nInput: ");
					levelChoice = scan.nextInt();

					switch(levelChoice){

							case 0:
							
							Management.out();
								exit = true;
								break;

							case 1:
							// high level
							ln();
							printString("Name of hotel: ");
							System.out.print(hotelList.get(hotelIndex).getHotelName());
							ln();
							printString("Total number of rooms: ");
							System.out.print(hotelList.get(hotelIndex).getRoomsList().size());
							ln();
							printString("Estimated earnings for the month: ");
							System.out.print(hotelList.get(hotelIndex).getTotalEarnings());
							ln();
							ln();
							System.out.println("-Press enter to continue-");
							buffer = scan.nextLine();
							buffer = scan.nextLine();
							System.out.println(buffer);
							Management.out();
							ln();
							ln();

								break; // case break

							case 2:
								// low level
								Management.out();
								int lowLevelChoice;

								printString("What information would you like to view?");
								ln();
								printString("1. Total number of available rooms and booked rooms for a specified date.");
								ln();
								printString("2. Information about a selected room. (");
								printString("room's name, price per night, and availability across the entire month)");
								ln();
								printString("3. Information about a selected reservation. ");
								ln();
								
								printString("\nInput: ");
								lowLevelChoice = scan.nextInt();
								switch(lowLevelChoice){
									case 1:
										int date;
										boolean open = false;
										do {
											open = true;
											printString("\nInput a valid specific date: ");
											date = scan.nextInt();
											if(date < 1 || date > 30) {
												System.out.println("Invalid Date");
												open = false;
											}
										}while(open == false);
										
										System.out.print("\nTotal number of available rooms for " + date + ": ");
										System.out.println(hotelList.get(hotelIndex).getRoomAvailability(date));
										ln();
										System.out.println("-Press enter to continue-");
										buffer = scan.nextLine();
										buffer = scan.nextLine();
										Management.out();
										ln();
										break;
									case 2:
										int roomInput;
										int roomIndex;
										
										
										System.out.println("Rooms List:");
										hotelList.get(hotelIndex).showRoomList();
										ln();

										do{
											printString("Input a valid room number from the list: ");
											roomInput = scan.nextInt();
											roomIndex = hotelList.get(hotelIndex).getRoomIndex(roomInput);
											if(roomInput <= 0){
												printString("Please input a valid room.");
												ln();
											}
											if(roomIndex <= -1){
												printString("Room inputted does not exist, please try again.");
												ln();
											}
											
										}while(roomInput<0 || roomIndex == -1); // error check
										ln();
										Management.displayRoom(hotelList.get(hotelIndex).getRoomsList().get(roomIndex));
										ln();
										System.out.println("-Press enter to continue-");
										buffer = scan.nextLine();
										buffer = scan.nextLine();
										Management.out();
										break;
									case 3:
										if(hotelList.get(hotelIndex).getReservationsList().size() != 0) {
										ln();
										System.out.println("Guest List:");
										for(int i = 0; i < hotelList.get(hotelIndex).getReservationsList().size(); i++) {
											System.out.println(i+ ": " + hotelList.get(hotelIndex).getReservationsList().get(i).getGuestName());
										}
										int reservationInput;
										int reservationIndex;
										boolean isGood = false;
										do{
											ln();
											printString("Input a guest Index: ");
											reservationInput = scan.nextInt();
											if(reservationInput >= 0 && reservationInput < hotelList.get(hotelIndex).getReservationsList().size()){
												isGood = true;
												ln();
												Management.displayReservation(hotelList.get(hotelIndex).getReservationsList().get(reservationInput));
											}
											//reservationIndex = hotelList.get(hotelIndex).getReservIndex(reservationInput);
										}while(isGood == false);
										/* 
										if(reservationIndex != -1){
											Management.displayReservation(hotelList.get(hotelIndex).getReservationsList().get(reservationIndex));
											ln();
											 */
										System.out.println("-Press enter to continue-");
										buffer = scan.nextLine();
										buffer = scan.nextLine();
										Management.out();
										
										}
										else {
											System.out.println("No Reservations currently");
											ln();
										System.out.println("-Press enter to continue-");
										buffer = scan.nextLine();
										buffer = scan.nextLine();
										Management.out();
										}

										
										break;
										
									default:
								}

								break; // case break


							default:
								printString("Invalid Input. please try again.");
					}
					}while(exit == false);



					}
					else {
						System.out.println("No hotels Exist Currently");
					}
					break; // case break
					//HOTEL MANAGEMENT
				case 3:
				Management.out();
					if(hotelList.size() != 0) {
					String input;
					int hotelIndexManage = -1;
					do {
					printString("Choose Hotel to Manage:\n");
					if(hotelList.size() != 0) {
						for(int i = 0; i < hotelList.size(); i++) {
							System.out.println("- " + hotelList.get(i).getHotelName());
						}
					}
					else {
						printString("No hotels exist currently\n");
					}
					
					ln();
					System.out.print("Input: ");
					//buffer = scan.nextLine();
					input = scan.nextLine();
					
					//loop to get hotel index
					for(int i = 0; i < hotelList.size(); i++) {
						if(hotelList.get(i).getHotelName().equals(input)) {
							hotelIndexManage = i;
							break;
						}
					}
					
					if(hotelIndexManage == -1) {
						System.out.println("Invalid Hotel Name");
					}
					Management.out();
					} while(hotelIndexManage == -1);

					boolean quitManage = false;

					

					do{
					Management.out();
					System.out.println("Hotel: " + hotelList.get(hotelIndexManage).getHotelName() + "\n");
					System.out.println("0: Quit");
					System.out.println("1: Change Hotel Name");
					System.out.println("2: Add rooms");
					System.out.println("3: Remove rooms");
					System.out.println("4: Update Price");
					System.out.println("5: Remove Reversation");
					System.out.println("6: Remove Currently Selected Hotel");
					
					System.out.print("\nInput: ");
					input = scan.next();
					
					boolean valid = false;//for loops and shiz
					
					switch(input) {
						case "0":
							quitManage = true;
							Management.out();
							break;
						case "1":
						buffer = scan.nextLine();
							do{
								valid = true;
								System.out.print("\nInput new hotel name: ");
								//buffer = scan.nextLine();
								input = scan.nextLine();
								
								for(int i = 0; i < hotelList.size(); i++) {
									if(input.equals(hotelList.get(i).getHotelName()) && i != hotelIndexManage) {
										valid = false;
									}
								}
								
								if(valid == false) {
									System.out.println("Hotel Name is taken");
								}
								
							}while(valid == false);
							
							hotelList.get(hotelIndexManage).changeHotelName(input);
							
							break;
							
						case "2":
							if(hotelList.get(hotelIndexManage).getRoomsList().size() == 50) {
								System.out.println("Hotel is at max rooms");
								System.out.println("- Press any key to continue - ");
										buffer = scan.nextLine();
										buffer = scan.nextLine();
								break;
							}
							
							int addRooms;
							
							valid = false;
							
							do {
								//System.out.println("Hotel: " + hotelList.get(hotelIndexManage).getHotelName());
								ln();
								System.out.println("Current number of rooms: " + hotelList.get(hotelIndexManage).getRoomsList().size());
								System.out.print("Input number of rooms to be added:");
								addRooms = scan.nextInt();
								
								if(addRooms + hotelList.get(hotelIndexManage).getRoomsList().size() > 50 && addRooms > 0){
									System.out.println("Number of rooms cannot exceed 50\n");
								}
								else if(addRooms < 0) {
									System.out.println("Input must be a positive number\n");
								}
								else {
									hotelList.get(hotelIndexManage).addRoom(addRooms);
									valid = true;
								}
								
								
							}while(valid == false);
							
							break;
						//remove room
						case "3":
							//System.out.println("Hotel: " + hotelList.get(hotelIndexManage).getHotelName());
							System.out.println("Rooms:\n");
				
							hotelList.get(hotelIndexManage).showRoomList();
							
							int removeRoom = -1;
							int roomIndex = -1;

							valid = false;
							do {
								System.out.print("Input Room Number to be removed: ");
								removeRoom = scan.nextInt();
								
								for(int i = 0; i < hotelList.get(hotelIndexManage).getRoomsList().size(); i++) {
									if(removeRoom == hotelList.get(hotelIndexManage).getRoomsList().get(i).getRoomName()) {
										valid = true;
										roomIndex = i;
									}
								}
								
								if(valid == true) {
									if(hotelList.get(hotelIndexManage).getRoomsList().get(roomIndex).getDatesBooked().size() != 0) {
										System.out.println("Cannot remove a booked room");
										System.out.println("- Press any key to continue - ");
										buffer = scan.nextLine();
										buffer = scan.nextLine();
									}
									else
									{
										System.out.println("Are you sure you want to remove this room?");
										System.out.print("Input (y) yes , (n) no: ");
										confirmation = scan.next();
										if(confirmation.equals("y")){
											hotelList.get(hotelIndexManage).removeRoom(removeRoom);
										}
									}
								}
								else {
									System.out.println("Invalid room name");
								}
								
								
							}while(valid == false);
							
							break;
							
						case "4":
							if(hotelList.get(hotelIndexManage).getReservationsList().size() == 0){
							valid = false;
							float price = 0;
							do {
								//System.out.println("Hotel: " + hotelList.get(hotelIndexManage).getHotelName());
								System.out.println("Current Price: " + hotelList.get(hotelIndexManage).getPrice());
								
								System.out.print("\nInput: ");
								price = scan.nextFloat();
								
								if(price < 100) {
									System.out.println("Invalid price\n");
								}
								/* 
								else if(hotelList.get(hotelIndexManage).changePrice(price) == false) {
									System.out.println("There are rooms currently booked, cannot configure price");
								}
									*/
								
								else
								{
									hotelList.get(hotelIndexManage).changePrice(price);
									valid = true;
								}
								
							}while(valid == false);

						}
						else{
							System.out.println("There are rooms currently booked, cannot configure price");
							System.out.println(" - Press enter to cotinue - ");
							buffer = scan.nextLine();
							buffer = scan.nextLine();
						}
							
							break;
							
						case "5":
							if(hotelList.get(hotelIndexManage).getReservationsList().size() != 0) {
							valid = false;
							String guest;
							int guestIndex;
							do {
								//System.out.println("Hotel: " + hotelList.get(hotelIndexManage).getHotelName());
								ln();
								printString("Guest List\n");
								for(int i = 0; i < hotelList.get(hotelIndexManage).getReservationsList().size(); i++) {
									System.out.println( i+ ": " + hotelList.get(hotelIndexManage).getReservationsList().get(i).getGuestName());
								}
								
								printString("Input Guest Index: ");
								guestIndex = scan.nextInt();
								/* 
								for(int i = 0; i < hotelList.get(hotelIndexManage).getReservationsList().size(); i++) {
									if(hotelList.get(hotelIndexManage).getReservationsList().get(i).getGuestName().equals(guest)) {
										valid = true;
									}
								}
								*/
								if(guestIndex >= 0 && guestIndex < hotelList.get(hotelIndexManage).getReservationsList().size()){
									valid = true;
								}
								if(valid == false) {
									System.out.println("Input valid guest Index");
								}
								else {
									System.out.println("Are you sure you want to remove this reservation?");
										System.out.print("Input (y) yes , (n) no: ");
										confirmation = scan.next();
										if(confirmation.equals("y")){
											hotelList.get(hotelIndexManage).removeReservation(guestIndex);
										}
								}
								
							}while(valid == false);
							}
							else {
								System.out.println("No reservations currently");
								System.out.println("\n-Press enter to continue-");
								buffer = scan.nextLine();
								buffer = scan.nextLine();
								
							}
							break;
									
						case "6":
										System.out.println("Are you sure you want to remove this hotel?");
										System.out.print("Input (y) yes , (n) no: ");
										confirmation = scan.next();
										if(confirmation.equals("y")){
											hotelList.remove(hotelIndexManage);
											quitManage = true;
											
										}
										Management.out();
							
							break;

							default: 
							System.out.println("Invalid option");

						
					}
				}while(quitManage == false);
					}
					
				
					
					else
					{
						System.out.println("No hotels exist currently");
					}
					break;

				case 4:
					// books a room for a guest
					Management.out();
					if(hotelList.size() != 0) {
					int checkIn;
					int checkOut;
					String name;
					String hotelName;
					int room;
					int hotelIndexReserve = -1;
					boolean goods = false;
					boolean available = false;
					System.out.println("|Booking|");
					
					printString("Please Input Guest Name: ");
					buffer = scan.nextLine();
					name = scan.nextLine();
		
					
					do {
					printString("\nWhat hotel will u book into: \n");
					for(int i = 0; i < hotelList.size(); i++) {
						System.out.println("- " + hotelList.get(i).getHotelName());
					}
					
					System.out.print("Input: ");
					//buffer = scan.nextLine();
					hotelName = scan.nextLine();
					for(int i = 0; i < hotelList.size(); i++) {
						if(hotelName.equals(hotelList.get(i).getHotelName())) {
							goods = true;
							hotelIndexReserve = i;
						}
					}
					if(goods == false) {
						System.out.println("Hotel Does not exist");
					}
					
					}while(goods == false);
					
					ln();
					
					
					do {
						goods = false;
					do {
						goods = true;
						printString("Input check in date: ");
						checkIn = scan.nextInt();
						
						if(checkIn > 30 || checkIn < 1) {
							System.out.println("Invalid Date");
							goods = false;
						}
					}while(goods == false);
					
					
					do {
						goods = true;
						printString("Input check out date: ");
						checkOut = scan.nextInt();
						
						if(checkOut > 31 || checkOut < 2) {
							System.out.println("Invalid Date");
							goods = false;
						}
						
					}while(goods == false);
					ln();
					System.out.println("Rooms List: ");
					hotelList.get(hotelIndexReserve).showRoomList();
					ln();
					printString("\nInput room of choice: ");
					room = scan.nextInt();
					ln();

					if(hotelList.get(hotelIndexReserve).bookReservation(name, checkIn, checkOut, room)){
						Management.out();
						printString("Booked Successfully!");
						available = true;
						ln();
					}
					else{
						printString("Booking Failed Successfully!");
						ln();
					}
					}while(available == false);
					}
					else {
						System.out.println("No hotels exist currently");
					}
					break;
				default:
					System.out.println("Error, invalid input.");
			}
		}while(quit == false);
		
	}



    public static void main(String[] args) {
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		hotelManage(hotelList);

    	


		//hotelList.add(new Hotel("Verdes Suites Manila", 24, 4899.00));
		//hotelList.add(new Hotel("Verdes Green Manila", 48));
		//hotelList.add(new Hotel("Verde Grande BGC", 21, 6789.00));
    	//System.out.println();


		// MAKES A HOTEL

		// books a reservation


    }
}
