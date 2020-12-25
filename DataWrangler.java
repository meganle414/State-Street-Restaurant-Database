// --== CS400 File Header Information ==--
// Name: Hunter Goff
// Email: hfgoff@wisc.edu
// Team: AF
// Role: Data Wrangler
// TA: Sophie 
// Lecturer: Floiren Heimrel
// Notes to Grader: n/a
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList; 
import java.util.Scanner;

/**
 * This class loads the data from 'StateStreetRestaurants.csv' into a hash table. 
 * The key is the name.
 * The value is a list of strings (Name, Price Rating($-$$$), Genre, Star Rating (1-5))
 * 
 * @author Hunter Goff
 *
 */

public class DataWrangler {
    
  static BackEnd newHashTable = new BackEnd(); 
  
  public static String input = "Address,Name,Price Rating ($-$$$),Genre,Star Rating (1-5)\n" + 
      "309 N Henry St,The Globe,$$,Chinese,4.9\n" + 
      "107 State St,107 State,$$$,Pub,4.6\n" + 
      "318 State St,Himal Chuli Restaurant,$,Nepalese,4.6\n" + 
      "625 State St,Mediterranean Cafe,$,Mediterranean,4.7\n" + 
      "100 State St,Ian's Pizza on State,$,Pizza,4.6\n" + 
      "563 State St,Conrad's Grill,$,Wraps,4.7\n" + 
      "305 State St,Tutto Pasta State St,$$,Italian ,4.1\n" + 
      "571 State St,MOOYAH Burgers Fries & Shakes,$$,Burgers,4.5\n" + 
      "320 State St,Taiwan Little Eats,$,Taiwanese,4.5\n" + 
      "316 State St,Parthenon Gyros,$,Greek,4.5\n" + 
      "555 State St,Naf Naf Grill,$,Middle Eastern,4.4\n" + 
      "101 State St,Teddywedgers,$,Sandwhich,4.6\n" + 
      "301 W Johnson St,Short Stack Eatery,$$,Breakfast,4.6\n" + 
      "227 State St,Fresco,$$$,New American,4.4\n" + 
      "414 W Gilman St,Paul's Pel'meni,$,Russian,4.7\n" + 
      "665 State st,Forage Kitchen,$$,Salad,4.5\n" + 
      "419 State St,Duabi Mediterranean Restaurant and Bar,$$$,Mediterranean,4.4\n" + 
      "617 State St,Rising Sons Thai Restaurant,$,Thai,4.2\n" + 
      "638 State St,Sunroom Cafe,$$,Breakfast,4.3\n" + 
      "18 N Carroll St,Graft,$$,Fine Dining,4.7\n" + 
      "449 State St,Yume Sushi,$$,Japenese,4\n" + 
      "615 State St,Poke Plus Madison,$,Poke,4.1\n" + 
      "658 State St,Chipolte Mexican Grill,$,Mexican,4.2\n" + 
      "334 State St,Ruyi Hand Pulled Noddle,$$,Japenese,4.6\n" + 
      "505 State St,Chen's Dumpling House,$$,Chinese,4.4\n" + 
      "583 State St,Collectivo Coffee - State St,$,Coffee,4.5\n" + 
      "515 State St,Taste of Sichuan,$$,Chinese,4\n" + 
      "449 State St,Mirch Masala,$$,Indian,4.1\n" + 
      "517 State St,Five Guys,$$,Burgers,4.3\n" + 
      "226 State St,Nick's Restaurant and Lounge,$,Greek,3.9\n" + 
      "122 W Mifflin St,Cento,$$$,Italian ,4.5\n" + 
      "548 State St,QDOBA Mexican Eats,$,Mexican,3.9\n" + 
      "603 State St,State Street Brats,$,Bar,4.1\n" + 
      "206 State St,The Icon Restaurant,$$,Spanish,3.7\n" + 
      "341 State St,Casa de Lara,$$,Mexican,4.2\n" + 
      "232 State St,Noodles and Company,$,Noodles,3.8\n" + 
      "534 State St,Taco Bell Cantina,$,Mexican,5\n" + 
      "564 State St,Potbelly Sandwich Shop,$,Sandwhich,4.1\n" + 
      "425 State St,Hawk's Bar and Grill,$,Grill,4.1\n" + 
      "502 State St,Chili King,$$,Chinese,3.8\n" + 
      "636 State St,City Bar,$,Bar,4.3\n";
    
  public static void main(String args[]) {
    try {
      init(); 
    } catch (Exception e) {
      System.out.println("file not found"); 
    }
    
    //System.out.println(newHashTable.size()); 
    //System.out.println(newHashTable.searchRestaurant("505 State St")); 
    //System.out.println(newHashTable.searchRestaurant("658 State St")); 
    
    //System.out.println(newHashTable.containsKey("505 State St")); 
    
  }
    
  /**
   * This will initialize the data into a hash table from the .csv file on your local machine
   * 
   * @throws FileNotFoundException when the file is not found at the given pathway
   */
  public static void init() throws FileNotFoundException {
    
    try {
      File file = new File("StateStreetRestaurants.csv"); 
      
      // data stored in list. Each spot in the list points to an array that actually 
      // holds the data. The key (address) is in the first index of the second array. 
      List<String[]> data = readAll(file); 
        
       
       
      //String[] valuePair = new String[]{}; 
      
      
      for (int i = 0; i < data.size(); i++) {
        String[] actualData;
        String[] headers = new String[100];
        // if i < 1, then we are dealing with the table headers
        if (i < 1) {
         actualData = data.get(i); 
         for (int j = 0; j < actualData.length; j++) {
           headers[j] = actualData[j]; 
           //System.out.println(headers[j]); 
         }
        }
        else {
          actualData = data.get(i); 
          String[] restOfData = new String[200];
          String address = ""; 
          for (int j = 0; j < actualData.length; j++) {
            
            if (j == 0) {
              //this means that j is pointing to the address, which is the hashtable key
              address = actualData[j]; 
              //System.out.println(address); 
            } else {
              // j is pointing to name, price rating, etc
              // add it to a string array, which has an index one behind. This will be the hashtable
              // values
              //System.out.println(actualData[j]);
              restOfData[j] = actualData[j]; 
              //System.out.println(restOfData[j]); 
            }
            
          }
          newHashTable.addRestaurant(address, restOfData);
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Change File name in Data Wrangler Class to your local realpath"); 
    }
  }
  
  /**
   * This method reads the csv file and adds it to a list of string arrays. 
   * 
   * @throws Exception when the file is not there
   */
  public static List<String[]> readAll(File csvFile) throws Exception {
    List<String[]> values = new ArrayList<>(); // values stored in string array 
    
    try (Scanner scan = new Scanner(input)) {
        while (scan.hasNextLine()) {
          values.add(scan.nextLine().split(",")); 
        } 
    }
    return values;     
  }
}
