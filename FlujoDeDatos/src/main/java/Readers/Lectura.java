package Readers;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lectura {
	// Stream  
	// Stream  IN
	// Stream  OUT
	// Stream  ERR
	
	PrintStream ps;
	
	public Lectura()
	{
		//Intermediario entre la escritura y el canal
		ps = new PrintStream( System.out );
		
		System.out.println("Byte:");
		//Scanner s = new Scanner(System.in);
		//System.err.println();
		
		
		//byte a byt
	}
}
