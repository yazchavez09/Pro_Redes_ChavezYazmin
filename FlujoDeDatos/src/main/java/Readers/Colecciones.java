package Readers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Colecciones {
	//vector
	int [] vec = new int [5];
	
	//lista INTERFACE. Nos sirve para trabaajr con sus hijos.
	List nombres = new ArrayList<>();
	List <String> apellido = new ArrayList<>();
	
	//ArayList EFICIENTE PARA LECTURA
	ArrayList<String> frutas = new ArrayList<>();
	ArrayList verduras = new ArrayList<>(); 
	
	LinkedList<String> componentesPc1 = new LinkedList<>(); 
	//LinkedList: listas (funciona igual q el array).Pero es eficiente a la hora de agg inf nueva.
	List precios1 = new LinkedList<>(); //
	
	LinkedList<String> componentesPc = new LinkedList<>();
	List precios = new LinkedList<>();
	//LinkedHashMap FACILITA LA LECTURA
	HashMap<String, String> listaEspaniolIngles = new LinkedHashMap<>();
	Map<Integer, Integer> valores = new LinkedHashMap<>();

	LinkedHashSet<Integer> listaInglesEspaniol = new LinkedHashSet<>();
	Set<Integer> valores2 = new LinkedHashSet<>();
	
	//Diccionario: clave, valor.
	HashMap<String, String> espaniolRAE = new HashMap<>();
	Map<String, Integer> espaniolIngles = new HashMap<>();
	
	
	HashSet<String> claves = new HashSet<>();
	Set<Integer> DNI = new HashSet<>();
	//se utiliza como un array pero todos los datos de un set son unicos. 
	
	public void Array()
	{
		frutas.add(""); //agrgar nuevo elemento
		verduras.add(5); //objec puedo mandar lo que yo quiera.
		verduras.add("s");
		
		frutas.clear(); //vacia por completo
		frutas.remove(5);// lo que esta en la posicion 5
		frutas.remove("manzana"); //busca y borra ese dato particular.
		
		verduras.contains("tomate"); //existe o no (boolean)
		verduras.containsAll(new ArrayList<>()); 
		
		frutas.get(5); //devuelve lo que esta en la posicion 5.
		frutas.indexOf("banana"); // busca banana y me devuelve la posicion. Si no está,devuelve un -1
		
		verduras.isEmpty(); // tiene algo o no tiene nada
		verduras.size(); // cant de elememtos que tiene la lista
		
		Object[] ver = verduras.toArray(); //util cuando trabajemos con soquets
		
	}
	
	public void Recorridos()
	{
		//FOR normal
		for( int i = 0 ; i <= frutas.size() ; i++)
		{
			frutas.get(i);
		}
		
		//FOR EACH
		for( String item : frutas )
		{
			System.out.println( item ); 
		}
		
		Iterator it = frutas.iterator();
		
		while( it.hasNext())
		{	
			it.remove();
			it.next();
		}
		//Map's Set's
		//Map's (k,v)
		for(String traduccion: espaniolRAE.keySet()) {
			
		}
		
		for(String traduccion: espaniolRAE.values()) {
			
		}
		Iterator it2 = espaniolRAE.keySet().iterator();
		
		while( it2.hasNext())
		{	
			Object key = it2.next();//k
			espaniolRAE.get(key); //v
		}
		
		for(Map.Entry<String, String> e : espaniolRAE.entrySet()) {
			e.getKey();
			e.getValue();
			
		}
		Collections.sort(verduras, Collections.reverseOrder());
		
	}
}

