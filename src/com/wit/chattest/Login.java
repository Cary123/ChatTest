package com.wit.chattest;
import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.InetAddress;


import java.io.*;
import java.util.*;
import java.net.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    ImageIcon icon=new ImageIcon("picture/denglu.jpg");
	Image image=icon.getImage();
	Socket sokLog;
	OutputStream out;
	InputStream in;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void connServer(){
		try {
			 sokLog=new Socket(InetAddress.getByName("115.159.55.193"),11011);
			 out=sokLog.getOutputStream();
			 in=sokLog.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Login() {
	//	connServer();
		setVisible(true);
		setTitle("µÇÂ¼½çÃæ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
			g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(),null);
			super.paintComponent(g);
			
			}
		
		};
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(62, 71, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(62, 130, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(126, 68, 143, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setBounds(186, 188, 65, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
						
			}
		});
		button_1.setBounds(84, 188, 70, 23);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\u672A\u767B\u5F55");
		label.setBounds(338, 102, 54, 15);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 127, 143, 21);
		contentPane.add(passwordField);
	}
}
