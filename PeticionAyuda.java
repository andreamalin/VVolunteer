/**********************************************************
PeticionAyuda.java	
Integrantes grupo:
-> Andrea Amaya 19357
-> Diego Alvarez 19498
-> Diego Crespo 19541
-> Brandon Hernandez 19376
-> Laura Tamath 19365	

Autor de la clase:
-> Diego Alvarez 19498

Fecha de creación: 31/09/2019
Última fecha de modificación: 05/09/2019

La clase PeticionAyuda se encarga de pedir los datos del usuario que
reporta ayuda y mandar la ayuda lo antes posible.
**********************************************************/
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
public class PeticionAyuda{
	private boolean bandera;
	// se crearon variables 

	public void setInfo(String[] datosUsuario){
	  
	    try(FileWriter fw = new FileWriter("notificaciones.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {

		        out.println(datosUsuario[0] + " " + datosUsuario[1] + " " + datosUsuario[2] + " " + datosUsuario[3]+ ". ");       
		}catch (IOException e) {
		}
	}
	//Se agregan los cambios de medicamento
	public void setRecomendaciones(String recomendacion, String nombrecentro){
	    try(FileWriter fw = new FileWriter("notificaciones.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {
		    	out.println("\nRecomendaciones para la siguiente jornada en "+ nombrecentro + "\n" + recomendacion);       
		}catch (IOException e) {
		}
	}
	// se retorna la informacion
	public String getInfo(){
		String info = "";
		int contador = 0;
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		File f = new File( "C:notificaciones.txt" );
		BufferedReader entrada;
		try {
			entrada = new BufferedReader(new FileReader(f));
				
				while(entrada.ready()){
					contador +=1;
					info += "| "+ contador  +" \t" + entrada.readLine() + "\n";

				}
				
		}catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}
	// se retorna las recomendaciones
	public String getRecomendaciones(){
		String info = "";
		int contador = 0;
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		File f = new File( "C:Recomendaciones.txt" );
		BufferedReader entrada;
		try {
			entrada = new BufferedReader(new FileReader(f));
				
				while(entrada.ready()){
					contador +=1;
					info += "| "+ contador  +" \t" + entrada.readLine() + "\n";

				}
				
		}catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}	
	// Eliminar
	public void eliminarNoti(int o){










		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
	/*	File f = new File( "C:notificaciones.txt" );
		ArrayList<String> texto = new ArrayList<String>();
		BufferedReader reader;
//		int contador=0;		Contador para repetir for e ingresar nuevas notificaciones separadas		
		try {
			reader = new BufferedReader(new FileReader("notificaciones.txt"));	
		
		String line = reader.readLine();			//MANDA TEXTO DE NOTIFICACION.TXT A ARRAYLIST.
		while (line != null) {
			texto.add(line);
			// read next line
			line = reader.readLine();
	//		contador++;
		}
		reader.close();
		texto.remove(o-1);			//ELIMINA LA NOTIFICACION SOLICITADA

		try(FileWriter fw = new FileWriter("notificaciones.txt", true);			//ESCRIBE EN NOTIFICACIONES.TXT EL ARRAY CON LA NOTIFICACION YA ELIMINADA
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw))
		{	//		String x;
	//	for (int i= 0 ; i < contador ; i++ ){
	//		x = texto.get(i).toString();
			out.println(texto);       
	//	 	}
		}
		catch (IOException e) 
		{
		}
	//	System.out.println(texto);    PARA VERIFICAR QUE HAY DENTRO DEL NUEVO TXT ACTUALIZADO
		}
	catch (IOException e) {
		e.printStackTrace();
		}
		*/
	}
	










	public void eliminarReco(int i){
		// se concatenan los datos ingresados por el usuario y con sus especificaciones en una variable de tipo texto para mostrarla
		File f = new File( "C:notificaciones.txt" );
		ArrayList<String> texto2 = new ArrayList<String>();
		BufferedReader reader;
//		int contador=0;														Contador para repetir for e ingresar nuevas notificaciones separadas		
		try {
			reader = new BufferedReader(new FileReader("Recomendaciones.txt"));	
		
		String line = reader.readLine();			//MANDA TEXTO DE RECOMENDACION.TXT A ARRAYLIST.
		while (line != null) {
			texto2.add(line);
			// read next line
			line = reader.readLine();
	//		contador++;
		}
		reader.close();
		texto2.remove(i-1);			//ELIMINA LA RECOMENDACION SOLICITADA

		try(FileWriter fw = new FileWriter("notificaciones.txt", true);			//ESCRIBE EN RECOMENDACIONES .TXT EL ARRAY CON LA NOTIFICACION YA ELIMINADA
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw))
		{	//		String x;
	//	for (int i= 0 ; i < contador ; i++ ){
	//		x = texto.get(i).toString();
			out.println(texto2);       
	//	 	}
		}
		catch (IOException e) 
		{
		}
		System.out.println(texto2);
		}
	catch (IOException e) {
		e.printStackTrace();
		}
	}


	
	/*
	public void setInfo(String[] datosUsuario){
	    int contador = 0;
	    contador += 1;
	    try(FileWriter fw = new FileWriter("notificaciones.txt", true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw))
		    {

		        out.println("\n" + contador + "." + datosUsuario[0] + " " + datosUsuario[1] + " " + datosUsuario[2] + " " + datosUsuario[3]+ ". ");       
		}catch (IOException e) {
		}
	}
	*/



	// se crea un numero aleatorio para verificar si se puede ayudar 
	// a la persona inmediatamente 
	public boolean enCamino(){
		Random r = new Random();
		int r1 = r.nextInt(10);
		if (r1 == 5){
			bandera = true;
		}
		else{
			bandera = false;
		}
	return bandera;

	}
}

