import java.util.ArrayList;
import java.util.Scanner;

public class Driver{     
    public static void main(String[] args) {
    	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
        Scanner scan = new Scanner(System.in);
    	
    	hotelList.add(new Hotel("grock", 50, 1299));
    	hotelList.add(new Hotel("tigger", 12, 500));
    	
    	hotelList.get(1).showRoomList();
    	
    	System.out.println();
    	
    	System.out.println(hotelList.get(0).getPrice());
    	
    	System.out.println(hotelList.get(0).changePrice(600));
    	
    	System.out.println(hotelList.get(0).bookReservation("Brutus", 1, 31, 1));
    	
    	System.out.println(hotelList.get(0).changePrice(300));
    	
    	System.out.println(hotelList.get(0).getPrice());
    	
    	System.out.println(hotelList.get(0).getReservationsList().get(0).getDaysStay());
    	
    	System.out.println(hotelList.get(0).getRoomsList().get(0).getDatesBooked());
    	
    	System.out.println(hotelList.get(0).bookReservation("Jacob", 1, 31, 2));
    	
    	
    	/*
    	do
    	{
    		input = scan.next();
    		System.out.print("Create Hotel: );
    		Hotel()
    	}while(!input.equals("0"));
    	*/
    }
}
