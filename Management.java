import java.util.ArrayList;

public class Management {
	//print reservation details
	private static ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
	
	public static void addHotel(Hotel hotel) {
		hotelsList.add(hotel);
	}
	
	public static void removeHotel(Hotel hotel) {
		hotelsList.add(hotel);
	}
	
	public static void displayReservation(Reservation reservation) {
		System.out.println("Guest name: " + reservation.getGuestName() + "\n");
		System.out.println("Dates Booked:\n" +  "Check-in: " + reservation.getCheckIn() + "  Check-out: " + reservation.getCheckOut());
		System.out.println("Overnight dates: " + reservation.getDaysStay() + "\n");
		System.out.println("Cost per night: " + reservation.getRoomInfo().getPrice());
		System.out.println("Total cost of booking: " + reservation.getTotalPay());
	}
	
	public static void displayRoom(Room room) {
		System.out.println("Room name: " + room.getRoomName() + "\n");
		System.out.println("Cost per night: " + room.getPrice() + "\n");
		System.out.println("Overnight Dates Booked:");
		System.out.println(room.getDatesBooked());
	}
	
	 public static int getHotelIndex(String name, ArrayList<Hotel> hotels) {
	    	int index = -1;
	    	for(int i = 0; i < hotels.size(); i++) {
	    		if(hotels.get(i).getHotelName().equals(name)) {
	    			index = i;
	    		}
	    	}
	    	return index;
	    }
	 
	 public static void out() {
		
			    System.out.print("\033[H\033[2J");  
			    System.out.flush();  
			
	 }
	///print hotel info
	
	
}
