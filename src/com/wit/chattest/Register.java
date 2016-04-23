package com.wit.chattest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	private JButton button_1;
    private JPasswordField password;
    private JPasswordField password_1;
	
	ImageIcon icon=new ImageIcon("picture/register.jpg");
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
					Register frame = new Register();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public void connServer(){
		try {
			 sokLog=new Socket(InetAddress.getByName("115.159.55.193"),33333);
			 out=sokLog.getOutputStream();
			 in=sokLog.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("服务器连接失败");
			e1.printStackTrace();
		}
	}
	
	public Register() {
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					sokLog.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Login();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
			}
			
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel label = new JLabel("\u6CE8\u518C\u4FE1\u606F");
		label.setBounds(10, 10, 76, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");
		label_1.setBounds(10, 62, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setBounds(10, 115, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_3.setBounds(10, 160, 76, 15);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(96, 59, 169, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(96, 112, 169, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		password_1 = new JPasswordField();
		password_1.setBounds(96, 157, 169, 21);
		contentPane.add(password_1);
		password_1.setColumns(10);
		
		JLabel labelWarm=new JLabel();
		labelWarm.setText("\u6CE8\u610F\uFF1A\u8D26\u53F7\u540D\u5FC5\u987B\u4E3A11\u4F4D\u7684\u624B\u673A\u53F7\uFF0C\u5BC6\u7801\u4E0D\u8D85\u8FC712\u4E2A\u5B57\u7B26");
		labelWarm.setBounds(10, 233, 414, 21);
		contentPane.add(labelWarm);
		
		
		
		button=new JButton();
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(password.getText().equals(password_1.getText())){
					if(textField.getText().toCharArray().length==11&&password.getText().toCharArray().length<=12){
						
						connServer();
						try {
							out.write("register_begin_conn".getBytes());
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
							out.write((textField.getText()+"="+password.getText()).getBytes());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						byte[] buf=new byte[1024];
						int len = 0;
						String receive="注册失败";
						try {
							len = in.read(buf);
							receive=new String(buf,0,len);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							sokLog.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(contentPane,receive, "提醒",JOptionPane.INFORMATION_MESSAGE);
					    new Login();
					  
					}
					else 
						JOptionPane.showMessageDialog(contentPane, "账号或密码不符合规范", "提醒",JOptionPane.INFORMATION_MESSAGE);
				}
				else 
					JOptionPane.showMessageDialog(contentPane, "两次密码不一样", "提醒",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button.setText("\u786E\u8BA4");
		button.setBounds(40, 197, 80, 26);
		contentPane.add(button);
		
		button_1=new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				password.setText("");
				password_1.setText("");
			}
		});
		button_1.setText("\u53D6\u6D88");
		button_1.setBounds(153, 197, 80, 26);
		contentPane.add(button_1);
	}
}
