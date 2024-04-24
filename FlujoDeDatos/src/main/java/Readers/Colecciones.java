package Readers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Colecciones {
	//vector
	int [] vec = new int [5];
	
	//lista
	List nombres = new ArrayList<>();
	List <String> apellido = new ArrayList<>();
	
	//ArayList
	ArrayList<String> frutas = new ArrayList<>();
	ArrayList verduras = new ArrayList<>(); 
	
	LinkedList<String> componentesPc1 = new LinkedList<>(); 
	//LinkedList: listas (funciona igual q el array).Pero es eficiente a la hora de agg inf nueva.
	List precios1 = new LinkedList<>(); //
	
	LinkedList<String> componentesPc = new LinkedList<>();
	List precios = new LinkedList<>();
	
	HashMap<String, String> listaEspañolIngles = new LinkedHashMap<>();
	Map<Integer, Integer> valores = new LinkedHashMap<>();

	LinkedHashSet<Integer> listaInglesEspañol = new LinkedHashSet<>();
	Set<Integer> valores2 = new LinkedHashSet<>();
	
	//Diccionario: clave, valor.
	HashMap<String, String> españolRAE = new HashMap<>();
	Map<String, Integer> españolIngles = new HashMap<>();
	
	
	HashSet<String> claves = new HashSet<>();
	Set<Integer> DNI = new HashSet<>();
	//se utiliza como un array pero todos os datos de un set son unicos.
	
	public void Array()
	{
		frutas.add("");
		verduras.add(5); //objec puedo mandar lo que yo quiera.
		verduras.add("s");
		
		frutas.clear(); //vacia por completo
		frutas.remove(5);// lo que esta en la posicion 5
		frutas.remove("manzana"); //busca y borra ese dato particular.
		
		verduras.contains("tomate"); //existe o no (boolean)
		verduras.containsAll(new ArrayList<>()); 
		
		frutas.get(5); //devuelve lo que esta en la posicion 5.
		frutas.indexOf("banana"); // busca banana y me devuelve la posicion.
		
		verduras.isEmpty(); // tiene algo o no tiene nada
		verduras.size(); // cant de elememtos que tiene la lista
	}
	
	
}
