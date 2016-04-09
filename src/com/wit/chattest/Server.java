package com.wit.chattest;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Server {	
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(33333);
		while(true){
		new Thread(new ChatSend(ss.accept())).start();
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
			     pw.println("ƒ„ «÷Ìma");    
			}catch(IOException e){
				e.printStackTrace();
			}
			}catch(IOException ei){
				ei.printStackTrace();
			}
					
	}
	}
}