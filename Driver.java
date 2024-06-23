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
			printString("Select Choice: ");
			ln();
			printString("1: Add Hotel");
			ln();
			printString("2: View Hotel");
			ln();
			printString("3: Manage Hotel");
			ln();
			printString("4: Simulate Booking");
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
						} while(intInput<1);

						do{
							System.out.println("");
							System.out.print("Input pricing per night (input 0 for default): ");
							floatInput = scan.nextFloat();
							if(floatInput == 0)
								floatInput = 1299.00f;
						}while(floatInput<0);

						if(hotelList.add(new Hotel(stringInput, intInput, floatInput))) // arrayList will return 1 if successfully changed.
							System.out.println("Hotel added!");
						System.out.println("");

						System.out.println("--------------------");

					}while(!stringInput.equals("EXIT"));
					break;

				case 2:
					

					break;

				case 3:
					// manage hotel : save for last
					break;

				case 4:
					// books a room for a guest
					int checkIn;
					int checkOut;
					String name;
					int room;
					int hotelIndex;

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
