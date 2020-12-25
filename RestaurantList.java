// --== CS400 File Header Information ==--
// Name: Nikolas Brendel
// Email: brendel2@wisc.edu
// Team: AF
// Role: Front End Developer 1
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.io.File;
import java.util.List;

public class RestaurantList {

    public static void main(String[] args){
	try{
	    File file = new File("StateStreetRestaurants.csv");
	    List<String[]> values = DataWrangler.readAll(file);
	    int i = 0;
	    System.out.println("<table>\n<tr>");
	    for(String[] value: values) {
		if(i == 0) {i++;continue;}
		if(i%4 == 1){
		    System.out.print("</tr>\n<tr>");
		}
		System.out.print("<td>" + value[0] + ":</td><td>" + value[1] + "</td>");
		i++;
	    }
	    System.out.println("</tr>\n</table>");
	} catch(Exception e) {
	}
    }
}
