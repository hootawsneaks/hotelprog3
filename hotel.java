import java.util.ArrayList;

public class Hotel{
	//ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    private String hotelName;
    private int numRooms;
    private float price = 1299f;
    private ArrayList<Reservation> reservationsList = new ArrayList<Reservation>();
    private ArrayList<Room> roomsList = new ArrayList<Room>();

    
    public Hotel(String hotelName, int numRooms, float price){
        this.hotelName = hotelName;
        this.numRooms = numRooms;
        this.price = price;
        
        this.createRooms();
    }
    /*
    public Hotel(String hotelName){
        this.hotelName = hotelName;
        this.numRooms = 1;
        this.price = 1299;
        
        this.createRooms();
    }
    */
    // for initialzing the rooms when a hotel is created
    public void createRooms(){
        int n = 1;
        for(int i = 0; i < this.numRooms; i++){
        	this.roomsList.add(new Room(n, this.price));
            n++;
        }
    }
    
    //books a reservation makes all its info and books the dates for the chosen room
    public boolean bookReservation(String guestName, int checkIn, int checkOut, int roomNum) {
    	//bawal checkin last day, bawal checkOut first
    	if(!(checkIn >= 1 && checkIn < 31)) {
    		return false;
    	}
    	if(!(checkOut > 1 && checkOut <= 31)){
    		return false;
    	}
    	if(checkIn == checkOut) {
    		return false;
    	}
    	
    	ArrayList<Integer> bookDates = new ArrayList<Integer>();
    	int n = checkIn;
    	do {
    		bookDates.add(n);
    		n++;
    	}while(n < checkOut);// room is available again on day of checkout so not included
    	
    	/*
    	int roomIndex = -1;
    	for(int i = 0; i < this.roomsList.size(); i++) {
    		if(this.roomsList.get(i).getRoomName() == roomNum) {
    			roomIndex = i;
    		}
    	}
    	
    	if(roomIndex == -1) {
    		System.out.println("Error booking room, room does not exist");
    		return false;//room does not exist
    	}
    	*/
    	
    	int roomIndex = this.getRoomIndex(roomNum);
    	
    	if(roomIndex == -1) {
    		System.out.println("Error booking room, room does not exist");
    		return false;//room does not exist
    	}
    	
    	//checking availability of rooms
 		for(int d: roomsList.get(roomIndex).getDatesBooked()) {
 			   for(int b: bookDates) {
 				   if(d == b) {
 					  System.out.println("Tried booking booked room");
 					   return false;
 				   }
 			   }
 	   }
 	   
 	   roomsList.get(roomIndex).setDatesBooked(checkIn, checkOut);
 	   reservationsList.add(new Reservation(guestName, checkIn, checkOut, roomsList.get(roomIndex)));
 	   return true;
    }
    
    //with guest name
    // removes reservation, adjusts dates boooked of room
    public boolean removeReservation(String guestName) {
    	//int guestIndex;
    	//String roomName;
    	int reservationDay = 0;
    	
    	int k = 0;
    	
    	for(int i = 0; i < this.reservationsList.size(); i++) {
    		if(this.reservationsList.get(i).getGuestName().equals(guestName)) {
    			//roomName = this.reservationsList.get(i).getRoomInfo().getRoomName();
    			for(int j = 0; j < this.roomsList.size(); j++) {
    				if(this.reservationsList.get(i).getRoomInfo().getRoomName() == this.roomsList.get(j).getRoomName()) {
    					while( k < this.roomsList.get(j).getDatesBooked().size()) {
    						
    						if(this.roomsList.get(j).getDatesBooked().get(k) == this.reservationsList.get(i).getDaysStay().get(reservationDay) ) {
    							this.roomsList.get(j).getDatesBooked().remove(k);
    							if(reservationDay < this.reservationsList.get(i).getDaysStay().size() - 1) {
    								reservationDay++;
    							}
    						}
    						else {
    							k++;
    						}
    						
    					}
    				}
    			}
    			
    			this.reservationsList.remove(i);
    			return true;
    		}
    
    	}
    	return false;	
    }
    
    //specific dates and room free up
    public void removeReservation(int roomNum, int checkIn, int checkOut) {
    	// this dont make sense pala ata
    }
    /*
    public boolean bookReservation(int checkIn, int checkOut, String guestName, int roomNum) {
    	this.bookRoom(checkIn, checkOut, roomNum);
    	
    }
    */
    
    //numRooms is num of rooms to add
    public boolean addRoom(int numRooms) {
    	if(this.roomsList.size() + numRooms > 50 || numRooms < 1) {
    		return false;
    	}
    	
    	int roomName = this.roomsList.getLast().getRoomName() + 1;
    	for(int i = 0; i < numRooms; i++) {
    		this.roomsList.add(new Room(roomName, this.getPrice()));
    		roomName++;
    	}
    	return true;
    }
    
