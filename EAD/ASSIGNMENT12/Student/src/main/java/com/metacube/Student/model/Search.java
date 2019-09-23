package com.metacube.Student.model;

import javax.validation.constraints.NotBlank;

/**
 * @author krishan
 * Search data transfer object
 *
 */
public class Search
{

	@NotBlank
	String key;

	/**
	 * @return key
	 * 
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 * set the key
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * @param key
	 * contructor to set key
	 */
	public Search(@NotBlank String key)
	{
		super();
		this.key = key;
	}

	/**
	 * Constructor
	 */
	public Search()
	{
		super();
	}
}
