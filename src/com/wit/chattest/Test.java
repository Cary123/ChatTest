package com.wit.chattest;
/*
import java.io.*;

import java.util.Scanner;
*/
/*
public class Test {
	public static void main(String[] args){
		fun();
	//	fun2();
	//	fun1();
	//	fun3();
	//	fun4();  
	}
	public static void fun(){
	boolean flag=true;
	while(flag){
	System.out.print("问:");
	Scanner input=new Scanner(System.in);
	String message=input.nextLine();
	if(message.equals("over")){
		flag=false;
	}
	try {
		FileReader in=new FileReader("E:\\dic\\ciku.txt");
		BufferedReader bis=new BufferedReader(in);
		String line;
		try {
			while((line=bis.readLine())!=null){
				if(line.equals(message)){
					System.out.println("回答："+bis.readLine());
					break;
				}
			}
		bis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	}
	public static void fun1(){
		boolean flag=true;
		String message;
		Scanner input=new Scanner(System.in);
		while(flag){
		System.out.print("问:");
		message=input.nextLine();
		if(message.equals("over")){
			flag=false;
		}
		try {
			FileReader in=new FileReader("E:\\dic\\ciku3.txt");
			BufferedReader bis=new BufferedReader(in);
			String line;
			try {
				String[] arry;
				while((line=bis.readLine())!=null){
					if(line.startsWith(message)){
						arry=line.split("\t+");
						sop("回答："+arry[1]);
						break;
					}
				}
			bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	
	public static void fun2(){
		try{
			    FileReader in=new FileReader("E:\\dic\\ciku2.txt");
			//	FileInputStream in=new FileInputStream("E:\\dic\\ciku2.txt");
				FileWriter out=new FileWriter("E:\\dic\\ciku4.txt",true);
			//	BufferedReader bis=new BufferedReader(new InputStreamReader(in,"GBK"));
				BufferedReader bis=new BufferedReader(in);
				BufferedWriter bos=new BufferedWriter(out);
				String line;
				while((line=bis.readLine())!=null){
						if(!line.equals(""))
						{
							bos.write(line);
							bos.newLine();
							
							
						}
						     
					     
						
					}

				 bis.close();
				 bos.close();
	}catch(IOException e){
		e.printStackTrace();
	}
 }
	public static void sop(Object obj){
		System.out.println(obj);
	}
	public static void fun3(){ 
		       String filename1="E:\\dic\\ciku2.txt";  
		       String filename2="E:\\dic\\ciku3.txt";  
		        File file=new File(filename1);  
		        InputStream is=null;  
		        BufferedReader br = null;  
		        String tmp;  
		        FileWriter writer=null;   
		        try {  
		            is=new BufferedInputStream(new FileInputStream(file));  
		            br = new BufferedReader(new InputStreamReader(is, "GBK"));  
		            writer = new FileWriter(filename2, true);  
		            while((tmp=br.readLine())!=null){  
		                if(tmp.equals(""));  
		                else{  
		                    writer.write(tmp+"\r\n"); 
		            
		                }  
		            }  
		            writer.close();  
		            is.close();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		    }  
	public static void fun4(){ 
		String line="公司 		哪个公司?";
		String message="公司";
		String[] arry;
		char[] ch=line.toCharArray();
		for(char i:ch){
		//	sop(i);
		}
			if(line.startsWith(message)){
				arry=line.split("\t+");
				System.out.println("回答："+arry[1]);
	}
	}
}
*/


/*
import java.awt.*;
import javax.swing.*;
public class Test extends JFrame {
	
    JPanel p=new JPanel();
	JTextArea txaDisplay = new JTextArea(); 
	JScrollPane scroll = new JScrollPane(txaDisplay); 

	//分别设置水平和垂直滚动条自动出现 
	Test(){
	this.setLayout(new BorderLayout());
	this.add(p);
	p.setLayout(new BorderLayout());
	scroll.setHorizontalScrollBarPolicy( 
	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
	scroll.setVerticalScrollBarPolicy( 
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	scroll.getViewport().add(txaDisplay);
	p.add(scroll);
	
	this.setSize(500,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	}
	public static void main(String[] args){
		new Test();
	}
}
*/












