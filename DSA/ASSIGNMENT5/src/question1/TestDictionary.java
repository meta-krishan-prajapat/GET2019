package question1;

import static org.junit.Assert.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

/**
 * @author krishan
 * test class for DictionaryImpl
 */
public class TestDictionary
{

	@Test
	public void addSuccessTest() throws Exception
	{

		String value = new String();
		FileReader file = new FileReader("C:/Users/Admin/workspace/DSAASSIGNMENT5/src/Files/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		Dictionary dictionary = new DictionaryImplementation(json);

		value = dictionary.getValue("20");
		assertEquals(value, "twenty");
		value = dictionary.getValue("30");
		assertEquals(value, "thirty");
		value = dictionary.getValue("40");
		assertEquals(value, "fourty");
		value = dictionary.getValue("50");
		assertEquals(value, "fifty");
		value = dictionary.getValue("60");
		assertEquals(value, "sixty");
		value = dictionary.getValue("70");
		assertEquals(value, "seventy");
		value = dictionary.getValue("80");
		assertEquals(value, "eighty");
	}

	@Test
	public void getAllSuccessTest() throws Exception
	{

		FileReader file = new FileReader("C:/Users/Admin/workspace/DSAASSIGNMENT5/src/Files/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		Dictionary dictionary = new DictionaryImplementation(json);

		List<Value> expected = new ArrayList<Value>();
		expected.add(new Value("20", "twenty"));
		expected.add(new Value("30", "thirty"));
		expected.add(new Value("40", "fourty"));
		expected.add(new Value("50", "fifty"));
		expected.add(new Value("60", "sixty"));
		expected.add(new Value("70", "seventy"));
		expected.add(new Value("80", "eighty"));
		List<Value> valueList = dictionary.getAll();

		for (int index = 0; index < expected.size(); index++)
		{
			assertEquals(expected.get(index).getKey(), valueList.get(index).getKey());
			assertEquals(expected.get(index).getValue(), valueList.get(index).getValue());
		}

	}

	@Test
	public void getBetweenSuccessTest() throws Exception
	{

		FileReader file = new FileReader("C:/Users/Admin/workspace/DSAASSIGNMENT5/src/Files/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		Dictionary dictionary = new DictionaryImplementation(json);

		List<Value> expected = new ArrayList<Value>();
		expected.add(new Value("40", "fourty"));
		expected.add(new Value("50", "fifty"));
		expected.add(new Value("60", "sixty"));
		expected.add(new Value("70", "seventy"));
		List<Value> valueList = dictionary.getBetween("30", "80");

		for (int index = 0; index < expected.size(); index++)
		{
			assertEquals(expected.get(index).getKey(), valueList.get(index).getKey());
			assertEquals(expected.get(index).getValue(), valueList.get(index).getValue());
		}

	}

	@Test
	public void deleteSuccessTest() throws Exception
	{

		FileReader file = new FileReader("C:/Users/Admin/workspace/DSAASSIGNMENT5/src/Files/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		DictionaryImplementation dictionary = new DictionaryImplementation(json);
		boolean result = dictionary.delete("20");
		assertTrue(result);
		result = dictionary.delete("60");
		assertTrue(result);
		int size = dictionary.getSize() + 1;
		assertEquals(6, size);
	}

	@Test
	public void getValueSuccessTest() throws Exception
	{

		FileReader file = new FileReader("C:/Users/Admin/workspace/DSAASSIGNMENT5/src/Files/data.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		DictionaryImplementation dictionary = new DictionaryImplementation(json);
		assertEquals("fifty", dictionary.getValue("50"));
		assertEquals("seventy", dictionary.getValue("70"));

	}

}