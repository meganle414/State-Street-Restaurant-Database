// --== CS400 File Header Information ==--
// Name: Megan Le
// Email: mle25@wisc.edu
// Team: AF
// Role: Back End Developer 
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;
import java.util.List;

public class Connector {

    private static BackEnd table = DataWrangler.newHashTable;

    public static void main(String[] args) {
    	DataWrangler.main(null);
	    String address = "";
	    try {
	     int r = Integer.parseInt(args[0]);
	      try {
		      List<String[]> data = DataWrangler.readAll(null);
		      address = data.get(r)[0];
	      } catch(Exception e){}
	    } catch(NumberFormatException e) {
	      String[] values = args[0].split("%20");
	      for(String value: values) {
		      address = address + value + " ";
	      }
	      address = address.trim();
	    }
	    try {
	      String[] details = table.searchRestaurant(address);
	      System.out.println("<table>");
	      System.out.println("<tr><td>Restaurant Name:</td><td>" + details[1] + "</tr>");
	      System.out.println("<tr><td>Price Rating ($-$$$):</td><td>" + details[2] + "</tr>");
	      System.out.println("<tr><td>Genre:</td><td>" + details[3] + "</tr>");
	      System.out.println("<tr><td>Star Rating (1-5)</td><td>" + details[4] + "</tr>");
	      System.out.println("</table>");
	    } catch(NoSuchElementException e) {
	      System.out.println("Address not found");
	    }
    }
}
