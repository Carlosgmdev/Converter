package com.carlosg.converter.models;

import org.json.JSONObject;

public class DataModel extends Model {
	
	public DataModel() {
		super();
	}

	@Override
	protected void populateData() {
		JSONObject data = new JSONObject();
		data.put("BITS", 0.125); // 1 bit = 0.125 bytes
        data.put("BYTES", 1.0); // 1 byte = 1 byte
        data.put("KILOBYTES", 1024.0); // 1 kilobyte = 1024 bytes
        data.put("MEGABYTES", 1048576.0); // 1 megabyte = 1024 kilobytes
        data.put("GIGABYTES", 1073741824.0); // 1 gigabyte = 1024 megabytes
        data.put("TERABYTES", 1099511627776.0); // 1 terabyte = 1024 gigabytes
        data.put("PETABYTES", 1125899906842624.0); // 1 petabyte = 1024 terabytes
        data.put("EXABYTES", 1152921504606846976.0); // 1 exabyte = 1024 petabytes
        setData(data);
	}
	
}
