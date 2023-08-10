package com.carlosg.converter.views;

import com.carlosg.converter.controllers.TemperatureController;

public class TemperatureView extends Section {

    public TemperatureView() {
        super("Temperatura", new TemperatureController());
    }

}