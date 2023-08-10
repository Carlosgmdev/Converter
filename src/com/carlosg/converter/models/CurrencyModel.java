package com.carlosg.converter.models;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;



public class CurrencyModel extends Model {
	
	public CurrencyModel() {
		super();
	}


	@Override
	protected void populateData() {
		 JSONArray data = null;
	        try {
	            // Estableciendo conexión con la API
	            URL url = new URL("http://data.fixer.io/api/latest?access_key=5d2545225a35759be0b4914ceeb378b1");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.connect();

	            // Evaluando la conexión
	            if (conn.getResponseCode() != 200) {
	                // Lanzar un error
	                throw new Exception("Error al establecer la conexión");
	            } else {
	                // Continuar con la ejecución del programa
	                StringBuilder dataString = new StringBuilder();
	                dataString.append("[");
	                Scanner scanner = new Scanner(url.openStream());
	                while (scanner.hasNext()) {
	                    dataString.append(scanner.nextLine());
	                }
	                scanner.close();
	                dataString.append("]");
	                JSONArray jsonArray = new JSONArray(dataString.toString());
	                setData(jsonArray.getJSONObject(0).getJSONObject("rates"));
	            }

	        } catch (Exception e) {
	        	setData(null);
	        }
	}
}

