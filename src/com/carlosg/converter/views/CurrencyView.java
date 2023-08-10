package com.carlosg.converter.views;

import com.carlosg.converter.controllers.CurrencyController;

public class CurrencyView extends Section {

    public CurrencyView() {
        super("Divisas", new CurrencyController());
    }


}