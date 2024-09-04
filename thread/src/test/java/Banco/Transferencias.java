package Banco;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transferencias extends Thread {

	private Banco banco;
	private int cuenta;
	private int monto;
	private Random rand;
	private boolean vivo = true;
	
	public Transferencias(Banco banco, int cuentaOrigen, int monto) {
		
		this.banco = banco;
		this.cuenta = cuentaOrigen;
		this.monto = monto;
		rand = new Random (System.currentTimeMillis());
		
	}//constructor
	
	@Override
	public void run(){
		try { 
		while (vivo) {
		int cuentaDestino = rand.nextInt(100);
		while(cuenta == cuentaDestino) {
			cuentaDestino = rand.nextInt(100);
		}
		
		banco.transferir(cuenta, cuentaDestino, this.monto);
		Thread.sleep(rand.nextInt(100));
		this.matar();
	}//while vivo
		}catch(InterruptedException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,null,ex);
		}
	
	
}//run
	
	public void matar() {
		this.vivo = false;
	}
	
}