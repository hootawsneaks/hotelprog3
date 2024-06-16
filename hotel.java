import java.util.ArrayList;

public class Hotel{
    private String hotelName;
    private int numRooms;
    private float price;
    private ArrayList<Reservation> reservationsList = new ArrayList<Reservation>();
    private ArrayList<Room> roomsList = new ArrayList<Room>();

    public Hotel(String hotelName, int numRooms, float price){
        this.hotelName = hotelName;
        this.numRooms = numRooms;
        this.price = price;
        
        this.createRooms();
    }
    
    public Hotel(String name){
        this.hotelName = hotelName;
        this.numRooms = 1;
        this.price = 1299;
    }
    
    
    public void createRooms(){
        int n = 1;
        for(int i = 0; i < this.numRooms; i++){
        	this.roomsList.add(new Room(""+n, this.price));
            n++;
        }
    }
    
    // pwedeng private?
    public boolean bookReservation(String guestName, int checkIn, int checkOut, int roomNum) {
    	//bawala checkin last day, bawal checkOut first
    	if(checkIn == 31) {
    		return false;
    	}
    	else if(checkOut == 1) {
    		return false;
    	}
    	
    	ArrayList<Integer> bookDates = new ArrayList<Integer>();
    	int n = checkIn;
    	do {
    		bookDates.add(n);
    		n++;
    	}while(n < checkOut);// room is available again on day of checkout so not included
    	
    	//checking availability of rooms
 		for(int d: roomsList.get(roomNum-1).getDatesBooked()) {
 			   for(int b: bookDates) {
 				   if(d == b) {
 					  System.out.println("Tried booking booked room");
 					   return false;
 				   }
 			   }
 	   }
 	   
 	   roomsList.get(roomNum-1).setDatesBooked(checkIn, checkOut);
 	   reservationsList.add(new Reservation(guestName, checkIn, checkOut, roomsList.get(roomNum-1)));
 	   return true;
    }
    
    
    /*
    public boolean bookReservation(int checkIn, int checkOut, String guestName, int roomNum) {
    	this.bookRoom(checkIn, checkOut, roomNum);
    	
    }
    /*
    
    /*
    public boolean changeHotelName(String newName) {
    	if()
    	this.hotelName = newName;
    }
    */
    
    public ArrayList<Room> getRoomsList() {
    	return roomsList;
    }
    
    public ArrayList<Reservation> getReservationsList() {
    	return reservationsList;
    }
    
    public String getHotelName() {
    	return this.hotelName;
    }
    
    public int getNumRooms() {
    	return this.numRooms;
    }
    
    public float getPrice() {
    	return this.price;
    }
    
    
}