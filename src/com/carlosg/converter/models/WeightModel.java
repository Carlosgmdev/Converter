package com.carlosg.converter.models;

import org.json.JSONObject;

public class WeightModel extends Model {
	
	public WeightModel() {
		super();
	}

	@Override
	protected void populateData() {
		JSONObject data = new JSONObject();
		data.put("GRAMOS", 1.0); // 1 gramo = 1 gramo
	    data.put("KILOGRAMOS", 1000.0); // 1 kilogramo = 1000 gramos
	    data.put("TONELADAS", 1000000.0); // 1 tonelada = 1000000 gramos
	    data.put("LIBRAS", 453.592); // 1 libra = 453.592 gramos
	    data.put("ONZAS", 28.3495); // 1 onza = 28.3495 gramos
	    setData(data);
	}
	
}
