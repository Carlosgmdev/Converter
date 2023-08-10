package com.carlosg.converter.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.carlosg.converter.models.WeightModel;

public class WeightController extends Controller {
	
	public WeightController( ) {
		super(new WeightModel());
	}
	
	@Override
	public double convert(String dataFrom, String dataTo, double amount) {
		double conversionFactor = getData().getDouble(dataFrom) / getData().getDouble(dataTo);
        double result = amount * conversionFactor;
	    BigDecimal resultDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
	    return resultDecimal.doubleValue();
	}
}