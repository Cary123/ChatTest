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
import javax.swing.JOptionPane;
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
			 sokLog=new Socket(InetAddress.getByName("115.159.55.193"),33333);
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
		setTitle("µ«¬ºΩÁ√Ê");
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
		
		JLabel label = new JLabel("\u672A\u767B\u5F55");
		label.setBounds(338, 102, 54, 15);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 127, 143, 21);
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=textField.getText();
				String password=passwordField.getText();
				if(username.trim().toCharArray().length==11){
					connServer();
						try {
						out.write("login_begin_conn".getBytes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					try {
						out.write((username+"="+password).getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					byte[] buf=new byte[1024];
					int len=0;
					try {
						len=in.read(buf);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					String mess=new String(buf,0,len).trim();//»•µÙø’∏Ò
					System.out.println(mess+mess);
					
					if(mess.equals("µ«¬º ß∞‹")){
						try {
							sokLog.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(contentPane, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ", "Ã·–—",JOptionPane.INFORMATION_MESSAGE);
					}
					else if(mess.equals("µ«¬º≥…π¶")){
						try {
							sokLog.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						new ChatMain();
						System.out.println(123);
						setVisible(false);
					}
					
				}
				else{
					JOptionPane.showMessageDialog(contentPane, "’À∫≈¥ÌŒÛ", "Ã·–—",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button.setBounds(186, 188, 65, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Register();
			
			setVisible(false); 
				
			}
		});
		button_1.setBounds(84, 188, 70, 23);
		contentPane.add(button_1);
		

	}
}
