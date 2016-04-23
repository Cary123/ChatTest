package com.wit.chattest;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Server {	
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(33333);
		Socket s;
		OutputStream out;
		InputStream in;
		String notice;

		while(true){
			s=ss.accept();
			in=s.getInputStream();
			byte[] head=new byte[1024];
			int len=in.read(head);
			notice=new String(head,0,len);
			if(notice.trim().equals("chat_begin_conn"))
				new Thread(new ChatSend(s)).start();
			if(notice.trim().equals("login_begin_conn"))
				new Thread(new ChatLogin(s)).start();
			if(notice.trim().equals("register_begin_conn"))
				new Thread(new ChatRegister(s)).start();
			
		}

}
	}

class ChatLogin implements Runnable{
	Socket s=null;
	ChatLogin(Socket s){
		this.s=s;
	}
	public void run() {
		String ip=s.getInetAddress().getHostAddress();
		if(s.isClosed())
			 try{s.close();}catch(Exception e){ };
		try{
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		String mess=new String(buf,0,len);
		System.out.println(mess);
		
		FileReader inuser=new FileReader("c:\\project\\user.txt");
		BufferedReader bis=new BufferedReader(inuser);
		String line;
		String[] num=mess.split("=");
		try {
                            
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			while((line=bis.readLine())!=null){
				if(line.startsWith(num[0])){
					String[] user=line.split("=");
					if(line.equals(mess)){
						pw.println("µÇÂ¼³É¹¦");
						s.close();
						bis.close();
						return;
					}
					else{
						pw.println("µÇÂ¼Ê§°Ü");
						s.close();
						bis.close();
						return;
					}
				
				}
			}
			pw.println("µÇÂ¼Ê§°Ü");
			s.close();
			bis.close();
			
			
		      
		}catch(IOException e){
			e.printStackTrace();
		}
		}catch(IOException ei){
			ei.printStackTrace();
		}
	}
}



class ChatRegister implements Runnable{
	Socket s;
	ChatRegister(Socket s){
		this.s=s;
	}
	public void run() {
		    String ip=s.getInetAddress().getHostAddress();
			if(s.isClosed())
				 try{s.close();}catch(Exception e){ };
			try{
			InputStream in=s.getInputStream();
			byte[] buf=new byte[1024];
			int len=in.read(buf);
			String mess=new String(buf,0,len);
			System.out.println(mess);
			
			FileReader inuser=new FileReader("c:\\project\\user.txt");
			BufferedReader bis=new BufferedReader(inuser);
			FileWriter outuser=new FileWriter("c:\\project\\user.txt",true);
			BufferedWriter outbis=new BufferedWriter(outuser);
		
			String line;
			String[] num=mess.split("=");
			try {
                                
				PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
				while((line=bis.readLine())!=null){
					if(line.startsWith(num[0])){
					pw.println("ÕËºÅÒÑ¾­´æÔÚ£¡");
					s.close();
					bis.close();
					outbis.close();
					return;
					}
				}
				pw.println("×¢²á³É¹¦£¡");
				s.close();
				outbis.write(mess);
				outbis.newLine();
				bis.close();
				outbis.close();
				
				
			      
			}catch(IOException e){
				e.printStackTrace();
			}
			}catch(IOException ei){
				ei.printStackTrace();
			}
					
	}
}

class ChatSend implements Runnable{	
	Socket s;
	ChatSend(Socket s){
		this.s=s;
	}
	public void run() {
		String ip=s.getInetAddress().getHostAddress();
		flag:while(true){
			if(s.isClosed())
				 try{s.close();}catch(Exception e){ };
			try{
			InputStream in=s.getInputStream();
			byte[] buf=new byte[1024];
			int len=in.read(buf);
			String mess=new String(buf,0,len);
			System.out.println(mess+len);
			
			FileReader inciku=new FileReader("c:\\project\\ciku.txt");
			BufferedReader bis=new BufferedReader(inciku);
		
			String line;
			try {
                                PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
				while((line=bis.readLine())!=null){
					if(line.equals(mess))
					{	
						pw.println(bis.readLine());
						continue flag;
					}
                                         
				}
			     pw.println("ÄãÊÇÖí");    
			}catch(IOException e){
				e.printStackTrace();
			}
			}catch(IOException ei){
				ei.printStackTrace();
			}
					
	}
	}
}