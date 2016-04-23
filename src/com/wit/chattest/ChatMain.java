package com.wit.chattest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.*;
public class ChatMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTextArea textArea;
	JButton button ;
	JList list;
	JLabel label;
	JLabel label_1;
	JList list_1;
	
	Socket sokGao;
	OutputStream out;
	InputStream in;
	
	//JScrollPane scroll;
	JMenuBar menuBar;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatMain frame = new ChatMain();
					
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
		try{
		 sokGao=new Socket(InetAddress.getByName("115.159.55.193"),33333);
		 out=sokGao.getOutputStream();
		 in=sokGao.getInputStream();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ChatMain() {
		setVisible(true);
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					sokGao.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
				
			}
			
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		textField = new JTextField();
		button = new JButton("\u53D1\u9001");
		list = new JList();
		label = new JLabel("\u597D\u53CB\u5217\u8868");
		label_1 = new JLabel("\u8BA8\u8BBA\u7EC4");
		list_1 = new JList();
		
		menuBar = new JMenuBar();

//		scroll = new JScrollPane(textArea);
//		
//		scroll.setHorizontalScrollBarPolicy( 
//				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
//		scroll.setVerticalScrollBarPolicy( 
//				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		
//		contentPane.add(scroll);
		
		
		
		
		
		
		
		textField.setBounds(125, 290, 271, 21);
		contentPane.add(textField);
		textField.setColumns(10);
				
		button.setBounds(406, 289, 64, 23);
		contentPane.add(button);
		
		
		menuBar.setBounds(0, 0, 177, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5237\u65B0");
		menu.add(menuItem_3);
		
		JMenuItem menuItem_1 = new JMenuItem("\u67E5\u770B\u597D\u53CB");
		menu.add(menuItem_1);
		
		JMenuItem menuItem = new JMenuItem("\u67E5\u770B\u8BA8\u8BBA\u7EC4");
		menu.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("\u9000\u51FA");
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("\u7F16\u8F91");
		menuBar.add(menu_1);
		
		JMenuItem mntmip = new JMenuItem("\u76F8\u5173IP");
		menu_1.add(mntmip);
		
		JMenu menu_2 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8BF4\u660E");
		menu_2.add(menuItem_4);
		
		JMenu menu_3 = new JMenu("\u5176\u4ED6\u529F\u80FD");
		menuBar.add(menu_3);
		

		list.setBounds(115, 266, -103, -179);
		contentPane.add(list);
		
		
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		label.setBounds(10, 31, 89, 35);
		contentPane.add(label);
		
		
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		label_1.setForeground(Color.MAGENTA);
		label_1.setBounds(508, 31, 73, 35);
		contentPane.add(label_1);
		

		list_1.setBounds(492, 266, 89, -185);
		contentPane.add(list_1);
		textArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(126, 31, 344, 249);
		contentPane.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		
		textArea.setBounds(154, 31, 241, 233);
		
		/*
		 * µã»÷ÊÂ¼þ
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")) return;
				String mess=textField.getText();
				try {
					textArea.append(InetAddress.getLocalHost().getHostAddress()+":"+mess+"\r\n\r\n");
					textArea.setSelectionEnd(mess.length());
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				byte[] outbuf=mess.getBytes();
				try {
					out.write(outbuf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				byte[] inbuf=new byte[1024];
				int len=0;
				try {
					 len=in.read(inbuf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String outMess=new String(inbuf,0,len);
				String ip=sokGao.getInetAddress().getHostAddress();
				textArea.append(ip+":"+outMess+"\r\n\r\n");
				textArea.setSelectionEnd(outMess.length());
				
			}
		});
		
		JButton button_1 = new JButton("\u673A\u5668\u4EBA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		button_1.setBounds(488, 289, 93, 23);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("\u5F53\u524D\u72B6\u6001\uFF1A");
		label_2.setBounds(10, 329, 64, 15);
		contentPane.add(label_2);
		
		JLabel label_4 = new JLabel("\u672C\u673AIP\uFF1A");
		label_4.setBounds(10, 354, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_3 = new JLabel("\u5728\u7EBF");
		label_3.setBounds(84, 329, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_5 = null;
		try {
			label_5 = new JLabel(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label_5.setBounds(74, 354, 106, 15);
		contentPane.add(label_5);
	//	contentPane.add(textArea);
		
		
	//connServer();
		
	}
}
