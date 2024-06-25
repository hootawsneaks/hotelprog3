import java.util.ArrayList;

public class Reservation{
    private String guestName;
    private int checkIn;
    private int checkOut;
    private Room room;
    
    /**
	 * Class constructor for a reservation; the guest's name, check in date, 
     * check out date, and room number need to be indicated.
	 */
    public Reservation(String guestName, int checkIn, int checkOut, Room room) {
    	this.guestName = guestName;
    	this.checkIn = checkIn;
    	this.checkOut = checkOut;
    	this.room = room;
    }
    
    /**
	 * Returns the days in which reservation will last.
     * @return a list of days (like in a calendar) where a reservation will last.
	 */
    public ArrayList<Integer> getDaysStay(){
    	ArrayList<Integer> booked= new ArrayList<Integer>();
    	int n = this.checkIn;
    	do {
    		booked.add(n);
    		n++;
    	}while(n < this.checkOut);
    	return booked;
    }
    
    /**
	 * Get the total pay that the reservation will cost.
     * @return the total cost of the reservation.
	 */
    public float getTotalPay() {
    	return (this.checkOut - this.checkIn) * this.room.getPrice();
    }
    
    /**
	 * Sets a room's info, given another room's details.
	 * @param room is an object that stores all the details of a room.
	 */
    public void setRoomInfo(Room room) {
    	this.room = room;
    }
    
    /**
	 * Gets the name of the guest that did the reservation.
     * @return a string; the guest's name that reserved.
	 */
    public String getGuestName() {
    	return this.guestName;
    }
    
    /**
	 * Get the check in date of a given reservation.
     * @return an integer, the check in date of a reservation.
	 */
    public int getCheckIn() {
    	return this.checkIn;
    }
    
    /**
	 * Get the check out date of a given reservation.
     * @return an integer, the check out date of a reservation.
	 */
    public int getCheckOut() {
    	return this.checkOut;
    }
    
    /**
	 * Returns the information of a room, via the room object itself.
     * @return the room object where the reservation was made.
	 */
    public Room getRoomInfo() {
    	return this.room;
    }
    
   
    /*
    public float getTotalPrice(int checkIn, int checkOut, int roomPrice){
        
    }
    */
}

