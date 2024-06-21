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
    
    public void createRooms(){
        int n = 1;
        for(int i = 0; i < this.numRooms; i++){
        	this.roomsList.add(new Room(""+n, this.price));
            n++;
        }
    }
    
    // pwedeng private?
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
    
    //with guest name
    public boolean removeReservation(String guestName) {
    	//int guestIndex;
    	//String roomName;
    	int reservationDay = 0;
    	
    	int k = 0;
    	
    	for(int i = 0; i < this.reservationsList.size(); i++) {
    		if(this.reservationsList.get(i).getGuestName().equals(guestName)) {
    			//roomName = this.reservationsList.get(i).getRoomInfo().getRoomName();
    			for(int j = 0; j < this.roomsList.size(); j++) {
    				if(this.reservationsList.get(i).getRoomInfo().getRoomName().equals(this.roomsList.get(j).getRoomName())) {
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
    
    public boolean addRoom(int numRooms) {
    	int name = this.roomsList.getLast().getRoomName().charAt(0) - 48;
    }
    
    public boolean removeRoom(int roomNum) {
    	if(this.roomsList.get(roomNum-1).getDatesBooked().size() != 0) {
    		return false;
    	}
    	else
    	{
    		this.roomsList.remove(roomNum-1);
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
   
    public boolean changeHotelName(String newName, ArrayList<Hotel> hotels) {
    	for(int i = 0; i < hotels.size(); i++) {
    		if(hotels.get(i).getHotelName().equals(newName)) {
    			return false;
    		}
    	}
    	
    	this.hotelName = newName;
    	return true;
    }
    
    public int getHotelIndex(String name, ArrayList<Hotel> hotels) {
    	int index = -1;
    	for(int i = 0; i < hotels.size(); i++) {
    		if(hotels.get(i).getHotelName().equals(name)) {
    			index = i;
    		}
    	}
    	return index;
    }
    
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
    
    public boolean changePrice(float price) {
    	if(this.reservationsList.size() != 0 ) {
    		return false;
    	}
    	if(price < 100) {
    		return false;
    	}
    	this.price = price;
    	return true;
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