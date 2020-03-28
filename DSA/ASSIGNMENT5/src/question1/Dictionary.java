package question1;

import java.util.List;

/**
 * @author krishan
 * interface for Dictionary 
 * provides abstract method for add,delete,getValue and get all
 */
public interface Dictionary
{

	/**
	 * @param key
	 * @param value
	 * @return true when key and value is add in dictionary
	 * @throws Exception
	 */
	public boolean add(String key, String value) throws Exception;

	/**
	 * @param key
	 * @return true when key is delete in the dictionary
	 * @throws Exception
	 */
	public boolean delete(String key) throws Exception;

	/**
	 * @param key
	 * @return value of respected key
	 */
	public String getValue(String key);

	/**
	 * @return all value
	 */
	public List<Value> getAll();

	/**
	 * @return size of the dictionary
	 */
	public int getSize();

	/**
	 * @param key1
	 * @param key2
	 * @return list value between key1 and key2
	 */
	public List<Value> getBetween(String key1, String key2);

}