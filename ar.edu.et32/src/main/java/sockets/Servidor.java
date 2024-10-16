package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread{
	
	public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_MAGENTA = "\u0033[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
	
    PrintStream ps;
    LinkedList <ClienteCli> ClientesConectados;
    
    ServerSocket serverSock; //socket adicional preparada para ser servidor
    Socket sockCli;
    DataInputStream dis;
    DataOutputStream dos;
    int puerto = 7777;
    
    public Servidor () 
    {
    	try {
    		ps = new PrintStream(System.out);
    		dis = null;
    		dos = null;
    		ClientesConectados = new LinkedList<ClienteCli>;
    	
    		serverSock = new ServerSocket (puerto);
    		//verificacion d clientes conectados
    	
    	}catch(IOException ex)
    	{
    		Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	
    }
    
    @Override
    public void run()
    {
    	while (true)
    	{
    		try {
    		ps.println ("Esperando conexion de un cliente...\n");
    		sockCli = serverSock.accept();
    		
    		ps.println(Servidor.ANSI_CYAN
    				+"Cliente conectado: "
    				+ sockCli.getInetAddress().getCanonicalHostName() //IP del cliente y num d IP o nombre (Name)
    				+ Servidor.ANSI_RESET
    				);
    		
    		dis = new DataInputStream ( sockCli.getInputStream());
    		dos = new DataOutputStream (sockCli.getOutputStream());
    		
    		ps.println(Servidor.ANSI_CYAN
    				+ "Creando un cliente...esperando identificación..."	
    				+ Servidor.ANSI_RESET
    			);	
    		String nickName dis.readUTF();
    		
    		ClienteCli cli = new ClienteCli(sockCli, nickName, dis, dos);
    		ClientesConectados.add(cli);
    		
    		ps.println(Servidor.ANSI_RED
    				+"El cliente"
    				+cli.getNickName()
    				+ "accedio al servidor.\n"
    				+Servidor.ANSI_RESET
    				);
    		
    		cli.getHilo().start();
    		cli.notificarClientes(true);
    		}catch(IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
    		}//catch
    		
    		
    	}
    }
}
