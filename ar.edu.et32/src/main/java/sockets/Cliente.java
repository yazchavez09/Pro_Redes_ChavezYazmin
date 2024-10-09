package sockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	
	InetAddress IP;
	int puerto = 666;
	
	Socket sock;
	DataInputStream dis;
	DataOutputStream dos;
	InputStreamReader isr;
	BufferedReader buff;
	PrintStream ps;
	
	public Cliente() 
	{
		
	
	try {
		IP = InetAddress.getByName("localhost");
		sock = new Socket(IP,puerto);
		//canal de comunicación
		dis = new DataInputStream(sock.getInputStream());
		dos = new DataOutputStream(sock.getOutputStream());
		isr = new InputStreamReader(System.in);
		buff = new BufferedReader (isr);
		ps = new PrintStream(System.out);
		
		Thread enviarMensajes = new Thread(
				new Runnable() 
				{
					private boolean vivo = true;
					@Override
					public void run () 
					{
						//estandariza a UTF
						String msg = "";
						try {
							while(true && msg.equalsIgnoreCase("/salir"))
							{
							msg = buff.readLine();
							
							dos.writeUTF(msg);
							ps.print("\n->");
							}
						} catch (IOException e) {
							Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null, e);
						}
					}
				}
				);
		
		enviarMensajes.setName("enviar");
		enviarMensajes.start();
		
		
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}//FIN CLASE