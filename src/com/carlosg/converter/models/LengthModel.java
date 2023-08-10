package com.carlosg.converter.models;

import org.json.JSONObject;

public class LengthModel extends Model {
	
	public LengthModel() {
		super();
	}
	
	@Override
	protected void populateData() {
		JSONObject data = new JSONObject();
		data.put("CENTIMETROS", 0.01); // 1 centímetro = 0.01 metros
        data.put("METROS", 1.0); // 1 metro = 1 metro
        data.put("KILOMETROS", 1000.0); // 1 kilómetro = 1000 metros
        data.put("PIES", 0.3048); // 1 pie = 0.3048 metros
        data.put("YARDAS", 0.9144); // 1 yarda = 0.9144 metros
        data.put("MILLAS", 1609.34); // 1 milla = 1609.34 metros
        setData(data);
	}
}
