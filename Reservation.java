import java.util.ArrayList;

public class Reservation{
    private String guestName;
    private int checkIn;
    private int checkOut;
    private Room room;
    
    public Reservation(String guestName, int checkIn, int checkOut, Room room) {
    	this.guestName = guestName;
    	this.checkIn = checkIn;
    	this.checkOut = checkOut;
    	this.room = room;
    }
    
    public ArrayList<Integer> getDaysStay(){
    	ArrayList<Integer> booked= new ArrayList<Integer>();
    	int n = this.checkIn;
    	do {
    		booked.add(n);
    		n++;
    	}while(n < this.checkOut);
    	return booked;
    }
    
    public float getTotalPay() {
    	return (this.checkOut - this.checkIn) * this.room.getPrice();
    }
    
    public String getGuestName() {
    	return this.guestName;
    }
    
    public int getCheckIn() {
    	return this.checkIn;
    }
    
    public int getCheckOut() {
    	return this.checkOut;
    }
    
    public Room getRoomInfo() {
    	return this.room;
    }
    
   
    /*
    public float getTotalPrice(int checkIn, int checkOut, int roomPrice){
        
    }
    */
}

