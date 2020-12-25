// --== CS400 File Header Information ==--
// Name: Megan Le
// Email: mle25@wisc.edu
// Team: AF
// Role: Back End Developer 
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;

public interface Table<K, V> {

	public boolean put(K key, V value);

	public V get(K key) throws NoSuchElementException;

	public int size();

	public boolean containsKey(K key);

	public String[] remove(K key);

	public void clear();
}
