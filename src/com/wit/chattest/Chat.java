package com.wit.chattest;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Chat extends JFrame implements ActionListener{
	private JFrame frame;
	private JTextField textfield;
//	private JPasswordField passwordField;
	private JButton butok;
	private JTextArea textarea;
	public Chat(){
		init();
	}
	public void init(){
		frame = new JFrame();
		textfield=new JTextField();
		textarea=new JTextArea();
		butok=new JButton("∑¢ÀÕ");
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(600, 600);
	//	frame.setBounds(300, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textarea.setBounds(10,10,400,450);
		textfield.setBounds(10,440,300,40);
		butok.setBounds(330,330,80,40);
		
		frame.add(textfield);
		frame.add(butok);
		frame.add(textarea);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==butok){
			if("".equals(textfield.getText())){
				
			}
			else{
				textarea.setText("Œ“£∫ "+textfield.getText()+"\r\n");
			}
		}
		
	}
	public static void main(String[] args){
		new Chat();
	}

}
