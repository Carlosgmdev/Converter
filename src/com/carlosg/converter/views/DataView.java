package com.carlosg.converter.views;

import com.carlosg.converter.controllers.DataController;

public class DataView extends Section{
	
	public DataView() {
        super("Datos", new DataController());
    }

}
