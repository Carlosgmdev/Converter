package com.carlosg.converter.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class App extends JFrame {

	private JPanel contentPane;
	private JPanel main;
	private Sidebar sidebar;
	private CurrencyView currencyView;
	private TemperatureView temperatureView;
	private DataView dataView;
	private WeightView weightView;
	private LengthView lengthView;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public App() {
		setTitle("Converter");
		initializeUI();
	}

	private void initializeUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/assets/icon.png")));
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		main = new JPanel();
		main.setBackground(UIManager.getColor("Button.highlight"));
		main.setBounds(222, 0, 579, 472);
		contentPane.add(main);
		main.setLayout(null);
		setMain(main);
		
		setCurrencyView(new CurrencyView());
		setTemperatureView(new TemperatureView());
		setDataView(new DataView());
		setWeightView(new WeightView());
		setLengthView(new LengthView());
		main.add(currencyView);
		
		sidebar = new Sidebar(this);
		sidebar.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.add(sidebar);
	}

	public CurrencyView getCurrencyView() {
		return this.currencyView;
	}

	public TemperatureView getTemperatureView() {
		return temperatureView;
	}

	public JPanel getMain() {
		return this.main;
	}
	
	public void setCurrencyView(CurrencyView currencyView) {
		this.currencyView = currencyView;
	}

	public void setTemperatureView(TemperatureView temperatureView) {
		this.temperatureView = temperatureView;
	}

	public void setMain(JPanel main) {
		this.main = main;
	}

	public DataView getDataView() {
		return dataView;
	}

	public void setDataView(DataView dataView) {
		this.dataView = dataView;
	}

	public WeightView getWeightView() {
		return weightView;
	}

	public void setWeightView(WeightView weightView) {
		this.weightView = weightView;
	}

	public LengthView getLengthView() {
		return lengthView;
	}

	public void setLengthView(LengthView lengthView) {
		this.lengthView = lengthView;
	}
	

}
