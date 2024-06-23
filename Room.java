import java.util.ArrayList;

public class Room{
    private int roomName;
    private ArrayList<Integer> datesBookedList = new ArrayList<Integer>(); //1-31
    //private boolean status = true;//true means open room
    private float price;

    public Room(int roomName, float price){
        this.roomName = roomName;
        this.price = price;
    }
    
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
      
    
    public void changeRoomName(int roomName) {
    	this.roomName = roomName;
    }
    
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
    public int getRoomName(){
        return this.roomName;
    }

    public ArrayList<Integer> getDatesBooked(){
    	
        return this.datesBookedList;
    }
    
    public float getPrice() {
    	return this.price;
    }
    /*
    public int getIndex() {
    	
    }\
    */
}


//pwedeng static?