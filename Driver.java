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
		do{
			printString("------------------------------");
			ln();
			printString("Select Choice: ");
			ln();
			printString("1: Add Hotel");
			ln();
			printString("2: View Hotel");
			ln();
			printString("3: Manage Hotel");
			ln();
			printString("4: Simulate Booking");
			ln();
			choiceInput = scan.nextInt();
			switch (choiceInput){
				case 0:
					break;
				case 1:
					// adds a hotel
					String stringInput;
					do
					{
						int intInput;
						float floatInput;
						System.out.print("Create Hotel: ");
						stringInput = scan.next();
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

						if(hotelList.add(new Hotel(stringInput, intInput, floatInput))) // arrayList will return 1 if successfully changed.
							System.out.println("Hotel added!");
						System.out.println("");

						System.out.println("--------------------");

					}while(!stringInput.equals("EXIT"));
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
						hotelSearch = scan.next();
						hotelIndex = Management.getHotelIndex(hotelSearch, hotelList);
					}while(hotelIndex == -1);


					//Total number of rooms

					printString("Would you like to view its high level (1) or low level info (2)? input 0 to exit: ");
					ln();
					levelChoice = scan.nextInt();

					switch(levelChoice){

							case 0:
								break;

							case 1:
							// high level

							printString("Name of hotel: ");
							System.out.print(hotelList.get(hotelIndex).getHotelName());
							ln();
							printString("Total number of rooms: ");
							System.out.print(hotelList.get(hotelIndex).getNumRooms());
							ln();
							printString("Estimated earnings for the month: ");
							System.out.print(hotelList.get(hotelIndex).getTotalEarnings());
							ln();

								break; // case break

							case 2:
								// low level
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

								lowLevelChoice = scan.nextInt();
								switch(lowLevelChoice){
									case 1:
										int date;
										printString("Input a valid specific date: ");
										date = scan.nextInt();
										System.out.print("Total number of available rooms for " + date + ": ");
										System.out.print(hotelList.get(hotelIndex).getRoomAvailability(date));
										break;
									case 2:
										int roomInput;
										int roomIndex;

										hotelList.get(hotelIndex).showRoomList();
										ln();

										do{
											printString("Input a valid room greater than zero: ");
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
										
										Management.displayRoom(hotelList.get(hotelIndex).getRoomsList().get(roomIndex));

										break;
									case 3:
										String reservationInput;
										int reservationIndex;

										printString("Input a guest's name: ");
										reservationInput = scan.next();
										reservationIndex = hotelList.get(hotelIndex).getReservIndex(reservationInput);
										Management.displayReservation(hotelList.get(hotelIndex).getReservationsList().get(reservationIndex));
										break;
									default:
								}

								break; // case break


							default:
								printString("Invalid Input. please try again.");
					}




					break; // case break

				case 3:
					// manage hotel : save for last

					break;
				case 4:
					// books a room for a guest
					int checkIn;
					int checkOut;
					String name;
					int room;

					printString("Please input the name: ");
					name = scan.next();
					ln();
					printString("Input hotel index: ");
					hotelIndex = scan.nextInt();
					ln();
					printString("Input check in date: ");
					checkIn = scan.nextInt();
					ln();
					printString("Input check out date: ");
					checkOut = scan.nextInt();
					ln();
					printString("Input room number: ");
					room = scan.nextInt();
					ln();

					if(hotelList.get(hotelIndex).bookReservation(name, checkIn, checkOut, room)){
						printString("Booked Successfully!");
						ln();
					}
					else{
						printString("Booking Failed Successfully!");
						ln();
					}

					break;
				default:
					System.out.println("Error, not in choices.");
			}
		}while(choiceInput!=0);
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
