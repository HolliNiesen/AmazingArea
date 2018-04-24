package com.numbersapi;

/**
 * The type Response.
 */
public class Response {
	private int number;
	private boolean found;
	private String text;
	private String type;

	/**
	 * Set number.
	 *
	 * @param number the number
	 */
	public void setNumber(int number){
		this.number = number;
	}

	/**
	 * Get number int.
	 *
	 * @return the int
	 */
	public int getNumber(){
		return number;
	}

	/**
	 * Set found.
	 *
	 * @param found the found
	 */
	public void setFound(boolean found){
		this.found = found;
	}

	/**
	 * Is found boolean.
	 *
	 * @return the boolean
	 */
	public boolean isFound(){
		return found;
	}

	/**
	 * Set text.
	 *
	 * @param text the text
	 */
	public void setText(String text){
		this.text = text;
	}

	/**
	 * Get text string.
	 *
	 * @return the string
	 */
	public String getText(){
		return text;
	}

	/**
	 * Set type.
	 *
	 * @param type the type
	 */
	public void setType(String type){
		this.type = type;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"number = '" + number + '\'' + 
			",found = '" + found + '\'' + 
			",text = '" + text + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
