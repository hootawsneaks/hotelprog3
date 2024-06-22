import java.util.ArrayList;
import java.util.Scanner;

public class Driver{     
    public static void main(String[] args) {
    	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
        Scanner scan = new Scanner(System.in);
    	
    	hotelList.add(new Hotel("grock", 50, 1299));
    	hotelList.add(new Hotel("tigger", 5, 500));
    	
    	hotelList.get(1).bookReservation("Billy", 10, 15, 1);
    	
    	hotelList.get(1).bookReservation("Bones", 22, 31, 1);
    	
    	Management.displayReservation(hotelList.get(1).getReservationsList().get(0));
    	
    	System.out.println();
    	
    	Management.displayRoom(hotelList.get(1).getRoomsList().get(0));
    	
    	
    	hotelList.get(1).bookReservation("Jimmy", 20, 21, 1);
    	
    	Management.displayReservation(hotelList.get(1).getReservationsList().get(1));
    	
    	Management.displayRoom(hotelList.get(1).getRoomsList().get(0));
    	
    	System.out.println(hotelList.get(1).getRoomAvailability(10));
    	
    	System.out.println(hotelList.get(1).getRoomsList().size());
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
