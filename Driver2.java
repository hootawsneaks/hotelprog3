import java.util.ArrayList;
import java.util.Scanner;

public class Driver{     
    public static void main(String[] args) {
    	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
        Scanner scan = new Scanner(System.in);
    	boolean quit = false;
        String input;
      
        // current  set of inputs
        int inputType = 0;
        
        int currentHotelIndex = -1;
        
        while(quit != true && inputType == 0) {
        	System.out.println("Hotel List: ");
        	if(hotelList.size() == 0) {
        		System.out.println("No hotels currently");
        	}
        	else
        	{
        		for(int i = 0; i < hotelList.size(); i++) {
        			System.out.println("[" + (i+1) + "]" + hotelList.get(i).getHotelName());
        		}
        	}
        	
        	System.out.println("[1] - Add Hotel");
        	System.out.println("[2] - Remove Hotel");
        	System.out.println("[Input Hotel name] - Manage Hotel");
        	System.out.print("\nInput: ");
        	input = scan.next();
        	
        	if(input.equals("1")) {
        		inputType = 1;
        	}
        	else if(input.equals(input)) {
        		inputType = 1;
        	}
        	
        	if(Management.getHotelIndex(input, hotelList) < hotelList.size() && Management.getHotelIndex(input, hotelList) >= 0) {
        		inputType = 2;
        		currentHotelIndex = Management.getHotelIndex(input, hotelList);
        	}
        	
        }
        
        while(inputType == 1) {
        	int count = 0;
        	String name;
        	if(count == 0) {
        		System.out.print("Input name of hotel");
        		String name = scan.next;
        	}
        	
        	System.out.println("Input: ");
        	String name = scan.next;
        	
        	hotelList.add(new Hotel())
        }
        while(inputType == 2) {
        	System.out.println(hotelList.get(currentHotelIndex).getHotelName());
        }
        /*
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
    	
    	System.out.println(hotelList.get(1).removeReservation("Bones"));
    	
    	Management.displayRoom(hotelList.get(1).getRoomsList().get(0));
    	
    	System.out.println(hotelList.get(1).getRoomAvailability(10, ));
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
