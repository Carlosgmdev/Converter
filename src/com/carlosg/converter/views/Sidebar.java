package com.carlosg.converter.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Sidebar extends JPanel{
	
	private SectionBtn currencyBtn;
	private SectionBtn temperatureBtn;
	private SectionBtn lengthBtn;
	private SectionBtn weightBtn;
	private SectionBtn dataBtn;
	
	public Sidebar(App app) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 222, 472);
		setLayout(null);
		
		JPanel parent = app.getMain();
		
		add(currencyBtn = new SectionBtn("Divisas", 120, app.getCurrencyView(), parent));
		add(temperatureBtn = new SectionBtn("Temperatura", 180, app.getTemperatureView(), parent));
		add(lengthBtn = new SectionBtn("Longitud", 240, app.getLengthView(), parent));
		add(weightBtn = new SectionBtn("Peso", 300, app.getWeightView(), parent));
		add(dataBtn = new SectionBtn("Datos", 360, app.getDataView(), parent));
		
		JLabel lblNewLabel = new JLabel("Converter");
		lblNewLabel.setIcon(new ImageIcon(Sidebar.class.getResource("/assets/icon.png")));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 32, 210, 50);
		add(lblNewLabel);
	}
}
