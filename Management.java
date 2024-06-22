
public class Management {
	//print reservation details
	
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
	
	///print hotel info
	
	
}
