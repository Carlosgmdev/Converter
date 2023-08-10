package com.carlosg.converter.views;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONObject;

import com.carlosg.converter.controllers.Controller;

import java.util.Iterator;

public class Section extends JPanel {

    private String title;
    private JTextField dataInput = new JTextField();
    private JTextField result = new JTextField();
    private JLabel amountLbl = new JLabel();
    private JComboBox<String> dataFrom = new JComboBox<>();
    private JComboBox<String> dataTo = new JComboBox<String>();
    private JLabel resultLbl = new JLabel();
    private JLabel toLbl = new JLabel();
    private JSONObject data = new JSONObject();
    private JLabel titleLbl = new JLabel();
    private JButton copyResultBtn = new JButton();
    private Controller controller;

	public Section(String title, Controller controller) {	
        this.title = title;
        this.controller = controller;
        this.data = controller.getData();
        initializeSection();
    }

	private void initializeSection() {
    	setBackground(UIManager.getColor("CheckBox.background"));
        setLayout(null);
        setBounds(0, 0, 579, 472);
        
        titleLbl.setText(this.title);
        titleLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        titleLbl.setBounds(6, 6, 641, 27);
        titleLbl.setBackground(new Color(254, 255, 255));
        add(titleLbl);

        dataFrom.setBounds(40, 240, 200, 32);
        dataFrom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        dataFrom.setBackground(new Color(254, 255, 255));
        dataFrom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(dataFrom);
        dataFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResult();
            }
        });
        
        amountLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        amountLbl.setText("Cantidad");
        amountLbl.setBounds(40, 115, 190, 32);
        amountLbl.setHorizontalAlignment(SwingConstants.CENTER);
        add(amountLbl);

        dataTo.setBounds(336, 240, 200, 32);
        dataTo.setToolTipText("Seleccione");
        dataTo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        dataTo.setBackground(new Color(254, 255, 255));
        add(dataTo);
        dataTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResult();
            }
        });
        
     // Rellena los JComboBox con los datos del JSONObject
        if(validateData()) {
        	populateComboBoxes();
        } else {
        	JOptionPane.showMessageDialog(null, "Necesitas conexión a internet para obtener los datos de divisa, pero podras utilizar las demás unidades de conversión.", "Error de conexón", JOptionPane.WARNING_MESSAGE);
        }
        dataInput.setBackground(UIManager.getColor("CheckBox.background"));
         

        dataInput.setBounds(40, 159, 200, 60);
        dataInput.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(202, 202, 202)));
        dataInput.setHorizontalAlignment(SwingConstants.CENTER);
        dataInput.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        dataInput.setColumns(10);
        dataInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateResult();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateResult();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateResult();
            }
        });
        add(dataInput);
        
        toLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        toLbl.setText("A");
        toLbl.setBounds(284, 239, 15, 32);
        add(toLbl);
        resultLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));

        resultLbl.setText("Resultado");
        resultLbl.setBounds(336, 115, 190, 32);
        resultLbl.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLbl);
        result.setBackground(UIManager.getColor("CheckBox.background"));
        result.setBounds(336, 159, 200, 60);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        result.setColumns(10);
        result.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(202, 202, 202)));
        add(result);
        
        copyResultBtn.setText("Copiar");
        copyResultBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        copyResultBtn.setBounds(336, 275, 200, 32);
        add(copyResultBtn);
        copyResultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyResult();
            }
        });
	}
	
	private void copyResult() {
		String toCopy = result.getText();
	     if (!toCopy.isEmpty()) {
	            StringSelection selection = new StringSelection(toCopy);
	            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	            clipboard.setContents(selection, null);
	            JOptionPane.showMessageDialog(this, "Valor copiado al portapapeles.", "Copia Exitosa", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "No hay valor para copiar.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}

	private void populateComboBoxes() {
        dataFrom.removeAllItems();
        dataTo.removeAllItems();
        Iterator<String> keys = data.keys();
        while (keys.hasNext()) {
            String dataKey = keys.next();
            dataFrom.addItem(dataKey);
            dataTo.addItem(dataKey);
        }
    }
	
    private boolean validateData() {
    	boolean result;
		if (this.data == null) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

    private void updateResult() {
        String from = (String) dataFrom.getSelectedItem();
        String to = (String) dataTo.getSelectedItem();
        double amount = 0.0;
        try {
            amount = Double.parseDouble(dataInput.getText());
        } catch (NumberFormatException e) {
            // Si no se puede convertir a double, deja el resultado vacío
            result.setText("");
            return;
        }
        double resultAmount = controller.convert(from, to, amount);
        result.setText(String.valueOf(resultAmount));
    }
    
    public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}