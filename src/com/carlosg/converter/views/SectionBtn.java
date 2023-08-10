package com.carlosg.converter.views;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import javax.swing.UIManager;

public class SectionBtn extends JButton {

    private String name;

    public SectionBtn(String name, int y, Section section, JPanel parent) {
    	
    	setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	setForeground(new Color(0,0,0));
    	setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
    	setBorderPainted(false);
        this.name = name;
        setText(getName());
        setBounds(6, y, 210, 50);
        setBackground(UIManager.getColor("Button.highlight"));
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 changeSection(section, parent);
            }
        });
    }

    public String getName() {
        return this.name;
    }
    
    private void changeSection(Section section, JPanel parent) {
    	parent.removeAll();
    	parent.add(section);
    	parent.revalidate();
    	parent.repaint();
    }
}
