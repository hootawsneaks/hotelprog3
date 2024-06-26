import java.util.ArrayList;

public class Room{
    private int roomName;
    private ArrayList<Integer> datesBookedList = new ArrayList<Integer>(); //1-31
    //private boolean status = true;//true means open room
    private float price;

    /**
     * Class constructor for a room. Has 2 variables: The room name and the price of the room.
     * @param roomName is the name of the room
     * @param price is the price of the room
     */
    public Room(int roomName, float price){
        this.roomName = roomName;
        this.price = price;
    }
    
    /**
     * Given a span of days, makes these days considered booked by putting 
     * it in a list called datesBookedList
     * @param checkIn is the start of the timespan
     * @param checkOut is the end of the timespan
     */
    public void setDatesBooked(int checkIn, int checkOut) {
    	int n = checkIn;
    	do {
    		this.datesBookedList.add(n);
    		n++;
    	}while(n < checkOut);
    	
    	
    	 for (int i = 0; i < this.datesBookedList.size()-1; i++)
         {
             // Find the minimum element in unsorted array
             int min_idx = i;
             for (int j = i+1; j < this.datesBookedList.size(); j++) {
                 if (this.datesBookedList.get(j) < this.datesBookedList.get(min_idx))
                     min_idx = j;
             }
             
             // Swap the found minimum element with the first
             // element
             int temp = this.datesBookedList.get(min_idx);
             this.datesBookedList.set(min_idx, this.datesBookedList.get(i));
             this.datesBookedList.set(i, temp);
         }
         
     }
    	 /*
        for (int i = 1; i < this.datesBookedList.size(); i++) {
              int key = this.datesBookedList.get(i);
              int j = i - 1;

              
              while (j > -1 && (this.datesBookedList.get(j) > key)) {
                  this.datesBookedList.set(j+1, this.datesBookedList.get(j));
                  j = j - 1;
              }
              this.datesBookedList.set(j, key);
          }
        */
      
    /**
     * Changes a room's name
     * @param roomName is a String that you want the room's name to be set to.
     */
    public void changeRoomName(int roomName) {
    	this.roomName = roomName;
    }
    
    /**
     * Changes the hotel's pricing for all rooms.
     * @param price is a float that represents the price of a given room.
     */
    public void changePrice(float price) {
    	this.price = price;
    }
    /*
    public void changeStatus() {
    	this.status = !this.status;
    }
    
    public boolean getStatus() {
    	return this.status;
    }
    */

   /**
    * Gets a room's name
    * @return a String that represents the room name
    */
    public int getRoomName(){
        return this.roomName;
    }

    /**
    * Gets all the dates which are booked
    * @return a list of integers
    */
    public ArrayList<Integer> getDatesBooked(){
    	
        return this.datesBookedList;
    }
    
    /**
     * Get the price of the room
     * @return an integer the represents the price
     */
    public float getPrice() {
    	return this.price;
    }
    /*
    public int getIndex() {
    	
    }\
    */
}


//pwedeng static?