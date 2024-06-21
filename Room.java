import java.util.ArrayList;

public class Room{
    private String roomName;
    private ArrayList<Integer> datesBookedList = new ArrayList<Integer>(); //1-31
    private boolean status = true;//true means open room
    private float price;

    public Room(String roomName, float price){
        this.roomName = roomName;
        this.price = price;
    }
    
    public void setDatesBooked(int checkIn, int checkOut) {
    	int n = checkIn;
    	do {
    		datesBookedList.add(n);
    		n++;
    	}while(n < checkOut);
    	
    	
    }
    
    public void changeRoomName(String roomName) {
    	this.roomName = roomName;
    }
    
    public void changeStatus() {
    	this.status = !this.status;
    }
    
    public boolean getStatus() {
    	return this.status;
    }
    
    public String getRoomName(){
        return this.roomName;
    }

    public ArrayList<Integer> getDatesBooked(){
        return this.datesBookedList;
    }
    
    public float getPrice() {
    	return this.price;
    }
}

//pwedeng static?