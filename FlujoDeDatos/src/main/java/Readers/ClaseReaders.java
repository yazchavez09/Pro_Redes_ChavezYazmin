package Readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaseReaders {

	
	PrintStream ps;
	//Sub clases de Readers
	
	//1.entrada de info
	InputStreamReader isr; //lectura d string
	
	BufferedReader br ; //precarga inf
	
	
	
	public ClaseReaders() {
		
		isr = new InputStreamReader ( System.in );
		br = new BufferedReader(isr);
		
		ps = new PrintStream (System.out);
	}
	
	public String leer() {
		
		try {
			return br.readLine();
		} catch (IOException e) {
			Logger.getLogger(ClaseReaders.class.getName() ).log(Level.WARNING, null, e);
		}
		return null;
	}
}