    //removes a room if that room no reservation
    public boolean removeRoom(int roomNum) {
    	
    	int roomIndex = this.getRoomIndex(roomNum);
    	if(roomIndex == -1) {
    		System.out.println("Error cannot remove room that does not exist");
    		return false;
    	}
    	
    	if(this.roomsList.get(roomIndex).getDatesBooked().size() != 0) {
    		return false;
    	}
    	else
    	{
    		this.roomsList.remove(roomIndex);
    		//rearrange naming scheme
    		/*
    		int n = 1;
    		for(int i = 0; i < this.roomsList.size(); i++) {
    			this.roomsList.get(i).changeRoomName("" + n);
    			n++;
    		}
    		*/
    		return true;
    	}
    }
   
    //changes hotel name if no other same name
    public boolean changeHotelName(String newName, ArrayList<Hotel> hotels) {
    	for(int i = 0; i < hotels.size(); i++) {
    		if(hotels.get(i).getHotelName().equals(newName)) {
    			return false;
    		}
    	}
    	
    	this.hotelName = newName;
    	return true;
    }
    
    //list of rooms in existence
    public void showRoomList() {
    	int n = 1;
    	for(int i = 0; i < this.roomsList.size(); i++) {
    		System.out.format("%5s" , this.roomsList.get(i).getRoomName());
    		n++;
    		
    		if(n % 6 == 0) {
    			System.out.print("  ");
    			System.out.println();
    			n++;
    		}
    		
    	}

    	
    }
    
    //gives index of a room given its roomNum
    public int getRoomIndex(int roomNum) {
    	int roomIndex = -1;
    	for(int i = 0; i < this.roomsList.size(); i++) {
    		if(this.roomsList.get(i).getRoomName() == roomNum) {
    			roomIndex = i;
    		}
    	}
    	
    	return roomIndex;
    }
    
    //gives index of a reservation give the guest name
    public int getReservIndex(String guest) {
    	int index = -1;
    	for(int i = 0; i < this.reservationsList.size(); i++) {
    		if(this.reservationsList.get(i).getGuestName().equals(guest)) {
    			index = i;
    		}
    	}
    	
    	return index;
    }
    
    //returns list of rooms goods on a single date
    public ArrayList<Integer> getRoomAvailability(int date){
    	ArrayList<Integer> rooms = new ArrayList<Integer>();//rooms available on this date
    	boolean present;
    	for(int i = 0; i < this.roomsList.size(); i++) {
    		present = false;
    		for(int j = 0; j < this.roomsList.get(i).getDatesBooked().size(); j++) {
    			if(this.roomsList.get(i).getDatesBooked().get(j) == date) {
    				present = true;
    			}
    		}
    		if(present == false) {
    			rooms.add(this.roomsList.get(i).getRoomName());
    		}
    		
    	}
    	
    	return rooms;
    }
     
    //returns  list of rooms good from dates checkin to checkut - 1
    public ArrayList<Integer> getRoomAvailability(int checkIn, int checkOut){
    	ArrayList<Integer> rooms = new ArrayList<Integer>();//rooms available on this date
    	int count = 0;
    	int dateIndex;
    	ArrayList<Integer> bookDates = new ArrayList<Integer>();
    	int n = checkIn;
    	do {
    		bookDates.add(n);
    		n++;
    	}while(n < checkOut);// room is available again on day of checkout so not included
    	
    	for(int i = 0; i < this.roomsList.size(); i++) {
    		count = 0;
    		dateIndex = 0;
    		for(int j = 0; j < this.roomsList.get(i).getDatesBooked().size(); j++) {
    			if(this.roomsList.get(i).getDatesBooked().get(j) == bookDates.get(dateIndex)) {
    				count++;
    				dateIndex++;
    			}
    		}
    		if(count == bookDates.size()) {
    			rooms.add(this.roomsList.get(i).getRoomName());
    		}
    	}
    	
    	return rooms;
    }
    
    //change room if no reservations across the whole hotel
    public boolean changePrice(float price) {
    	if(this.reservationsList.size() != 0 ) {
    		return false;
    	}
    	if(price < 100) {
    		return false;
    	}
    	this.price = price;
    	for(int i = 0; i < roomsList.size(); i++) {
    		roomsList.get(i).changePrice(price);
    	}
    	
    	return true;
    }
    
    public float getTotalEarnings() {
    	float sum = 0;
    	for(int  i = 0; i < this.reservationsList.size(); i++) {
    		sum = sum + this.reservationsList.get(i).getTotalPay();
    	}
    	
    	return sum;
    }
    
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