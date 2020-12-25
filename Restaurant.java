// --== CS400 File Header Information ==--
// Name: Hunter Goff
// Email: hfgoff@wisc.edu
// Team: AF
// Role: Data Wrangler
// TA: Sophie 
// Lecturer: Floiren Heimrel
// Notes to Grader: n/a

/**
 * An Object storing relevant information about a restaurant
 * 
 * @author huntergoff
 *
 */
   
public class Restaurant {
  //the table headers from the .csv
  private String address; 
  private String name; 
  private String priceRating; 
  private String genre; 
  private String starRating;
  
  /**
   * 
   * @param address the address on state street
   * @param name    the name of the place
   * @param priceRating the price rating from $-$$$
   * @param genre the type of food served there
   * @param starRating the rating from google from 1-5
   */
  public Restaurant(String address, String name, String priceRating, String genre, String starRating) {
    this.address = address; 
    this.name = name; 
    this.priceRating = priceRating; 
    this.genre = genre; 
    this.starRating = starRating; 
  }
  
  /**
   * @return address
   */
  public String getAddress() {
    return address;
  }
  /**
   * set address
   */
  public void setAddress(String address) {
    this.address = address;
  }
  /**
   * @return name
   */
  public String getName() {
    return name;
  }
  /**
   * set name
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return price rating from $-$$$
   */
  public String getPriceRating() {
    return priceRating;
  }
  /**
   * set price rating from $-$$$
   */
  public void setPriceRating(String priceRating) {
    this.priceRating = priceRating;
  }
  /**
   * @return genre
   */
  public String getGenre() {
    return genre;
  }
  /**
   * set the genre (describes the food served)
   */
  public void setGenre(String genre) {
    genre = genre;
  }
  /**
   * @return the price rating from 1-5 (can have decimals)
   */
  public String getStarRating() {
    return starRating;
  }
  /**
   * set the price rating from 1-5 (can have decimals)
   */
  public void setStarRating(String starRating) {
    this.starRating = starRating;
  }

}
