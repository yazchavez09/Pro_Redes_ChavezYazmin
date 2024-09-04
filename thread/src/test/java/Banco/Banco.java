package Banco;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	
	private Map<Integer, Integer>cuentas;
	private PrintStream ps = new PrintStream(System.out);
	private Lock cierreDeBanco = new ReentrantLock();
	private Condition saldoSuficiente;
	
	public Banco (int cantCuentas, int montoInicial) {
		
		cuentas = new HashMap<>();
		
		saldoSuficiente = cierreDeBanco.newCondition();
		
		for (int nro=0; nro<cantCuentas;nro++) {
			cuentas.put(nro, montoInicial);
		}
		
		
		
	}
	public void transferir(int cuenta, int cuentaDestino, int monto) {
		
	}
}
