// --== CS400 File Header Information ==--
// Name: Megan Le
// Email: mle25@wisc.edu
// Team: AF
// Role: Back End Developer 
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
public interface List {
	public void addRestaurant(String address, String[] info);
  public String[] removeRestaurant(String address);
  public String[] searchRestaurant(String address);
  public void clearTable();
}
