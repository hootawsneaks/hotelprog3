import java.util.ArrayList;
import java.util.Scanner;

public class Driver{     
    public static void main(String[] args) {
    	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
        Scanner scan = new Scanner(System.in);
    	String input;
    	
    	hotelList.add(new Hotel("grock", 50, 1299));
    	
    	System.out.print(hotelList.get(0).getRoomsList().get(0).getRoomName() + " ");
    	System.out.println(hotelList.get(0).getRoomsList().get(0).getDatesBooked());
    	System.out.print(hotelList.get(0).getRoomsList().get(49).getRoomName()+ " ");
    	System.out.println(hotelList.get(0).getRoomsList().get(49).getDatesBooked());
    	
    	System.out.println();
    	
    	
    	hotelList.get(0).bookReservation("Emilio", 1, 31, 1);
    	hotelList.get(0).bookReservation("Jabba", 10, 21, 50);
    	
    	System.out.print(hotelList.get(0).getRoomsList().get(0).getRoomName() + " ");
    	System.out.println(hotelList.get(0).getRoomsList().get(0).getDatesBooked());
    	System.out.print(hotelList.get(0).getRoomsList().get(49).getRoomName()+ " ");
    	System.out.println(hotelList.get(0).getRoomsList().get(49).getDatesBooked());
    	
    	System.out.println("\nReservations");
    	
    	System.out.print(hotelList.get(0).getRoomsList().get(0).getRoomName() + " ");
    	System.out.println(hotelList.get(0).getReservationsList().get(0).getDaysStay());
    	System.out.print(hotelList.get(0).getRoomsList().get(49).getRoomName()+ " ");
    	System.out.println(hotelList.get(0).getReservationsList().get(1).getDaysStay());
    	
    	hotelList.get(0).bookReservation("bacon", 5, 21, 1);
    	hotelList.get(0).bookReservation("Potato", 21, 31, 50);
    	
    	System.out.println();
    	
    	System.out.print(hotelList.get(0).getRoomsList().get(0).getRoomName() + " ");
    	System.out.println(hotelList.get(0).getRoomsList().get(0).getDatesBooked());
    	System.out.print(hotelList.get(0).getRoomsList().get(49).getRoomName()+ " ");
    	System.out.println(hotelList.get(0).getRoomsList().get(49).getDatesBooked());
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
