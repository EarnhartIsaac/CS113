package edu.miracosta.cs113;

public class MenuOption 
{
	//FORMAT LIKE A COMMAND ex. "Remove object", "Search for name"
	private String optionName;
	private char keyBind;
	
	public char getKeyBind()
	{
		return this.keyBind;
	}
	
	public String getOptionName()
	{
		return this.optionName;
	}
	
	public MenuOption(String optionName,char keyBind)
	{
		this.optionName = optionName;
		this.keyBind = keyBind;
	}
	
}
