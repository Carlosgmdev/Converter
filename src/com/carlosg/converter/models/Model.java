package com.carlosg.converter.models;

import org.json.JSONObject;

public abstract class Model {
	
	private JSONObject data;
	
	public Model() {
		populateData();
	}
	
	protected abstract void populateData();

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}
	
}
