import java.util.ArrayList;

public class Room{
    private String roomName;
    private ArrayList<Integer> datesBookedList = new ArrayList<Integer>(); //1-31
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