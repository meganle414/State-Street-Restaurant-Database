// --== CS400 File Header Information ==--
// Name: Megan Le
// Email: mle25@wisc.edu
// Team: AF
// Role: Back End Developer 
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;

/**
 * This class makes use of the DataWrangler.java class, and the List.java
 * interface to create a list of the restaurants on State Street
 * 
 * @author Megan Le
 *
 */
public class BackEnd implements List {
    private HashTable<String, String[]> hashTable;

    /**
     * Creates a new hashTable to store the restaurant list in with default size of 10.
     */
    public BackEnd() {
        this(10);

    }

    /**
     * Creates a new hashTable to store the restaurants in.
     * 
     * @param size the intended size of the restaurant list
     */
    public BackEnd(int size) {
        hashTable = new HashTable<String, String[]>(size);

    }

    /**
     * Adds a restaurant to the restaurant list
     * 
     * @param address    the restaurant's address
     * @param info       the restaurant's information
     */
    @Override
    public void addRestaurant(String address, String[] info) {
        hashTable.put(address, info);
    }

    /**
     * Finds the restaurant and returns their name
     * 
     * @param address The restaurant's address
     * @return The restaurant's number if they were found, null otherwise
     * @throws NoSuchElementException when the value is not contained in the hash
     *                                table
     */
    @Override
    public String[] searchRestaurant(String address) throws NoSuchElementException {
        if (containsKey(address)) {
            return hashTable.get(address);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Clears the entire list.
     */
    @Override
    public void clearTable() {
        hashTable.clear();
        
    }

    /**
     * Returns the size of the database (hashtable).
     */
    public int size() {
        return hashTable.size();
    }

    /**
     * Returns  true if the hashtable contains the restaurant
     *          false if the restaurant is not in the database
     * 
     * @param name The restaurant's name
     * @return true if restaurant's name was found, false otherwise
     */
    public boolean containsKey(String name) {
        return hashTable.containsKey(name);
    }

    @Override
    /**
     * Returns the new set of Key values for the hashtable after removal
     * of a restaurant when given the address
     * 
     * @param address The restaurant's address
     * @return rating, a String array containing the Keys of the hashtable
     */
    public String[] removeRestaurant(String address) {
      String[] rating = hashTable.remove(address);
      return rating;
    }


}
