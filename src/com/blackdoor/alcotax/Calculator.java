package com.blackdoor.alcotax;

import java.text.DecimalFormat;

public class Calculator {
	
	private double totalPrice, currPrice;
	public static final double MIN_SALES_TAX = 0.07;
	public static final double MAX_SALES_TAX = .095;
	public static final double HARDA_TAX = .205;
	public static final double HARDA_FLAT_TAX = 3.7708;
	public static final double MAX_WINE_FLAT_TAX = .4536;
	
	public Calculator()
	{
		totalPrice = currPrice = 0;
	}
	
	public void CalculateNewTotal()
	{
		totalPrice += currPrice;
	}
	
	public void CalculateCurrPrice(double vol, double price, String type)
	{
		if(type == "hardA")
    	{
    		currPrice = price*HARDA_TAX+vol*HARDA_FLAT_TAX+price;
    	}
    	if(type == "beer")
    	{
    		currPrice = price*MIN_SALES_TAX+price;
    		currPrice = price*MAX_SALES_TAX+price;
    	}
    	if(type == "wine"){
    		currPrice = (price+vol*MAX_WINE_FLAT_TAX)*MAX_SALES_TAX+(price+vol*MAX_WINE_FLAT_TAX);
    		currPrice = (price+vol*MAX_WINE_FLAT_TAX)*MIN_SALES_TAX+(price+vol*MAX_WINE_FLAT_TAX);
    	}
	}
	
	public double GetCurrPrice()
	{
		DecimalFormat df = new DecimalFormat("#.##");
    	currPrice = Double.parseDouble(df.format(currPrice));
		return currPrice;
	}
	
	public double GetTotalPrice()
	{
		DecimalFormat df = new DecimalFormat("#.##");
    	totalPrice = Double.parseDouble(df.format(totalPrice));
		return totalPrice;
	}

}
