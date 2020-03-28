package question1;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

/**
 * @author krishan
 * DictionaryImpl class implementation of Dictionary interface
 * provides function for dictionary operation
 */
public class DictionaryImplementation implements Dictionary
{

	Node head;

	/**
	 * Parameterised constructor
	 * @input json object
	 */
	public DictionaryImplementation(JSONObject jsonObject) throws Exception
	{
		this.head = null;
		this.input(jsonObject);
	}

	/**
	 * method for add key and value from json object
	 * @param jsonObject
	 */
	private boolean input(JSONObject jsonObject) throws Exception
	{
		try
		{
			if (jsonObject == null)
			{
				throw new Exception("jsonObject cant be null");
			}
			for (Object obj : jsonObject.keySet())
			{
				String key = (String) obj;
				String value = (String) jsonObject.get(key);
				this.add(key, value);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * method for add key and value in BST 
	 */
	@Override
	public boolean add(String key, String value)
	{
		try
		{
			if (key == null || value == null)
			{
				throw new NullPointerException("Invalid key or value");
			}
			if (head == null)
			{
				head = new Node(key, value);
			}
			else
			{
				addRec(key, value, head);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Recursive function for adding key and value in BST 
	 * @param key
	 * @param value
	 * @param node
	 * @return
	 */
	private boolean addRec(String key, String value, Node node)
	{
		try
		{
			if (key == null || value == null || node == null)
			{
				throw new NullPointerException("null input is not accepted");
			}

			if (key.compareTo(node.getKey()) <= -1)
			{
				if (node.getLeft() != null)
				{

					addRec(key, value, node.getLeft());
				}
				else
				{

					node.setLeft(new Node(key, value));
					node.getLeft().setParent(node);
				}
			}

			else if (key.compareTo(node.getKey()) >= 1)
			{
				if (node.getRight() != null)
				{

					addRec(key, value, node.getRight());
				}
				else
				{

					node.setRight(new Node(key, value));
					node.getRight().setParent(node);
				}
			}
			else
			{
				node = new Node(key, value);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * method for delete a key and value form BST
	 * @param key
	 */
	@Override
	public boolean delete(String key)
	{
		try
		{
			if (key.length() == 0 || key == null)
			{
				throw new NullPointerException("Invalid key or value");
			}

			if (head != null)
			{
				return deleteRec(key, head);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * recursive function for deleting a key form BST
	 * @param key
	 * @param node
	 * @return
	 */
	private boolean deleteRec(String key, Node node)
	{
		try
		{
			if (key.length() == 0 || key == null || node == null)
			{
				throw new NullPointerException("null input data not accepted");
			}

			if (key.compareTo(node.getKey()) <= -1)
			{
				if (node.getLeft() != null)
				{

					return deleteRec(key, node.getLeft());
				}
			}

			else if (key.compareTo(node.getKey()) >= 1)
			{
				if (node.getRight() != null)
				{

					return deleteRec(key, node.getRight());
				}
			}

			else if (key.compareTo(node.getKey()) == 0)
			{

				if (node.getLeft() == null)
				{
					if (node.getRight() == null)
					{

						if (node.getParent().getLeft() == node)
						{
							node.getParent().setLeft(null);
						}
						else
						{
							node.getParent().setRight(null);
						}
					}
				}

				else if (node.getLeft() == null && node.getRight() != null)
				{

					if (node.getParent().getLeft() == node)
					{
						node.getParent().setLeft(node.getRight());
					}
					else
					{
						node.getParent().setRight(node.getRight());
					}
				}

				else if (node.getRight() == null && node.getLeft() != null)
				{

					if (node.getParent().getRight() == node)
					{
						node.getParent().setRight(node.getLeft());
					}
					else
					{
						node.getParent().setLeft(node.getLeft());
					}
				}

				else
				{
					Node newNode = findMin(node.getRight());
					node.setKey(newNode.getKey());
					node.setValue(newNode.getValue());
					return deleteRec(newNode.getKey(), newNode);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return true;

	}

	/**
	 * method to find minimum value from tree
	 * @param currentNode
	 * @return
	 */
	private Node findMin(Node currentNode)
	{
		try
		{
			if (currentNode == null)
			{
				throw new NullPointerException("null input data not accepted");
			}

			while (currentNode.getLeft() != null)
			{
				currentNode = currentNode.getLeft();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return currentNode;

	}

	/**
	 * method to traverse tree
	 * @param root
	 * @param list
	 * @return
	 */
	private List<Value> inorderRec(Node root, List<Value> list)
	{
		try
		{
			if (root != null)
			{
				inorderRec(root.left, list);
				list.add(new Value(root.getKey(), root.getValue()));
				inorderRec(root.right, list);
			}
			else
				throw new NullPointerException("null input data not accepted");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * method to find a value with key
	 * @param key
	 */
	@Override
	public String getValue(String key)
	{
		try
		{
			if (head != null)
			{
				return getValueRec(key, head);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * recursive method to find a value form tree
	 * @param key
	 * @param node
	 * @return
	 */
	private String getValueRec(String key, Node node)
	{
		try
		{
			if (node == null)
			{
				return null;
			}
			else if (key.compareTo(node.getKey()) == 0)
			{
				return node.getValue();
			}
			else if (key.compareTo(node.getKey()) <= -1)
			{
				return getValueRec(key, node.getLeft());
			}
			else if (key.compareTo(node.getKey()) >= 1)
			{
				return getValueRec(key, node.getRight());
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * method to find all values from tree
	 */
	@Override
	public List<Value> getAll()
	{
		List<Value> valueList = null;
		try
		{
			valueList = new ArrayList<Value>();
			if (head != null)
			{
				valueList = inorderRec(head, valueList);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return valueList;
	}

	@Override
	public int getSize()
	{
		List<Value> valueList = getAll();
		return valueList.size();
	}

	/**
	 * method to find value of key between keys
	 * @param key1
	 * @param key2
	 */
	@Override
	public List<Value> getBetween(String key1, String key2)
	{
		List<Value> finalList = null;
		try
		{
			List<Value> list = getAll();
			finalList = new ArrayList<Value>();
			for (Value v : list)
			{
				if (v.getKey().compareTo(key1) >= 1 && v.getKey().compareTo(key2) <= -1)
				{
					finalList.add(v);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return finalList;
	}

}