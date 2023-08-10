package com.carlosg.converter.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.carlosg.converter.models.TemperatureModel;

public class TemperatureController extends Controller {
	
	public TemperatureController( ) {
		super(new TemperatureModel());
	}
	
	@Override
	public double convert(String dataFrom, String dataTo, double amount) {
		
		double result = 0.0;
	    
	    if(dataFrom == "CELSIUS" && dataTo == "FAHRENHEIT") {
	    	result = (amount*9/5) + 32;
	    } else if(dataFrom == "CELSIUS" && dataTo == "KELVIN") {
	    	result = amount + 273.15;
	    } else if(dataFrom == "FAHRENHEIT" && dataTo == "CELSIUS") {
	    	result = (amount - 32) * 5/9;
	    } else if(dataFrom == "FAHRENHEIT" && dataTo == "KELVIN") {
	    	result = (amount + 459.67) * 5/9;
	    } else if(dataFrom == "KELVIN" && dataTo == "CELSIUS") {
	    	result = amount - 273.15;
	    } else if(dataFrom == "KELVIN" && dataTo == "FAHRENHEIT") {
	    	result = (amount * 9/5) - 459.67;
	    } else {
	    	result = amount;
	    }
	    
	    BigDecimal resultDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
	    return resultDecimal.doubleValue();
	}
	
}