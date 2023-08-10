package com.carlosg.converter.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.carlosg.converter.models.CurrencyModel;

public class CurrencyController extends Controller {
	
	public CurrencyController( ) {
		super(new CurrencyModel());
	}
	
	@Override
	public double convert(String dataFrom, String dataTo, double amount) {
		double from = getData().getDouble(dataFrom);
		double to = getData().getDouble(dataTo);
		double result = (amount/from)*to;
		BigDecimal resultDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
	    return resultDecimal.doubleValue();
	}
}
